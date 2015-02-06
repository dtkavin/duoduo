/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.user.action;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.utils.CookieUtils;
import org.fls.common.utils.DesUtils;
import org.fls.user.entity.FlsUserEntity;
import org.fls.user.service.UserService;
import org.fls.userinfo.service.UserInfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 用户处理
 *
 * @author Tone
 */
@Controller("UserAction")
@Scope("session")
public class UserAction extends AbstractFlsBaseAction {

    private Map<String, Object> session;
    private Map<String, Object> request;
    private Map<String, Object> application;
    @Resource
    private UserService userService;
    @Resource
    private UserInfoService userInfoService;
    //验证码
    private String securityCode;
    // 验证邮箱时使用的ID
    private String registerId;

    /**
     * 验证
     *
     * @return String
     * @throws Exception
     */
    public String authenticator() throws Exception {
        FlsUserEntity userEntity_db = userInfoService.getUserInfoByID(getRegisterId());

        if ("T".equals(userEntity_db.getUser_flag())) {
            this.setMessage(NOMSG, "已验证");
            return SUCCESS + "_login";
        } else {
            userEntity_db.setUser_flag("T");
            FlsMsgEntity msgEntity = userInfoService.updateUserInfo(userEntity_db);
            if (msgEntity.isFlag()) {
                this.setMessage(YESMSG, "验证成功");
                return SUCCESS + "_login";
            } else {
                this.setMessage(NOMSG, msgEntity.getMessage());
                return  ERROR;
                
            }

        }

    }
    private String login_email;
    private String login_password;
    //记录Cookies时间
    private String rememberme;

    /**
     * 登录
     *
     * @return String
     * @throws Exception
     */
    public String login() throws Exception {
        String serverCode_session = (String) session.get("SESSION_SECURITY_CODE");
        // System.out.println("serverCode_session:" + serverCode_session);
        // System.out.println("securityCode:" + getSecurityCode());
        if (!serverCode_session.equals(securityCode)) {
            this.setMessage(NOMSG, "验证码不正确");
            return INPUT + "_login";
        }

        FlsUserEntity userEntity = new FlsUserEntity();
        userEntity.setUser_mail(getLogin_email());
        userEntity.setUser_password(getLogin_password());

        FlsMsgEntity msgEntity = userService.login(userEntity);
        if (msgEntity.isFlag()) {
            this.session.put(LOGIN_USER, msgEntity.getLoginUser());
            this.request.remove(NOMSG);
            this.request.remove(YESMSG);

            int days = Integer.valueOf(rememberme);
            //  System.out.println("days:"+days);
            if (days != 0) {

                ServletActionContext.getResponse().addCookie(CookieUtils.getCookie(login_email, login_password, days));

            }

            return SUCCESS + "_main";
        } else {
            if ("NOVIL".equals(msgEntity.getMessage())) {
                this.setMessage(NOMSG, "请验证注册邮箱");
                this.request.put("reg_email", login_email);
                return SUCCESS + "_authenticator";
            } else {
                this.setMessage("nomsg", msgEntity.getMessage());
                return INPUT + "_login";
            }
        }


    }
    //注册邮箱
    private String reg_email;
    //注册名
    private String reg_nickname;
    //密码
    private String reg_password;

    /**
     * 注册
     *
     * @return String
     * @throws Exception
     */
    public String register() throws Exception {
        // System.out.println("注册");
        String serverCode_session = (String) session.get("SESSION_SECURITY_CODE");
        // System.out.println("serverCode_session:" + serverCode_session);
        // System.out.println("securityCode:" + getSecurityCode());
        if (!serverCode_session.equals(securityCode)) {
            this.setMessage(NOMSG, "验证码不正确");
            return INPUT + "_register";
        }

        DesUtils desUtils = new DesUtils();
        FlsUserEntity userEntity = new FlsUserEntity();
        userEntity.setUser_mail(getReg_email());
        userEntity.setUser_name(getReg_nickname());
        //后期考虑邮箱验证
        userEntity.setUser_flag("T");
        userEntity.setUser_password(desUtils.encrypt(getReg_password()));

        FlsMsgEntity msgEntity = userService.register(userEntity);

        if (msgEntity.isFlag()) {
            //=====================发送验证邮件


            //====================
            this.setMessage(YESMSG, msgEntity.getMessage());
            this.setMessage("reg_email", reg_email);
            return SUCCESS + "_authenticator";
        } else {
            this.setMessage(NOMSG, msgEntity.getMessage());
            return INPUT + "_register";
        }


    }

    /**
     * 注销
     *
     * @return String
     * @throws Exception
     */
    public String logout() throws Exception {

        String userid = ((FlsUserEntity) session.get("LOGIN_USER")).getUser_mail();
        String userpw = ((FlsUserEntity) session.get("LOGIN_USER")).getUser_password();
        ServletActionContext.getResponse().addCookie(CookieUtils.getCookie(userid, userpw, 0));
        //移除Session
        this.session.remove(LOGIN_USER);
        return SUCCESS + "_logout";
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.application = map;
    }

    @Override
    public void setMessage(String mesFalg, String message) {
        this.request.put(mesFalg, message);
    }

    /**
     * @return the securityCode
     */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * @param securityCode the securityCode to set
     */
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    /**
     * @return the reg_email
     */
    public String getReg_email() {
        return reg_email;
    }

    /**
     * @param reg_email the reg_email to set
     */
    public void setReg_email(String reg_email) {
        this.reg_email = reg_email;
    }

    /**
     * @return the reg_nickname
     */
    public String getReg_nickname() {
        return reg_nickname;
    }

    /**
     * @param reg_nickname the reg_nickname to set
     */
    public void setReg_nickname(String reg_nickname) {
        this.reg_nickname = reg_nickname;
    }

    /**
     * @return the reg_password
     */
    public String getReg_password() {
        return reg_password;
    }

    /**
     * @param reg_password the reg_password to set
     */
    public void setReg_password(String reg_password) {
        this.reg_password = reg_password;
    }

    /**
     * @return the registerId
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * @param registerId the registerId to set
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    /**
     * @return the login_email
     */
    public String getLogin_email() {
        return login_email;
    }

    /**
     * @param login_email the login_email to set
     */
    public void setLogin_email(String login_email) {
        this.login_email = login_email;
    }

    /**
     * @return the login_password
     */
    public String getLogin_password() {
        return login_password;
    }

    /**
     * @param login_password the login_password to set
     */
    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    /**
     * @return the rememberme
     */
    public String getRememberme() {
        return rememberme;
    }

    /**
     * @param rememberme the rememberme to set
     */
    public void setRememberme(String rememberme) {
        this.rememberme = rememberme;
    }
}

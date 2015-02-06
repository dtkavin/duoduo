/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.user.entity.FlsUserEntity;
import org.fls.user.service.UserService;
import org.springframework.stereotype.Component;

/**
 *cookie登录拦截器
 * @author Tone
 */
@Component("FlsCookieLoginInterceptor")
public class FlsCookieLoginInterceptor extends AbstractInterceptor {

    @Resource
    private UserService userService;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
       // System.out.println("---------------------FlsCookieLoginInterceptor");
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        FlsUserEntity userEntity_session = (FlsUserEntity) ServletActionContext.getRequest().getSession().getAttribute("LOGIN_USER");
        if (userEntity_session != null) {

            return actionInvocation.invoke();
        }
        String user_id = "";
        String user_pw = "";
        if (cookies != null) {

            for (Cookie cookie : cookies) {
                if ("ReUser".equals(cookie.getName())) {
                    user_id = cookie.getValue().split("#")[0];
                    user_pw = cookie.getValue().split("#")[1];
                }
            }
           // System.out.println("user_id:" + user_id);
            //System.out.println("user_pw:" + user_pw);
            if (!"".equals(user_id)
                    && !"".equals(user_pw)
                    && user_id != null
                    && user_pw != null
                    && ServletActionContext.getContext().getSession()
                    .get("LOGIN_USER") == null) {
                FlsUserEntity userEntity = new FlsUserEntity();
                userEntity.setUser_mail(user_id);
                userEntity.setUser_password(user_pw);
                FlsMsgEntity msgEntity = userService.login(userEntity);
                if (msgEntity.isFlag()) {

                    ServletActionContext.getContext().getSession().put("LOGIN_USER", msgEntity.getLoginUser());
                    actionInvocation.invoke();

                } else {
                    if ("NOVIL".equals(msgEntity.getMessage())) {
                        // this.setMessage("nomsg", "请验证注册邮箱");
                        ServletActionContext.getRequest().setAttribute("nomsg",
                                "请验证注册邮箱");
                        ServletActionContext.getRequest().setAttribute(
                                "reg_email", user_id);

                        return "success" + "_authenticator_cookie";
                    } else {
                        return actionInvocation.invoke();
                    }
                }
            }
        }
        return actionInvocation.invoke();

        


    }
}
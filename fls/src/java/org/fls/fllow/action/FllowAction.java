/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.fllow.action;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.fllow.service.FllowService;
import org.fls.user.entity.FlsUserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 处理关注的action 供ajax 使用
 *
 * @author Tone
 */
@Controller("FllowAction")
//@Scope("session")
@Scope("prototype")
public class FllowAction extends AbstractFlsBaseAction {

    private Map<String, Object> request;
    private Map<String, Object> session;
    private Map<String, Object> application;
    @Resource
    private FllowService fllowService;
  
   
    private InputStream inputStream;

    /**
     * 加关注
     *
     * @return  String
     * @throws Exception
     */
    public String addFllow() throws Exception {
        //  System.out.println("addFllow");
        HttpServletRequest request = ServletActionContext.getRequest();
        String viewUserID = request.getParameter("uid");
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);

        inputStream = fllowService.addFllow(viewUserID, userEntity_session.getUser_id());
        FlsUserEntity userEntity= fllowService.getUserForSession(userEntity_session.getUser_id());
      
       //System.out.println("最新关注数量:"+userEntity.getUser_funUsers().size());
       // System.out.println("最新粉丝数量:"+userEntity.getUser_funUsers().size());
        this.session.put(LOGIN_USER, userEntity);

        return SUCCESS;
    }

    /**
     * 加yes
     *
     * @return String
     * @throws Exception
     */
    public String add_yes() throws Exception {
        //   System.out.println("add_yes");
        HttpServletRequest request = ServletActionContext.getRequest();
        String theme_id = request.getParameter("id");

        inputStream = fllowService.add_yes(theme_id);
        return SUCCESS;

    }

    /**
     * 加no
     *
     * @return String
     * @throws Exception
     */
    public String add_no() throws Exception {
        
        // System.out.println("进入add_no");
        HttpServletRequest request = ServletActionContext.getRequest();
        // System.out.println("-------------------------------id:" + this.request.get("id"));
        String theme_id = request.getParameter("id");


        inputStream = fllowService.add_no(theme_id);
        return SUCCESS;

    }

    /**
     * 加入收藏
     *
     * @return  String
     * @throws Exception
     */
    public String addtofav() throws Exception{
        try {


            //System.out.println("addtofav");
            if (session.get("LOGIN_USER") == null) {
                this.setMessage("nomsg", "请先登录");


                inputStream = new StringBufferInputStream("NOT_LOGIN");
                return SUCCESS;
            }
            HttpServletRequest request = ServletActionContext.getRequest();
            String theme_id = request.getParameter("id");
            FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);


            inputStream = fllowService.addToFav(userEntity_session.getUser_id(), theme_id);

            this.session.put(LOGIN_USER, fllowService.getUserForSession(userEntity_session.getUser_id()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;


    }

    /**
     * 删除收藏
     *
     * @return  String
     * @throws Exception
     */
    public String delFromFav() throws Exception {
        if (session.get("LOGIN_USER") == null) {
            this.setMessage("nomsg", "请先登录");


            inputStream = new StringBufferInputStream("NOT_LOGIN");
            return SUCCESS;
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        String theme_id = request.getParameter("id");
        FlsUserEntity userEntity_session = (FlsUserEntity) this.session.get(LOGIN_USER);

        inputStream = fllowService.delFromFav(userEntity_session.getUser_id(), theme_id);

        this.session.put(LOGIN_USER, fllowService.getUserForSession(userEntity_session.getUser_id()));

        return SUCCESS;

    }

    @Override
    public void setMessage(String mesFalg, String message) {
        this.request.put(mesFalg, message);
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

    /**
     * @return the inputStream
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * @param inputStream the inputStream to set
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}

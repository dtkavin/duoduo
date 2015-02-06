/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userphoto.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.user.entity.FlsUserEntity;
import org.fls.user.service.UserService;
import org.fls.userinfo.service.UserInfoService;
import org.fls.userphoto.service.PhotoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 用户头像处理
 * @author Tone
 */
@Controller("PhotoAction")
@Scope("prototype")
public class PhotoAction extends AbstractFlsBaseAction {

    private String viewuser_id;
    private  String rand;
    private InputStream photoinputStream;
    @Resource
    private PhotoService photoService;
    @Resource
    private UserInfoService userInfoService;

    @Override
    public String execute() throws Exception {
        //this.photoinputStream=photoService.getUserPohtoByID(getViewuser_id());
        InputStream input=photoService.getUserPohtoByID(getViewuser_id());
        photoinputStream=input;
        
        
        
        return SUCCESS;
    }

    @Override
    public void setMessage(String mesFalg, String message) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the viewuser_id
     */
    public String getViewuser_id() {
        return viewuser_id;
    }

    /**
     * @param viewuser_id the viewuser_id to set
     */
    public void setViewuser_id(String viewuser_id) {
        this.viewuser_id = viewuser_id;
    }

    /**
     * @return the photoinputStream
     */
    public InputStream getPhotoinputStream() {
        return photoinputStream;
    }

    /**
     * @param photoinputStream the photoinputStream to set
     */
    public void setPhotoinputStream(InputStream photoinputStream) {
        this.photoinputStream = photoinputStream;
    }

    /**
     * @return the rand
     */
    public String getRand() {
        return rand;
    }

    /**
     * @param rand the rand to set
     */
    public void setRand(String rand) {
        this.rand = rand;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.action;

import java.io.ByteArrayInputStream;
import java.util.Map;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.common.utils.SecurityCode;
import org.fls.common.utils.SecurityCode.SecurityCodeLevel;
import org.fls.common.utils.SecurityImage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 验证码生成程序
 * @author Tone
 */
@Controller("SecurityCodeImageAction")
@Scope("session")
public class SecurityCodeImageAction extends AbstractFlsBaseAction{
    private Map<String, Object> session;
    
     private ByteArrayInputStream imageStream; 

    @Override
    public String execute() throws Exception {
        String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Simple, false).toLowerCase();
        
         //获取默认难度和长度的验证码
        // String securityCode = SecurityCode.getSecurityCode();
         imageStream = SecurityImage.getImageAsInputStream(securityCode);
         //放入session中
         session.put("SESSION_SECURITY_CODE", securityCode);
         return SUCCESS;
    }
    
    @Override
    public void setRequest(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.session = map;
        
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
        
    }

    /**
     * @return the imageStream
     */
    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    /**
     * @param imageStream the imageStream to set
     */
    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    @Override
    public void setMessage(String mesFalg, String message) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}

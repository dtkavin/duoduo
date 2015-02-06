/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.navigate.Action;

import java.util.Map;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 导航处理action
 *
 * @author Tone 给陈咏竹 打钱
 *
 * 吉林银行 6228 6520 0002 3446 844
 *
 *
 */
@Controller("NavigateAction")
@Scope("session")
public class NavigateAction extends AbstractFlsBaseAction {

    private String navFlag;
    private String imageurl;
    private String viewuser_imageuserid;

    public String navigate() {
        //System.out.println("执行 navigate");
        if (!"".equals(navFlag) && getNavFlag() != null) {
            return getNavFlag();
        } else {
            return ERROR;
        }


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
     * @return the navFlag
     */
    public String getNavFlag() {
        return navFlag;
    }

    /**
     * @param navFlag the navFlag to set
     */
    public void setNavFlag(String navFlag) {
        this.navFlag = navFlag;
    }

    @Override
    public void setMessage(String mesFalg, String message) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl the imageurl to set
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * @return the viewuser_imageuserid
     */
    public String getViewuser_imageuserid() {
        return viewuser_imageuserid;
    }

    /**
     * @param viewuser_imageuserid the viewuser_imageuserid to set
     */
    public void setViewuser_imageuserid(String viewuser_imageuserid) {
        this.viewuser_imageuserid = viewuser_imageuserid;
    }
}

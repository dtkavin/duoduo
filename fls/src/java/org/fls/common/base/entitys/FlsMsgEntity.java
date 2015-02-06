/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.entitys;

import org.fls.user.entity.FlsUserEntity;

/**
 *信息类 用于传递业务处理信息
 * @author Tone
 */
public class FlsMsgEntity {

    private String message = null;
    private boolean flag = false;
    private FlsUserEntity loginUser;
            

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * @return the loginUser
     */
    public FlsUserEntity getLoginUser() {
        return loginUser;
    }

    /**
     * @param loginUser the loginUser to set
     */
    public void setLoginUser(FlsUserEntity loginUser) {
        this.loginUser = loginUser;
    }
}

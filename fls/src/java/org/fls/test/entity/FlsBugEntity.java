/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.test.entity;

import java.util.Date;
import org.fls.user.entity.FlsUserEntity;

/**
 *
 * @author Tone
 */
public class FlsBugEntity {
    private String id;
    private String conent;
    private Date createDate;
    private String flag;
    private FlsUserEntity user;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the conent
     */
    public String getConent() {
        return conent;
    }

    /**
     * @param conent the conent to set
     */
    public void setConent(String conent) {
        this.conent = conent;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @return the user
     */
    public FlsUserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(FlsUserEntity user) {
        this.user = user;
    }
}

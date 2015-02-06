/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.reply.entity;

import java.util.Date;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.user.entity.FlsUserEntity;

/**
 *回复类
 * @author Tone
 */
public class FlsReplyEntity {

    private String reply_id;
    private String reply_content;
    private int reply_index;
    private Date reply_newtime;
    
    private FlsUserEntity reply_owner;
    private FlsThemeEntity reply_theme;

    //用于定位评论的具体页数
    private int currentPage_indexI;
    /**
     * @return the reply_id
     */
    public String getReply_id() {
        return reply_id;
    }

    /**
     * @param reply_id the reply_id to set
     */
    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    /**
     * @return the reply_content
     */
    public String getReply_content() {
        return reply_content;
    }

    /**
     * @param reply_content the reply_content to set
     */
    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    /**
     * @return the reply_index
     */
    public int getReply_index() {
        return reply_index;
    }

    /**
     * @param reply_index the reply_index to set
     */
    public void setReply_index(int reply_index) {
        this.reply_index = reply_index;
    }

    /**
     * @return the reply_newtime
     */
    public Date getReply_newtime() {
        return reply_newtime;
    }

    /**
     * @param reply_newtime the reply_newtime to set
     */
    public void setReply_newtime(Date reply_newtime) {
        this.reply_newtime = reply_newtime;
    }

    /**
     * @return the reply_owner
     */
    public FlsUserEntity getReply_owner() {
        return reply_owner;
    }

    /**
     * @param reply_owner the reply_owner to set
     */
    public void setReply_owner(FlsUserEntity reply_owner) {
        this.reply_owner = reply_owner;
    }

    /**
     * @return the reply_theme
     */
    public FlsThemeEntity getReply_theme() {
        return reply_theme;
    }

    /**
     * @param reply_theme the reply_theme to set
     */
    public void setReply_theme(FlsThemeEntity reply_theme) {
        this.reply_theme = reply_theme;
    }

    /**
     * @return the currentPage_indexI
     */
    public int getCurrentPage_indexI() {
        return currentPage_indexI;
    }

    /**
     * @param currentPage_indexI the currentPage_indexI to set
     */
    public void setCurrentPage_indexI(int currentPage_indexI) {
        this.currentPage_indexI = currentPage_indexI;
    }
}

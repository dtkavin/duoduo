/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.theme.entity;

import java.util.Date;
import java.util.Set;
import org.fls.reply.entity.FlsReplyEntity;
import org.fls.user.entity.FlsUserEntity;

/**
 *主题类
 * @author Tone
 */
public class FlsThemeEntity {
    private String theme_id;
    private String theme_content;
    private String theme_category;
    private String theme_tags1;
    private String theme_tags2;
    private String theme_tags3;
    private Date theme_newtime;
    private Date theme_updatetime;
    private int theme_yes;
    private int theme_no;
    private int theme_index;
    private int version;
    private FlsUserEntity theme_owner;
    private Set<FlsReplyEntity> theme_replys;
    private Set<FlsUserEntity> thems_favs;

    /**
     * @return the theme_id
     */
    public String getTheme_id() {
        return theme_id;
    }

    /**
     * @param theme_id the theme_id to set
     */
    public void setTheme_id(String theme_id) {
        this.theme_id = theme_id;
    }

    /**
     * @return the theme_content
     */
    public String getTheme_content() {
        return theme_content;
    }

    /**
     * @param theme_content the theme_content to set
     */
    public void setTheme_content(String theme_content) {
        this.theme_content = theme_content;
    }

    /**
     * @return the theme_category
     */
    public String getTheme_category() {
        return theme_category;
    }

    /**
     * @param theme_category the theme_category to set
     */
    public void setTheme_category(String theme_category) {
        this.theme_category = theme_category;
    }

    /**
     * @return the theme_tags1
     */
    public String getTheme_tags1() {
        return theme_tags1;
    }

    /**
     * @param theme_tags1 the theme_tags1 to set
     */
    public void setTheme_tags1(String theme_tags1) {
        this.theme_tags1 = theme_tags1;
    }

    /**
     * @return the theme_tags2
     */
    public String getTheme_tags2() {
        return theme_tags2;
    }

    /**
     * @param theme_tags2 the theme_tags2 to set
     */
    public void setTheme_tags2(String theme_tags2) {
        this.theme_tags2 = theme_tags2;
    }

    /**
     * @return the theme_tags3
     */
    public String getTheme_tags3() {
        return theme_tags3;
    }

    /**
     * @param theme_tags3 the theme_tags3 to set
     */
    public void setTheme_tags3(String theme_tags3) {
        this.theme_tags3 = theme_tags3;
    }

    /**
     * @return the theme_newtime
     */
    public Date getTheme_newtime() {
        return theme_newtime;
    }

    /**
     * @param theme_newtime the theme_newtime to set
     */
    public void setTheme_newtime(Date theme_newtime) {
        this.theme_newtime = theme_newtime;
    }

    /**
     * @return the theme_updatetime
     */
    public Date getTheme_updatetime() {
        return theme_updatetime;
    }

    /**
     * @param theme_updatetime the theme_updatetime to set
     */
    public void setTheme_updatetime(Date theme_updatetime) {
        this.theme_updatetime = theme_updatetime;
    }

    /**
     * @return the theme_yes
     */
    public int getTheme_yes() {
        return theme_yes;
    }

    /**
     * @param theme_yes the theme_yes to set
     */
    public void setTheme_yes(int theme_yes) {
        this.theme_yes = theme_yes;
    }

    /**
     * @return the theme_no
     */
    public int getTheme_no() {
        return theme_no;
    }

    /**
     * @param theme_no the theme_no to set
     */
    public void setTheme_no(int theme_no) {
        this.theme_no = theme_no;
    }

    /**
     * @return the theme_index
     */
    public int getTheme_index() {
        return theme_index;
    }

    /**
     * @param theme_index the theme_index to set
     */
    public void setTheme_index(int theme_index) {
        this.theme_index = theme_index;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * @return the theme_owner
     */
    public FlsUserEntity getTheme_owner() {
        return theme_owner;
    }

    /**
     * @param theme_owner the theme_owner to set
     */
    public void setTheme_owner(FlsUserEntity theme_owner) {
        this.theme_owner = theme_owner;
    }

    /**
     * @return the theme_replys
     */
    public Set<FlsReplyEntity> getTheme_replys() {
        return theme_replys;
    }

    /**
     * @param theme_replys the theme_replys to set
     */
    public void setTheme_replys(Set<FlsReplyEntity> theme_replys) {
        this.theme_replys = theme_replys;
    }

    /**
     * @return the thems_favs
     */
    public Set<FlsUserEntity> getThems_favs() {
        return thems_favs;
    }

    /**
     * @param thems_favs the thems_favs to set
     */
    public void setThems_favs(Set<FlsUserEntity> thems_favs) {
        this.thems_favs = thems_favs;
    }
}

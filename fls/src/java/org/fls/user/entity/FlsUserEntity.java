/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.user.entity;

import java.util.Set;
import org.fls.reply.entity.FlsReplyEntity;
import org.fls.test.entity.FlsBugEntity;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.userphoto.entity.FlsUserPhotoEntity;

/**
 * 用户类
 *
 * @author Tone
 */
public class FlsUserEntity {

    private String user_id;
    private String user_mail;
    private String user_name;
    private String user_password;
    private String user_power;
    private String user_flag;
    private String user_imageurl;
    private String user_aboutme;//自我介绍
    private String user_wheretogo;//
    private String user_gender;
    private String user_website;
    private String user_underwrite;
    private String user_province;
    private String user_city;
    private String user_area;
    private String user_location;//
    private int user_browse;
    private String follow_flag;
    private int user_hot;
    private Set<FlsThemeEntity> user_issueThemes;
    private Set<FlsReplyEntity> user_issueReplys;
    //当前用户的粉丝 这里存放了 都谁关注了我  那么 他就是我的粉丝
    private Set<FlsUserEntity> user_followUsers;
    //当前用户的关注  用户作为那些人的粉丝 那么  这里就是他关注的人
    private Set<FlsUserEntity> user_funUsers;
    private Set<FlsThemeEntity> user_keepThemes;
    //照片
    private FlsUserPhotoEntity user_photo;
    
    private  Set<FlsBugEntity> user_bugs;
    
    private boolean imageFlag;

    /**
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the user_mail
     */
    public String getUser_mail() {
        return user_mail;
    }

    /**
     * @param user_mail the user_mail to set
     */
    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the user_password
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * @param user_password the user_password to set
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * @return the user_power
     */
    public String getUser_power() {
        return user_power;
    }

    /**
     * @param user_power the user_power to set
     */
    public void setUser_power(String user_power) {
        this.user_power = user_power;
    }

    /**
     * @return the user_flag
     */
    public String getUser_flag() {
        return user_flag;
    }

    /**
     * @param user_flag the user_flag to set
     */
    public void setUser_flag(String user_flag) {
        this.user_flag = user_flag;
    }

    /**
     * @return the user_imageurl
     */
    public String getUser_imageurl() {
        return user_imageurl;
    }

    /**
     * @param user_imageurl the user_imageurl to set
     */
    public void setUser_imageurl(String user_imageurl) {
        this.user_imageurl = user_imageurl;
    }

    /**
     * @return the user_aboutme
     */
    public String getUser_aboutme() {
        return user_aboutme;
    }

    /**
     * @param user_aboutme the user_aboutme to set
     */
    public void setUser_aboutme(String user_aboutme) {
        this.user_aboutme = user_aboutme;
    }

    /**
     * @return the user_wheretogo
     */
    public String getUser_wheretogo() {
        return user_wheretogo;
    }

    /**
     * @param user_wheretogo the user_wheretogo to set
     */
    public void setUser_wheretogo(String user_wheretogo) {
        this.user_wheretogo = user_wheretogo;
    }

    /**
     * @return the user_gender
     */
    public String getUser_gender() {
        return user_gender;
    }

    /**
     * @param user_gender the user_gender to set
     */
    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    /**
     * @return the user_website
     */
    public String getUser_website() {
        return user_website;
    }

    /**
     * @param user_website the user_website to set
     */
    public void setUser_website(String user_website) {
        this.user_website = user_website;
    }

    /**
     * @return the user_underwrite
     */
    public String getUser_underwrite() {
        return user_underwrite;
    }

    /**
     * @param user_underwrite the user_underwrite to set
     */
    public void setUser_underwrite(String user_underwrite) {
        this.user_underwrite = user_underwrite;
    }

    /**
     * @return the user_province
     */
    public String getUser_province() {
        return user_province;
    }

    /**
     * @param user_province the user_province to set
     */
    public void setUser_province(String user_province) {
        this.user_province = user_province;
    }

    /**
     * @return the user_city
     */
    public String getUser_city() {
        return user_city;
    }

    /**
     * @param user_city the user_city to set
     */
    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    /**
     * @return the user_area
     */
    public String getUser_area() {
        return user_area;
    }

    /**
     * @param user_area the user_area to set
     */
    public void setUser_area(String user_area) {
        this.user_area = user_area;
    }

    /**
     * @return the user_location
     */
    public String getUser_location() {
        return user_location;
    }

    /**
     * @param user_location the user_location to set
     */
    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    /**
     * @return the user_browse
     */
    public int getUser_browse() {
        return user_browse;
    }

    /**
     * @param user_browse the user_browse to set
     */
    public void setUser_browse(int user_browse) {
        this.user_browse = user_browse;
    }

    /**
     * @return the follow_flag
     */
    public String getFollow_flag() {
        return follow_flag;
    }

    /**
     * @param follow_flag the follow_flag to set
     */
    public void setFollow_flag(String follow_flag) {
        this.follow_flag = follow_flag;
    }

    /**
     * @return the user_hot
     */
    public int getUser_hot() {
        return user_hot;
    }

    /**
     * @param user_hot the user_hot to set
     */
    public void setUser_hot(int user_hot) {
        this.user_hot = user_hot;
    }

    /**
     * @return the user_issueThemes
     */
    public Set<FlsThemeEntity> getUser_issueThemes() {
        return user_issueThemes;
    }

    /**
     * @param user_issueThemes the user_issueThemes to set
     */
    public void setUser_issueThemes(Set<FlsThemeEntity> user_issueThemes) {
        this.user_issueThemes = user_issueThemes;
    }

    /**
     * @return the user_issueReplys
     */
    public Set<FlsReplyEntity> getUser_issueReplys() {
        return user_issueReplys;
    }

    /**
     * @param user_issueReplys the user_issueReplys to set
     */
    public void setUser_issueReplys(Set<FlsReplyEntity> user_issueReplys) {
        this.user_issueReplys = user_issueReplys;
    }

    /**
     * @return the user_followUsers
     */
    public Set<FlsUserEntity> getUser_followUsers() {
        return user_followUsers;
    }

    /**
     * @param user_followUsers the user_followUsers to set
     */
    public void setUser_followUsers(Set<FlsUserEntity> user_followUsers) {
        this.user_followUsers = user_followUsers;
    }

    /**
     * @return the user_funUsers
     */
    public Set<FlsUserEntity> getUser_funUsers() {
        return user_funUsers;
    }

    /**
     * @param user_funUsers the user_funUsers to set
     */
    public void setUser_funUsers(Set<FlsUserEntity> user_funUsers) {
        this.user_funUsers = user_funUsers;
    }

    /**
     * @return the user_keepThemes
     */
    public Set<FlsThemeEntity> getUser_keepThemes() {
        return user_keepThemes;
    }

    /**
     * @param user_keepThemes the user_keepThemes to set
     */
    public void setUser_keepThemes(Set<FlsThemeEntity> user_keepThemes) {
        this.user_keepThemes = user_keepThemes;
    }

    /**
     * @return the user_photo
     */
    public FlsUserPhotoEntity getUser_photo() {
        return user_photo;
    }

    /**
     * @param user_photo the user_photo to set
     */
    public void setUser_photo(FlsUserPhotoEntity user_photo) {
        this.user_photo = user_photo;
    }

    /**
     * @return the imageFlag
     */
    public boolean isImageFlag() {
        return imageFlag;
    }

    /**
     * @param imageFlag the imageFlag to set
     */
    public void setImageFlag(boolean imageFlag) {
        this.imageFlag = imageFlag;
    }

    /**
     * @return the user_bugs
     */
    public Set<FlsBugEntity> getUser_bugs() {
        return user_bugs;
    }

    /**
     * @param user_bugs the user_bugs to set
     */
    public void setUser_bugs(Set<FlsBugEntity> user_bugs) {
        this.user_bugs = user_bugs;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.theme.action;

import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.common.utils.DateUtils;
import org.fls.common.utils.HotCountUtil;
import org.fls.common.utils.KeyWordFilter;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.theme.service.ThemeService;
import org.fls.user.entity.FlsUserEntity;
import org.fls.userinfo.service.UserInfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 主题处理
 *
 * @author Tone
 */
@Controller("ThemeAction")
@Scope("session")
public class ThemeAction extends AbstractFlsBaseAction {

   
    @Resource
    private ThemeService themeService;
    @Resource
    private UserInfoService userInfoService;
    private Map<String, Object> session;
    private Map<String,Object> request;
    private Map<String,Object> application;
    private String serachtype;
    private FlsPageEntity pageEntity;
    private int pageSize = 10;   // 页大小
    private int currentPage;//当前页

    /**
     * 查询主题
     *
     * @return String
     * @throws Exception
     */
    public String queryTheme() throws Exception {
        // System.out.println("serachtype:" + serachtype);
        //System.out.println(this.hashCode()+":"+this.toString());
       // this.setMessage(YESMSG, this.);
        this.pageEntity = themeService.queryForPageMenuByType(pageSize, currentPage, serachtype);
        return SUCCESS;
    }
    private String chgEncoding;
    private String searchKey;

    /**
     * 按照关键字查询主题
     *
     * @return String
     * @throws Exception
     */
    public String queryThemeByKey() throws Exception {
        // System.out.println("queryThemeByKey:"+searchKey);
        if ("YES".equals(getChgEncoding())) {
            setSearchKey(new String(getSearchKey().getBytes("ISO-8859-1"), "UTF-8"));
            this.setChgEncoding("NO");
        }
        this.pageEntity = this.themeService.queryForPageBySearchKey(pageSize, currentPage, getSearchKey());
        this.serachtype = "bykey";
        return SUCCESS;
    }
    private String uid;
    private String content;
    private String cat;
    private String theme_tags1;
    private String theme_tags2;
    private String theme_tags3;

    /**
     * 发送主题
     *
     * @return String
     * @throws Exception
     */
    public String sendTheme() throws Exception {
       
        // System.out.println("sendTheme");
        FlsThemeEntity themeEntity = new FlsThemeEntity();
        // FlsUserEntity userEntity = new FlsUserEntity();
        //userEntity.setUser_id(getUid());
        FlsUserEntity userEntity = (FlsUserEntity) this.session.get("LOGIN_USER");
       
         //
        //计算活跃度
         
       
        themeEntity.setTheme_owner(userEntity);
       

        themeEntity.setTheme_content(getContent());
       
        themeEntity.setTheme_category(getCat());
        themeEntity.setTheme_tags1(getTheme_tags1());
        themeEntity.setTheme_tags2(getTheme_tags2());
        themeEntity.setTheme_tags3(getTheme_tags3());
        themeEntity.setTheme_index(themeService.getAllThemeCount() + 1);

        themeEntity.setTheme_newtime(DateUtils.getNowDate());
        themeEntity.setTheme_updatetime(DateUtils.getNowDate());

        FlsMsgEntity msgEntity = themeService.sendTheme(themeEntity,(StringBuffer)application.get("keyword"));
        
        
       
       
        //

        if (msgEntity.isFlag()) {
            this.setMessage(YESMSG, msgEntity.getMessage());
            this.serachtype = "MAX_NEW";
            this.session.put(LOGIN_USER, msgEntity.getLoginUser());
            return SUCCESS + "_send";

        } else {
            this.setMessage(NOMSG, msgEntity.getMessage());
            return ERROR;
        }
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request=map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.session = map;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.application=map;
    }

    /**
     * @return the serachtype
     */
    public String getSerachtype() {
        return serachtype;
    }

    /**
     * @param serachtype the serachtype to set
     */
    public void setSerachtype(String serachtype) {
        this.serachtype = serachtype;
    }

    /**
     * @return the pageEntity
     */
    public FlsPageEntity getPageEntity() {
        return pageEntity;
    }

    /**
     * @param pageEntity the pageEntity to set
     */
    public void setPageEntity(FlsPageEntity pageEntity) {
        this.pageEntity = pageEntity;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public void setMessage(String mesFalg, String message) {
        // throw new UnsupportedOperationException("Not supported yet.");
        this.request.put(mesFalg, message);
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the cat
     */
    public String getCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(String cat) {
        this.cat = cat;
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
     * @return the chgEncoding
     */
    public String getChgEncoding() {
        return chgEncoding;
    }

    /**
     * @param chgEncoding the chgEncoding to set
     */
    public void setChgEncoding(String chgEncoding) {
        this.chgEncoding = chgEncoding;
    }

    /**
     * @return the searchKey
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * @param searchKey the searchKey to set
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}

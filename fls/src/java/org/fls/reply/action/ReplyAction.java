/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.reply.action;

import java.util.Map;
import javax.annotation.Resource;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.common.utils.DateUtils;
import org.fls.common.utils.HotCountUtil;
import org.fls.reply.entity.FlsReplyEntity;
import org.fls.reply.service.ReplyService;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.theme.service.ThemeService;
import org.fls.user.entity.FlsUserEntity;
import org.fls.userinfo.service.UserInfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 回复处理
 *
 * @author Tone
 */
@Controller("ReplyAction")
@Scope("session")
public class ReplyAction extends AbstractFlsBaseAction {

    private Map<String, Object> request;
    private Map<String, Object> session;
    private Map<String, Object> application;
    @Resource
    private ThemeService themeService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ReplyService replyService;
    private FlsPageEntity pageEntity;
    private int pageSize = 10;   // 页大小
    private int currentPage;//当前页

    /**
     * 查询回复
     *
     * @return String
     * @throws Exception
     */
    public String queryReply() throws Exception {
        //存在bug 回复数 会显示少一个
        FlsThemeEntity themeEntity_db = themeService.queryThemeByID(getTheme_id());
        request.put("theme", themeEntity_db);
        this.pageEntity = replyService.queryForPage(getPageSize(), getCurrentPage(), getTheme_id());
        return SUCCESS;
    }
    private String theme_id;
    private String post_comment_text;

    /**
     * 发布评论
     *
     * @return String
     * @throws Exception
     */
    public String sendReply() throws Exception {
        FlsUserEntity userEntity = (FlsUserEntity) this.session.get(LOGIN_USER);


        FlsReplyEntity replyEntity = new FlsReplyEntity();

        FlsThemeEntity themeEntity_db = themeService.queryThemeByID(theme_id);
        int count_reply = themeEntity_db.getTheme_replys().size() + 1;

        replyEntity.setReply_theme(themeEntity_db);
        replyEntity.setReply_content(post_comment_text);
        replyEntity.setReply_newtime(DateUtils.getNowDate());
        replyEntity.setReply_owner(userEntity);
        //replyEntity.setReply_owner(userEntity_db);
        replyEntity.setReply_index(count_reply);

        FlsMsgEntity msgEntity = replyService.sendReply(replyEntity,(StringBuffer)application.get("keyword"));
        // this.session.put(LOGIN_USER, userEntity_db);



        if (msgEntity.isFlag()) {
            this.request.put("theme_id", theme_id);
            this.setMessage(YESMSG, msgEntity.getMessage());
            this.session.put(LOGIN_USER, msgEntity.getLoginUser());
            return SUCCESS + "_send";

        } else {
             this.setMessage(NOMSG, msgEntity.getMessage());
            return ERROR;
        }
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
        this.application=map;
    }

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

    /**
     * @return the post_comment_text
     */
    public String getPost_comment_text() {
        return post_comment_text;
    }

    /**
     * @param post_comment_text the post_comment_text to set
     */
    public void setPost_comment_text(String post_comment_text) {
        this.post_comment_text = post_comment_text;
    }
}

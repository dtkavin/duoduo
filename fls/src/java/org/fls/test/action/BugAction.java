/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.test.action;

import java.util.Map;
import javax.annotation.Resource;
import org.fls.common.base.action.AbstractFlsBaseAction;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.utils.DateUtils;
import org.fls.test.entity.FlsBugEntity;
import org.fls.test.service.BugService;
import org.fls.user.entity.FlsUserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Tone
 */
@Controller("BugAction")
@Scope("session")
public class BugAction extends AbstractFlsBaseAction {

    private Map<String, Object> request;
    private Map<String, Object> session;
    @Resource
    private BugService bugService;
    private String post_comment_text;

    public String submitBug() throws Exception {

        FlsUserEntity userEntity = (FlsUserEntity) this.session.get("LOGIN_USER");
        FlsBugEntity bugEntity = new FlsBugEntity();

        bugEntity.setUser(userEntity);
        bugEntity.setCreateDate(DateUtils.getNowDate());
        bugEntity.setConent(post_comment_text);
        bugEntity.setFlag("F");
        System.out.println(post_comment_text);
        FlsMsgEntity msgEntity = bugService.submitBug(bugEntity);
        if (msgEntity.isFlag()) {
            this.setMessage(YESMSG, msgEntity.getMessage());
            System.out.println("SUCCESS");
            return SUCCESS;
        } else {
            this.setMessage(NOMSG, msgEntity.getMessage());
            System.out.println("ERROR");
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
        // throw new UnsupportedOperationException("Not supported yet.");
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

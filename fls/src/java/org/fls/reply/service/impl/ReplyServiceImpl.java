/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.reply.service.impl;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.utils.HotCountUtil;
import org.fls.common.utils.KeyWordFilter;
import org.fls.reply.dao.ReplyDAO;
import org.fls.reply.entity.FlsReplyEntity;
import org.fls.reply.service.ReplyService;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *回复业务处理service 实现类
 * @author Tone
 */
@Transactional
@Service("ReplyService")
public class ReplyServiceImpl extends AbstractFlsServiceImpl implements ReplyService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private ReplyDAO replyDAO;
    @Resource
    private UserDAO userDAO;
    @Resource
    private ServletContext servletContext;
    @Resource
    private FlsMsgEntity msgEntity;

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public FlsPageEntity queryForPage(int pageSize, int currentPage, String theme_id) throws Exception {
        
        final String hql = "from FlsReplyEntity  as  Reply where  Reply.reply_theme.theme_id='" + theme_id + "'";        //查询语句
        FlsPageEntity pageEntity=replyDAO.queryReplyForPage(hql, pageSize, currentPage, getSession());
        String realPath=servletContext.getRealPath("/Images/faces");
        for (Object object : pageEntity.getList()) {
            ((FlsReplyEntity) object).getReply_owner().setImageFlag(new File(realPath+File.separator+ ((FlsReplyEntity) object).getReply_owner().getUser_imageurl()).exists());
            
        }
        
        return  pageEntity;
       // return replyDAO.queryReplyForPage(hql, pageSize, currentPage, getSession());
    }

    @Override
    public FlsMsgEntity sendReply(FlsReplyEntity replyEntity,StringBuffer keyBuffer) throws Exception {
        String content=replyEntity.getReply_content();
         KeyWordFilter keyWordFilter = KeyWordFilter.getInstance(keyBuffer);
        replyEntity.setReply_content(keyWordFilter.doFilter(content));
        
        FlsUserEntity userEntity_db = userDAO.getUserByID(replyEntity.getReply_owner().getUser_id(), getSession());
        userEntity_db.setUser_hot(HotCountUtil.gethot(userEntity_db.getUser_browse(), userEntity_db.getUser_issueReplys().size()+1, userEntity_db.getUser_issueThemes().size(), userEntity_db.getUser_followUsers().size(), userEntity_db.getUser_funUsers().size()));
        replyEntity.setReply_owner(userEntity_db);
        replyDAO.saveReply(replyEntity, getSession());
        
        msgEntity.setLoginUser(userEntity_db);
        msgEntity.setFlag(true);
        if (content.indexOf("*")==-1&&replyEntity.getReply_content().indexOf("*") !=-1) {
            msgEntity.setMessage("评论 发布成功！ 但存在敏感词 已被过滤");
        }else{
            msgEntity.setMessage("评论 发布成功！");
        }
       
        
        return msgEntity;
    }

   

   
}

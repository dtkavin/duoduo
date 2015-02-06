/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.reply.dao.impl;

import java.util.List;
import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.reply.dao.ReplyDAO;
import org.fls.reply.entity.FlsReplyEntity;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *回复处理dao的实现类
 * @author Tone
 */
@Repository("ReplyDAO")
public class ReplyDAOImpl extends AbstractFlsBaseDAOImpl implements ReplyDAO{

    @Override
    public List<FlsReplyEntity> getReplys(String hql, Session session) throws Exception {
        return (List<FlsReplyEntity>) this.getAllObjectByHQL(hql, session);
    }

    @Override
    public int getReplysConut(String hql, Session session) throws Exception {
        return  this.getAllobjectCountByHQL(hql, session);
    }

    @Override
    public FlsReplyEntity getUniqueReplyByHQL(String hql, Session session) throws Exception {
        return  (FlsReplyEntity) this.getUniqueObjectByHQL(hql, session);
    }

    @Override
    public FlsReplyEntity getReplyByID(String id, Session session) throws Exception {
        return  (FlsReplyEntity)this.getObjectByID(FlsReplyEntity.class, id, session);
    }

    @Override
    public void saveReply(FlsReplyEntity replyEntity, Session session) throws Exception {
       this.saveObject(replyEntity, session);
    }

    @Override
    public FlsPageEntity queryReplyForPage(String hql, int pageSize, int nowPage, Session session) throws Exception {
        return this.queryForPage(hql, "",pageSize, nowPage, session);
    }
    
}

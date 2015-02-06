/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.reply.dao;

import java.util.List;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.reply.entity.FlsReplyEntity;
import org.hibernate.classic.Session;

/**
 * 回复处理dao
 *
 * @author Tone
 */
public interface ReplyDAO {

    /**
     * 获取回复list
     *
     * @param hql
     * @param session
     * @return List<FlsReplyEntity>
     * @throws Exception
     */
    public abstract List<FlsReplyEntity> getReplys(String hql, Session session) throws Exception;

    /**
     * 获取回复总数
     *
     * @param hql
     * @param session
     * @return int
     * @throws Exception
     */
    public abstract int getReplysConut(String hql, Session session) throws Exception;

    /**
     * 获取回复
     *
     * @param hql
     * @param session
     * @return FlsReplyEntity
     * @throws Exception
     */
    public abstract FlsReplyEntity getUniqueReplyByHQL(String hql, Session session) throws Exception;

    /**
     * 获取回复
     *
     * @param id
     * @param session
     * @return FlsReplyEntity
     * @throws Exception
     */
    public abstract FlsReplyEntity getReplyByID(String id, Session session) throws Exception;

    /**
     * 保存回复
     *
     * @param replyEntity
     * @param session
     * @throws Exception
     */
    public abstract void saveReply(FlsReplyEntity replyEntity, Session session) throws Exception;

    /**
     * 分页查询回复
     *
     * @param hql
     * @param pageSize
     * @param nowPage
     * @param session
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryReplyForPage(String hql, int pageSize, int nowPage, Session session) throws Exception;
}

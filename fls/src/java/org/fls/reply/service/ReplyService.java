/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.reply.service;

import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.reply.entity.FlsReplyEntity;

/**
 * 回复业务处理service
 *
 * @author Tone
 */
public interface ReplyService {

    /**
     * 回复分页处理
     *
     * @param pageSize
     * @param currentPage
     * @param theme_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryForPage(int pageSize, int currentPage, String theme_id) throws Exception;

    /**
     * 发送回复
     *
     * @param replyEntity
     * @return FlsMsgEntity
     * @throws Exception
     */
    public abstract FlsMsgEntity sendReply(FlsReplyEntity replyEntity,StringBuffer keyBuffer) throws Exception;
}

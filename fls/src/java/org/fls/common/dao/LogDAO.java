/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao;

import org.fls.common.base.entitys.FlsLogEntity;
import org.hibernate.classic.Session;

/**
 *日志DAO
 * @author Tone
 */
public interface LogDAO {
    /**
     * 保存日志
     * @param logEntity
     * @param session
     * @throws Exception 
     */
    public abstract void saveLog(FlsLogEntity logEntity,Session session) throws Exception;
}

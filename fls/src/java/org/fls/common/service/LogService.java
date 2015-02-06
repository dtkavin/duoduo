/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.service;

import org.fls.common.base.entitys.FlsLogEntity;

/**
 * 日志业务处理service
 *
 * @author Tone
 */
public interface LogService {

    /**
     * 保存日志
     *
     * @param logEntity
     * @throws Exception
     */
    public abstract void insertLog(FlsLogEntity logEntity) throws Exception;
}

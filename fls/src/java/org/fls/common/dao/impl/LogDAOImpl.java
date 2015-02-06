/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao.impl;

import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.FlsLogEntity;
import org.fls.common.dao.LogDAO;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *日志DAO实现类
 * @author Tone
 */
@Repository("LogDAO")
public class LogDAOImpl extends AbstractFlsBaseDAOImpl implements LogDAO {

    @Override
    public void saveLog(FlsLogEntity logEntity ,Session session) throws Exception {
        this.saveObject(logEntity, session);
    }
    
}

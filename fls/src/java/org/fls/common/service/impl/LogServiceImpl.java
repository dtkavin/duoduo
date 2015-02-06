/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.service.impl;

import javax.annotation.Resource;
import org.fls.common.base.entitys.FlsLogEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.dao.LogDAO;
import org.fls.common.service.LogService;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志servi实现类
 *
 * @author Tone
 */
@Transactional
@Service("LogService")
public class LogServiceImpl extends AbstractFlsServiceImpl implements LogService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private LogDAO logDAO;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insertLog(FlsLogEntity logEntity) throws Exception {
        logDAO.saveLog(logEntity, getSession());
    }
}

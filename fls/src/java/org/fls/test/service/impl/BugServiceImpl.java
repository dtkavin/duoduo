/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.test.service.impl;

import javax.annotation.Resource;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.test.dao.BugDAO;
import org.fls.test.entity.FlsBugEntity;
import org.fls.test.service.BugService;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tone
 */
@Transactional
@Service("BugService")
public class BugServiceImpl extends AbstractFlsServiceImpl implements BugService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private BugDAO bugDAO;
    @Resource
    private FlsMsgEntity msgEntity;

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public FlsMsgEntity submitBug(FlsBugEntity bugEntity) throws Exception {
        bugDAO.saveBug(bugEntity, getSession());
        msgEntity.setMessage("提交bug成功,继续浏览别人的牢骚吧!");
        msgEntity.setFlag(true);
                
        return  msgEntity;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.test.dao.impl;

import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.test.dao.BugDAO;
import org.fls.test.entity.FlsBugEntity;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tone
 */
@Repository("BugDAO")
public class BugDAOImpl extends  AbstractFlsBaseDAOImpl implements BugDAO{

    @Override
    public void saveBug(FlsBugEntity bugEntity,Session session) throws Exception {
        this.saveObject(bugEntity, session);
    }
    
}

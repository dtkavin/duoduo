/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao.impl;

import java.util.List;
import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.FlsAreaConfigEntity;
import org.fls.common.dao.AreaConfigDAO;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *地区DAO实现类
 * @author Tone
 */
@Repository("AreaConfigDAO")
public class AreaConfigDAOImpl extends AbstractFlsBaseDAOImpl implements AreaConfigDAO{

    @Override
    public List<FlsAreaConfigEntity> getAreaConfigsByHQL(String hql, Session session) throws Exception {
        return (List<FlsAreaConfigEntity>) this.getAllObjectByHQL(hql, session);
    }
    
}

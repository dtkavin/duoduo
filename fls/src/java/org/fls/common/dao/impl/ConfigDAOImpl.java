/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao.impl;

import java.util.List;
import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.FlsBaseConfigEntity;
import org.fls.common.dao.ConfigDAO;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *基础配置DAO实现类
 * @author Tone
 */
@Repository("ConfigDAO")
public class ConfigDAOImpl extends AbstractFlsBaseDAOImpl implements ConfigDAO{

    @Override
    public List<FlsBaseConfigEntity> getConfigsByHQL(String hql, Session session) throws Exception {
        return (List<FlsBaseConfigEntity>) this.getAllObjectByHQL(hql, session);
    }

    @Override
    public FlsBaseConfigEntity getUniqueConfigByHQL(String hql, Session session) throws Exception {
        return (FlsBaseConfigEntity) this.getUniqueObjectByHQL(hql, session);
    }
    
}

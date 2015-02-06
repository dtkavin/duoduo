/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.user.dao.impl;

import java.util.List;
import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *用户dao实现类
 * @author Tone
 */
@Repository("UserDAO")
public class UserDAOImpl extends AbstractFlsBaseDAOImpl implements UserDAO {

    @Override
    public List<FlsUserEntity> getUsersByHQL(String hql, Session session) throws Exception {
        return (List<FlsUserEntity>) this.getAllObjectByHQL(hql, session);
    }

    @Override
    public List<FlsUserEntity> getOrderAllUsersByHQL(String hql, int firstNum, int maxNum, Session session) throws Exception {
        return  (List<FlsUserEntity>) this.getOrderAllobjectByHQL(hql, firstNum, maxNum, session);
    }

    @Override
    public int getUsersConutByHQL(String hql, Session session) throws Exception {
        return this.getAllobjectCountByHQL(hql, session);
    }

    @Override
    public FlsUserEntity getUniqueUserByHQL(String hql, Session session) throws Exception {
        return (FlsUserEntity) this.getUniqueObjectByHQL(hql, session);
    }

    @Override
    public FlsUserEntity getUserByID(String id, Session session) throws Exception {
       return  (FlsUserEntity) this.getObjectByID(FlsUserEntity.class, id, session);
    }

    @Override
    public void updateUser(FlsUserEntity userEntity, Session session) throws Exception {
        this.updateObject(userEntity, session);
    }

    @Override
    public void saveUser(FlsUserEntity userEntity, Session session) throws Exception {
       this.saveObject(userEntity, session);
    }

    @Override
    public FlsPageEntity queryUserForPage(String hql, int pageSize, int nowPage, Session session) throws Exception {
        return this.queryForPage(hql, "", pageSize, nowPage, session);
    }
}

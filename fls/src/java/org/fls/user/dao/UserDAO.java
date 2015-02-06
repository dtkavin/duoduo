/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.user.dao;

import java.util.List;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.user.entity.FlsUserEntity;
import org.hibernate.classic.Session;

/**
 * 用户dao
 *
 * @author Tone
 */
public interface UserDAO {

    /**
     * 查询用户list
     *
     * @param hql
     * @param session
     * @return List<FlsUserEntity>
     * @throws Exception
     */
    public abstract List<FlsUserEntity> getUsersByHQL(String hql, Session session) throws Exception;

    /**
     * 查询用户list 排序
     *
     * @param hql
     * @param firstNum
     * @param maxNum
     * @param session
     * @return List<FlsUserEntity>
     * @throws Exception
     */
    public abstract List<FlsUserEntity> getOrderAllUsersByHQL(String hql, int firstNum, int maxNum, Session session) throws Exception;

    /**
     * 查询总数
     *
     * @param hql
     * @param session
     * @return int
     * @throws Exception
     */
    public abstract int getUsersConutByHQL(String hql, Session session) throws Exception;

    /**
     * 获取用户
     *
     * @param hql
     * @param session
     * @return FlsUserEntity
     * @throws Exception
     */
    public abstract FlsUserEntity getUniqueUserByHQL(String hql, Session session) throws Exception;

    /**
     * 获取用户
     *
     * @param id
     * @param session
     * @return FlsUserEntity
     * @throws Exception
     */
    public abstract FlsUserEntity getUserByID(String id, Session session) throws Exception;

    /**
     * 更新用户
     *
     * @param userEntity
     * @param session
     * @throws Exception
     */
    public abstract void updateUser(FlsUserEntity userEntity, Session session) throws Exception;

    /**
     * 保存用户
     *
     * @param userEntity
     * @param session
     * @throws Exception
     */
    public abstract void saveUser(FlsUserEntity userEntity, Session session) throws Exception;

    /**
     * 分页查询用户
     *
     是* @param hql
     * @param pageSize
     * @param nowPage
     * @param session
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryUserForPage(String hql, int pageSize, int nowPage, Session session) throws Exception;
}

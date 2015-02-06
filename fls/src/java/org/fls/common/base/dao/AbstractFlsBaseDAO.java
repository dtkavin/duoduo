/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.dao;

import java.io.Serializable;
import java.util.List;
import org.fls.common.base.entitys.FlsPageEntity;
import org.hibernate.classic.Session;

/**
 *核心DAO 其实现类会被其他DAO继承
 * @author Tone
 */
public interface AbstractFlsBaseDAO {
    /**
     * 根据HQL 查询出全部对象 （不排序）
     *
     * @param hql
     * @param session
     * @return List<?>
     * @throws Exception
     */
    public abstract List<?> getAllObjectByHQL(String hql, Session session) throws Exception;

    /**
     * 根据HQL 查询出全部对象 （排序）
     *
     * @param hql
     * @param firstNum
     * @param maxNum
     * @param session
     * @return List<?>
     * @throws Exception
     */
    public abstract List<?> getOrderAllobjectByHQL(String hql, int firstNum, int maxNum, Session session) throws Exception;

    /**
     * 根据HQL 查询出全部对象的个数
     *
     * @param hql
     * @param session
     * @return int
     * @throws Exception
     */
    public abstract int getAllobjectCountByHQL(String hql, Session session) throws Exception;

    /**
     * 根据HQL 查询出某一对象
     *
     * @param hql
     * @param session
     * @return Object
     * @throws Exception
     */
    public abstract Object getUniqueObjectByHQL(String hql, Session session) throws Exception;

    /**
     * 根据ID 查询出某一对象
     *
     * @param clazz
     * @param id
     * @param session
     * @return Object
     * @throws Exception
     */
    public abstract Object getObjectByID(Class<?> clazz, Serializable id, Session session) throws Exception;

    /**
     * 保存对象
     *
     * @param object
     * @param session
     * @throws Exception
     */
    public abstract void saveObject(Object object, Session session) throws Exception;

    /**
     * 更新对象
     *
     * @param object
     * @param session
     * @throws Exception
     */
    public abstract void updateObject(Object object, Session session) throws Exception;

    /**
     * 删除对象
     *
     * @param object
     * @param session
     * @throws Exception
     */
    public abstract void deleteObject(Object object, Session session) throws Exception;

    /**
     * 关键字分页查询
     *
     * @param hql
     * @param searchKey
     * @param pageSize
     * @param nowPage
     * @param session
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryForPage(final String hql, String searchKey, int pageSize, int nowPage, Session session) throws Exception;

    /**
     *按照关键字分页查询出某一类型数据的list
     * 
     * @param hql
     * @param searchKey
     * @param offset
     * @param length
     * @param session
     * @return List<?>
     * @throws Exception
     */
    public abstract List<?> queryListForPage(final String hql, String searchKey, final int offset, final int length, Session session) throws Exception;

    /**查询总数
     *
     * @param hql
     * @param searchKey
     * @param session
     * @return int
     */
    public abstract int getAllRowCount(String hql, String searchKey, Session session);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.fls.common.base.dao.AbstractFlsBaseDAO;
import org.fls.common.base.entitys.FlsPageEntity;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 * 基础DAO的实现类
 * @author Tone
 */
public class AbstractFlsBaseDAOImpl implements AbstractFlsBaseDAO {

    @Override
    public List<?> getAllObjectByHQL(String hql, Session session) throws Exception {
        return session.createQuery(hql).list();
    }

    @Override
    public List<?> getOrderAllobjectByHQL(String hql, int firstNum, int maxNum, Session session) throws Exception {
        return session.createQuery(hql).setFirstResult(firstNum).setMaxResults(maxNum).list();
    }

    @Override
    public int getAllobjectCountByHQL(String hql, Session session) throws Exception {
        return session.createQuery(hql).list().size();
    }

    @Override
    public Object getUniqueObjectByHQL(String hql, Session session) throws Exception {
        return session.createQuery(hql).uniqueResult();
    }

    @Override
    public Object getObjectByID(Class<?> clazz, Serializable id, Session session) throws Exception {
        return session.get(clazz, id);
    }

    @Override
    public void saveObject(Object object, Session session) throws Exception {
        session.persist(object);
    }

    @Override
    public void updateObject(Object object, Session session) throws Exception {
        session.update(object);
    }

    @Override
    public void deleteObject(Object object, Session session) throws Exception {
        session.delete(object);
    }

    @Override
    public FlsPageEntity queryForPage(String hql, String searchKey, int pageSize, int nowPage, Session session) throws Exception {
        int allRow = this.getAllRowCount(hql, searchKey, session);
        int totalPage = FlsPageEntity.countTotalPage(pageSize, allRow);

        final int offset = FlsPageEntity.countOffset(pageSize, nowPage);
        final int length = pageSize;    //每页记录数
        final int currentPage = FlsPageEntity.countCurrentPage(nowPage);

        List<?> list = this.queryListForPage(hql, searchKey, offset, length, session);

        FlsPageEntity pageEntity = new FlsPageEntity();
        pageEntity.setPageSize(pageSize);
        pageEntity.setCurrentPage(currentPage);
        pageEntity.setAllRow(allRow);
        pageEntity.setTotalPage(totalPage);
        pageEntity.setList(list);
        pageEntity.init();

        return pageEntity;
    }

    @Override
    public List<?> queryListForPage(String hql, String searchKey, int offset, int length, Session session) throws Exception {
        Query query = session.createQuery(hql);
        if (searchKey != null && !"".equals(searchKey) && !"null".equals(searchKey)) {
            query.setString("searchKey", "%" + searchKey + "%");
            //System.out.println("searchKey:"+searchKey);
        }
        query.setFirstResult(offset);
        query.setMaxResults(length);
      // System.out.println(query.getQueryString());
        return query.list();
    }

    @Override
    public int getAllRowCount(String hql, String searchKey, Session session) {
        Query query = session.createQuery(hql);
        if (searchKey != null && !"".equals(searchKey) && !"null".equals(searchKey)) {
            query.setString("searchKey", "%" + searchKey + "%");
        }
        return query.list().size();
    }
}

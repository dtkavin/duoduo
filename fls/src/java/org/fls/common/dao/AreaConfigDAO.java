/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao;

import java.util.List;
import org.fls.common.base.entitys.FlsAreaConfigEntity;
import org.hibernate.classic.Session;

/**
 *地区配置DAO
 * @author Tone
 */
public interface AreaConfigDAO {
    /**
     * 获取地区配置
     * @param hql
     * @param session
     * @return List<FlsAreaConfigEntity>
     * @throws Exception 
     */
    public abstract List<FlsAreaConfigEntity> getAreaConfigsByHQL(String hql,Session session) throws Exception;
}

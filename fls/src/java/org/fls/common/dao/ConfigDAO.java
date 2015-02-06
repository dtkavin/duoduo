/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao;

import java.util.List;
import org.fls.common.base.entitys.FlsBaseConfigEntity;
import org.hibernate.classic.Session;

/**
 * 基础配置DAO
 *
 * @author Tone
 */
public interface ConfigDAO {
   /**
    * 获取配置list
    * @param hql
    * @param session
    * @return List<FlsBaseConfigEntity>
    * @throws Exception 
    */
    public abstract List<FlsBaseConfigEntity> getConfigsByHQL(String hql, Session session) throws Exception;
    /**
     * 获取唯一配置
     * @param hql
     * @param session
     * @return FlsBaseConfigEntity
     * @throws Exception 
     */
    public abstract FlsBaseConfigEntity getUniqueConfigByHQL(String hql, Session session) throws Exception;
}

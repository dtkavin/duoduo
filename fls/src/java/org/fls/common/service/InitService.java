/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.service;

import java.util.Collection;
import java.util.List;
import org.fls.common.base.entitys.FlsAreaConfigEntity;
import org.fls.common.base.entitys.FlsBaseConfigEntity;
import org.fls.user.entity.FlsUserEntity;

/**
 * 系统初始业务处理service
 *
 * @author Tone
 */
public interface InitService {

    /**
     * 获取分类 list
     *
     * @return List<FlsBaseConfigEntity>
     * @throws Exception
     */
    public abstract List<FlsBaseConfigEntity> getThemeCategorys() throws Exception;

    /**
     * 获取地区配置
     *
     * @param type
     * @return List<FlsAreaConfigEntity>
     * @throws Exception
     */
    public abstract List<FlsAreaConfigEntity> getAreaConfigsByType(String type) throws Exception;

    /**
     * 获取某一配置
     *
     * @param hql
     * @return FlsBaseConfigEntity
     * @throws Exception
     */
    public abstract FlsBaseConfigEntity getConfig(String hql) throws Exception;

    /**
     * 获取url list
     *
     * @return List<FlsBaseConfigEntity>
     * @throws Exception
     */
    public abstract List<FlsBaseConfigEntity> getUrl() throws Exception;

   /**
    * 获取用户
    * @return
    * @throws Exception 
    */
    public abstract List<FlsUserEntity> getUser() throws Exception;

    /**
     * 获取标签 list
     *
     * @return List<String>
     * @throws Exception
     */
    public abstract List<String> getTags() throws Exception;

    /**
     * 获取 管理员email
     *
     * @return FlsBaseConfigEntity
     * @throws Exception
     */
    public abstract FlsBaseConfigEntity getAdminEmail() throws Exception;

    /**
     * 获取管理员邮件密码
     *
     * @return FlsBaseConfigEntity
     * @throws Exception
     */
    public abstract FlsBaseConfigEntity getAdminpw() throws Exception;

    /**
     * 获取管理员邮件 host
     *
     * @return FlsBaseConfigEntity
     * @throws Exception
     */
    public abstract FlsBaseConfigEntity getEmailHost() throws Exception;

    /**
     * 获取用户总数
     *
     * @return int
     * @throws Exception
     */
    public abstract int getAllUserNumber() throws Exception;

    /**
     * 获取theme总数
     *
     * @return int
     * @throws Exception
     */
    public abstract int getAllThemeNumber() throws Exception;
    
    /**
     * 或缺敏感字
     * @return
     * @throws Exception 
     */
    public abstract StringBuffer  getKeyWordList()throws Exception;
    /**
     * 执行初始化SQL
     * @throws Exception 
     */
    public  abstract  void  executeCustomSQL() throws  Exception;
}

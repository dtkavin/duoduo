/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.theme.dao;

import java.util.List;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.theme.entity.FlsThemeEntity;
import org.hibernate.classic.Session;

/**
 * 主题dao
 *
 * @author Tone
 */
public interface ThemeDAO {

    /**
     * 或缺主题list
     *
     * @param hql
     * @param session
     * @return List<FlsThemeEntity>
     * @throws Exception
     */
    public abstract List<FlsThemeEntity> getThemes(String hql, Session session) throws Exception;

    /**
     * 排序获取主题
     *
     * @param hql
     * @param firstNum
     * @param maxNum
     * @param session
     * @return List<String>
     * @throws Exception
     */
    public abstract List<String> getOrderThemeTagsByHQL(String hql, int firstNum, int maxNum, Session session) throws Exception;

    /**
     * 获取主题
     *
     * @param hql
     * @param session
     * @return FlsThemeEntity
     * @throws Exception
     */
    public abstract FlsThemeEntity getUniqueThemeByHQL(String hql, Session session) throws Exception;

    /**
     * 获取主题
     *
     * @param id
     * @param session
     * @return FlsThemeEntity
     * @throws Exception
     */
    public abstract FlsThemeEntity getThemeByID(String id, Session session) throws Exception;

    /**
     * 保存主题
     *
     * @param themeEntity
     * @param session
     * @throws Exception
     */
    public abstract void saveTheme(FlsThemeEntity themeEntity, Session session) throws Exception;

    /**
     * 更新主题
     *
     * @param themeEntity
     * @param session
     * @throws Exception
     */
    public abstract void updateTheme(FlsThemeEntity themeEntity, Session session) throws Exception;

    /**
     * 分页查询主题
     *
     * @param hql
     * @param pageSize
     * @param nowPage
     * @param session
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryThemeForPage(String hql, int pageSize, int nowPage, Session session) throws Exception;

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
    public abstract FlsPageEntity queryThemeForPageSearchKey(String hql, String searchKey, int pageSize, int nowPage, Session session) throws Exception;

    /**
     * 查询总数
     *
     * @param hql
     * @param session
     * @return int
     * @throws Exception
     */
    public abstract int getThemesConutByHQL(String hql, Session session) throws Exception;
}

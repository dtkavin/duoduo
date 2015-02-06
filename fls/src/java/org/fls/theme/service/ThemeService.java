/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.theme.service;

import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.theme.entity.FlsThemeEntity;

/**
 * 主题service
 *
 * @author Tone
 */
public interface ThemeService {

    /**
     * 发布主题
     *
     * @param themeEntity
     * @return FlsMsgEntity
     */
    public abstract FlsMsgEntity sendTheme(FlsThemeEntity themeEntity,StringBuffer keyBuffer) throws Exception;

    /**
     * 按照主键查找主题
     *
     * @param theme_id
     * @return FlsThemeEntity
     */
    public abstract FlsThemeEntity queryThemeByID(String theme_id) throws Exception;

    /**
     * 更新主题
     *
     * @param themeEntity
     * @throws Exception
     */
    public abstract void updateTheme(FlsThemeEntity themeEntity) throws Exception;

    /**
     * 取得总数
     *
     * @param hql
     * @return int
     * @throws Exception
     */
    public abstract int getThemesCountByHQL(String hql) throws Exception;

    /**
     * 搜索 按照特定的选项查找主题
     *
     * @return int
     */
    public abstract int getAllThemeCount() throws Exception;

    /**
     * 分页查询主题
     *
     * @param pageSize
     * @param nowPage
     * @param type
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryForPageMenuByType(int pageSize, int nowPage, String type) throws Exception;

    /**
     * 搜索 按照特定的关键字查找主题
     *
     * @param pageSize
     * @param nowPage
     * @param searchKey
     * @return FlsPageEntity
     * 
     */
    public abstract FlsPageEntity queryForPageBySearchKey(int pageSize, int nowPage, String searchKey) throws Exception;
}

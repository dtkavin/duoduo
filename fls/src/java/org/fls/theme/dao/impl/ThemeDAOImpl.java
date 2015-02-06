/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.theme.dao.impl;

import java.util.List;
import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.theme.dao.ThemeDAO;
import org.fls.theme.entity.FlsThemeEntity;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *主题dao实现类
 * @author Tone
 */
@Repository("ThemeDAO")
public class ThemeDAOImpl extends AbstractFlsBaseDAOImpl implements ThemeDAO {

    @Override
    public List<FlsThemeEntity> getThemes(String hql, Session session) throws Exception {
        return (List<FlsThemeEntity>) this.getAllObjectByHQL(hql, session);
    }

    @Override
    public List<String> getOrderThemeTagsByHQL(String hql, int firstNum, int maxNum, Session session) throws Exception {
        return (List<String>) this.getOrderAllobjectByHQL(hql, firstNum, maxNum, session);
    }

    @Override
    public FlsThemeEntity getUniqueThemeByHQL(String hql, Session session) throws Exception {
        return (FlsThemeEntity) this.getUniqueObjectByHQL(hql, session);
    }

    @Override
    public FlsThemeEntity getThemeByID(String id, Session session) throws Exception {
        return (FlsThemeEntity) this.getObjectByID(FlsThemeEntity.class, id, session);
    }

    @Override
    public void saveTheme(FlsThemeEntity themeEntity, Session session) throws Exception {
        this.saveObject(themeEntity, session);
    }

    @Override
    public void updateTheme(FlsThemeEntity themeEntity, Session session) throws Exception {
        this.updateObject(themeEntity, session);
    }

    @Override
    public FlsPageEntity queryThemeForPage(String hql, int pageSize, int nowPage, Session session) throws Exception {
        return this.queryForPage(hql, "", pageSize, nowPage, session);
    }

    @Override
    public FlsPageEntity queryThemeForPageSearchKey(String hql, String searchKey, int pageSize, int nowPage, Session session) throws Exception {
        return this.queryForPage(hql, searchKey, pageSize, nowPage, session);
    }

    @Override
    public int getThemesConutByHQL(String hql, Session session) throws Exception {
        return this.getAllobjectCountByHQL(hql, session);
    }
}

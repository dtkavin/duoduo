/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.theme.service.impl;

import javax.annotation.Resource;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.dao.KeyWordDAO;
import org.fls.common.utils.HotCountUtil;
import org.fls.common.utils.KeyWordFilter;
import org.fls.common.utils.RandomUtils;
import org.fls.theme.dao.ThemeDAO;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.theme.service.ThemeService;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 主题service实现类
 *
 * @author Tone
 */
@Transactional
@Service("ThemeService")
public class ThemeServiceImpl extends AbstractFlsServiceImpl implements ThemeService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private ThemeDAO themeDAO;
    @Resource
    private FlsMsgEntity msgEntity;
    @Resource
    private UserDAO userDAO;
    @Resource
    private KeyWordDAO keyWordDAO;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public FlsMsgEntity sendTheme(FlsThemeEntity themeEntity,StringBuffer keyBuffer) throws Exception {
        //System.out.println("sendTheme");
        //  themeEntity.getTheme_owner().setUser_hot(HotCountUtil.gethot(themeEntity.getTheme_owner().getUser_browse(), themeEntity.getTheme_owner().getUser_issueReplys().size(), themeEntity.getTheme_owner().getUser_issueThemes().size(), themeEntity.getTheme_owner().getUser_followUsers().size(), themeEntity.getTheme_owner().getUser_funUsers().size()));


       String content=themeEntity.getTheme_content();
       
        KeyWordFilter keyWordFilter = KeyWordFilter.getInstance(keyBuffer);
        themeEntity.setTheme_content(keyWordFilter.doFilter(content));
        

        FlsUserEntity userEntity_db = userDAO.getUserByID(themeEntity.getTheme_owner().getUser_id(), getSession());
        userEntity_db.setUser_hot(HotCountUtil.gethot(userEntity_db.getUser_browse(), userEntity_db.getUser_issueReplys().size(), userEntity_db.getUser_issueThemes().size() + 1, userEntity_db.getUser_followUsers().size(), userEntity_db.getUser_funUsers().size()));
        themeEntity.setTheme_owner(userEntity_db);
        themeDAO.saveTheme(themeEntity, getSession());
        msgEntity.setLoginUser(userEntity_db);
        if (content.indexOf("*")==-1&&themeEntity.getTheme_content().indexOf("*") !=-1) {
            msgEntity.setMessage("牢骚 发布成功！ 但存在敏感词 已被过滤");
        }else{
            msgEntity.setMessage("牢骚 发布成功！");
        }
        
        msgEntity.setFlag(true);

        return msgEntity;
    }

    @Override
    public FlsThemeEntity queryThemeByID(String theme_id) throws Exception {
        return themeDAO.getThemeByID(theme_id, getSession());
    }

    @Override
    public void updateTheme(FlsThemeEntity themeEntity) throws Exception {

        themeDAO.updateTheme(themeEntity, getSession());

    }

    @Override
    public FlsPageEntity queryForPageMenuByType(int pageSize, int nowPage, String type) throws Exception {
        String hql = "from FlsThemeEntity theme order by theme.theme_index desc";
        if ("MAX_NEW".equals(type)) {
            hql = "from FlsThemeEntity theme order by theme.theme_index desc";
        } else if ("MAX_YES".equals(type)) {
            hql = "from FlsThemeEntity theme order by theme.theme_yes desc";
        } else if ("MAX_NO".equals(type)) {
            hql = "from FlsThemeEntity theme order by theme.theme_no desc";
        } else if ("MAX_DISS".equals(type)) {
            hql = "select theme from FlsThemeEntity as theme left join theme.theme_replys as replys group by theme order by count(replys) desc";


        } else if ("RAND".equals(type)) {
            hql = "from FlsThemeEntity theme order by theme.theme_index desc";
            nowPage = RandomUtils.getRandom(FlsPageEntity.countTotalPage(pageSize, themeDAO.getThemesConutByHQL(hql, getSession())));

        } else {
            hql = "from FlsThemeEntity theme order by theme.theme_index desc";
        }
        // System.out.println("HQL:"+hql);
        return themeDAO.queryThemeForPage(hql, pageSize, nowPage, getSession());
    }

    @Override
    public FlsPageEntity queryForPageBySearchKey(int pageSize, int nowPage, String searchKey) throws Exception {
        String hql = "from FlsThemeEntity  theme where  theme.theme_owner.user_name like :searchKey"
                + " or theme.theme_tags1 like :searchKey  or  theme.theme_tags2 like :searchKey or theme.theme_tags3 like :searchKey "
                + " or theme.theme_category like :searchKey or theme.theme_content like:searchKey ";
        // System.out.println("HQL:"+hql);
        if ("按关键字/昵称/编号搜索".equals(searchKey)) {
            hql = "from FlsThemeEntity theme order by theme.theme_index desc";
            searchKey = null;
        }
        return themeDAO.queryThemeForPageSearchKey(hql, searchKey, pageSize, nowPage, getSession());
    }

    @Override
    public int getThemesCountByHQL(String hql) throws Exception {
        return themeDAO.getThemesConutByHQL(hql, getSession());
    }

    @Override
    public int getAllThemeCount() throws Exception {
        return themeDAO.getThemesConutByHQL("from FlsThemeEntity", getSession());
    }
}

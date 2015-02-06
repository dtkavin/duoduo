/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.fls.common.base.entitys.FlsAreaConfigEntity;
import org.fls.common.base.entitys.FlsBaseConfigEntity;
import org.fls.common.base.entitys.KeyWordEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.dao.AreaConfigDAO;
import org.fls.common.dao.ConfigDAO;
import org.fls.common.dao.KeyWordDAO;
import org.fls.common.init.FlsInitUtils;
import org.fls.common.service.InitService;
import org.fls.theme.dao.ThemeDAO;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 初始化service实现类
 *
 * @author Tone
 */
@Transactional
@Service("InitService")
public class InitServiceImpl extends AbstractFlsServiceImpl implements InitService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private AreaConfigDAO areaConfigDAO;
    @Resource
    private ConfigDAO configDAO;
    @Resource
    private UserDAO userDAO;
    @Resource
    private ThemeDAO themeDAO;
    @Resource
    private KeyWordDAO keyWordDAO;
    @Resource
    private ServletContext servletContext;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<FlsBaseConfigEntity> getThemeCategorys() throws Exception {
        String hql = "from FlsBaseConfigEntity as BaseConfig  where BaseConfig.config_key='category' and BaseConfig.config_flag='T'";

        return configDAO.getConfigsByHQL(hql, getSession());

    }

    @Override
    public List<FlsAreaConfigEntity> getAreaConfigsByType(String type) throws Exception {
        String hql = "";

        if ("1".equals(type)) {
            hql = "from FlsAreaConfigEntity where  levlFlag=1";
        } else if ("2".equals(type)) {
            hql = "from FlsAreaConfigEntity where  levlFlag=2";
        }
        if ("3".equals(type)) {
            hql = "from FlsAreaConfigEntity where  levlFlag=3";
        }
        return areaConfigDAO.getAreaConfigsByHQL(hql, getSession());
    }

    @Override
    public FlsBaseConfigEntity getConfig(String hql) throws Exception {
        return configDAO.getUniqueConfigByHQL(hql, getSession());
    }

    @Override
    public List<FlsBaseConfigEntity> getUrl() throws Exception {

        String hql = "from FlsBaseConfigEntity as BaseConfig  where BaseConfig.config_key='url' and BaseConfig.config_flag='T'";
        return configDAO.getConfigsByHQL(hql, getSession());
    }

    @Override
    public List<FlsUserEntity> getUser() throws Exception {
        String hql = "from FlsUserEntity as user  order by user.user_hot";
        List<FlsUserEntity> userEntitys = userDAO.getOrderAllUsersByHQL(hql, 0, 30, getSession());
        for (FlsUserEntity flsUserEntity : userEntitys) {
            if (flsUserEntity.getUser_imageurl() != null && !"".equals(flsUserEntity.getUser_imageurl())) {
                //
                String realPath = servletContext.getRealPath("/Images/faces");
                String fileName = flsUserEntity.getUser_imageurl();
                String userPhoto = realPath + File.separator + fileName;
                //System.out.println(userPhoto);
                flsUserEntity.setImageFlag(new File(userPhoto).exists());
            }
        }

        return userEntitys;
        // return userDAO.getOrderAllUsersByHQL(hql, 0, 30, getSession());
    }

    @Override
    public List<String> getTags() throws Exception {

        String hql1 = "select theme.theme_tags1   from  FlsThemeEntity as theme  group by  theme.theme_tags1 order by count(theme)  desc ";
        String hql2 = "select theme.theme_tags2   from  FlsThemeEntity as theme  group by  theme.theme_tags2 order by count(theme)  desc ";
        String hql3 = "select theme.theme_tags3   from  FlsThemeEntity as theme  group by  theme.theme_tags3 order by count(theme)  desc ";
        List<String> tags1liList = themeDAO.getOrderThemeTagsByHQL(hql1, 0, 10, getSession());

        List<String> tags2liList = themeDAO.getOrderThemeTagsByHQL(hql2, 0, 10, getSession());
        List<String> tags3liList = themeDAO.getOrderThemeTagsByHQL(hql3, 0, 10, getSession());

        List<String> allTags = new ArrayList<String>();

        Iterator<String> tags1Iterator = tags1liList.iterator();
        Iterator<String> tags2Iterator = tags2liList.iterator();
        Iterator<String> tags3Iterator = tags3liList.iterator();

        while (tags1Iterator.hasNext()) {
            allTags.add(tags1Iterator.next());
        }
        while (tags2Iterator.hasNext()) {
            allTags.add(tags2Iterator.next());
        }
        while (tags3Iterator.hasNext()) {
            allTags.add(tags3Iterator.next());
        }
        return allTags;
    }

    @Override
    public FlsBaseConfigEntity getAdminEmail() throws Exception {
        String hql = "from FlsBaseConfigEntity as BaseConfig  where BaseConfig.config_key='admin_email' and BaseConfig.config_flag='T'";

        return configDAO.getUniqueConfigByHQL(hql, getSession());
    }

    @Override
    public FlsBaseConfigEntity getAdminpw() throws Exception {
        String hql = "from FlsBaseConfigEntity as BaseConfig  where BaseConfig.config_key='admin_password' and BaseConfig.config_flag='T'";
        return configDAO.getUniqueConfigByHQL(hql, getSession());
    }

    @Override
    public FlsBaseConfigEntity getEmailHost() throws Exception {
        String hql = "from FlsBaseConfigEntity as BaseConfig  where BaseConfig.config_key='mailhost' and BaseConfig.config_flag='T'";
        return configDAO.getUniqueConfigByHQL(hql, getSession());


    }

    @Override
    public int getAllUserNumber() throws Exception {
        String hql = "from FlsUserEntity ";

        return userDAO.getUsersConutByHQL(hql, getSession());
    }

    @Override
    public int getAllThemeNumber() throws Exception {
        String hql = "from  FlsThemeEntity";

        return themeDAO.getThemesConutByHQL(hql, getSession());
    }

    @Override
    public StringBuffer getKeyWordList() throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("tone|");
        String hql = "from KeyWordEntity ";
        List<KeyWordEntity> keyWordEntitys = keyWordDAO.getKeyWordEntitys(hql, getSession());
        for (KeyWordEntity keyWordEntity : keyWordEntitys) {
            buffer.append(keyWordEntity.getKey_value() + "|");
        }
        buffer.deleteCharAt(buffer.length() - 1);

        return buffer;
    }
    @Resource
    private FlsInitUtils initUtils;

    @Override
    public void executeCustomSQL() throws Exception {
        System.out.println("executeCustomSQL  执行");
        List<FlsAreaConfigEntity> areaConfigEntitys = areaConfigDAO.getAreaConfigsByHQL("from FlsAreaConfigEntity", getSession());
        // System.out.println(areaConfigEntitys.size());
        if (areaConfigEntitys.size() <= 0) {
            ArrayList<String> sqlList = initUtils.getAreaList();
            for (String sql : sqlList) {
                // getSession().createQuery(sql).executeUpdate();
                // getSession().flush();
                // getSession().clear();
            }
        }
        List<FlsBaseConfigEntity> configEntitys = configDAO.getConfigsByHQL("from FlsBaseConfigEntity", getSession());
        // System.out.println(configEntitys.size());
        if (configEntitys.size() <= 0) {
            ArrayList<String> sqlList = initUtils.getConfigList();
            for (String sql : sqlList) {
                //getSession().createQuery(sql).executeUpdate();
                // getSession().flush();
                // getSession().clear();
            }
        }



    }
}

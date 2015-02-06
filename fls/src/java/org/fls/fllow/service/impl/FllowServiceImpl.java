/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.fllow.service.impl;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Resource;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.utils.HotCountUtil;
import org.fls.fllow.service.FllowService;
import org.fls.theme.dao.ThemeDAO;
import org.fls.theme.entity.FlsThemeEntity;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 关注处理service的实现类
 * @author Tone
 */
@Transactional
@Service("FllowService")
public class FllowServiceImpl extends AbstractFlsServiceImpl implements FllowService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private ThemeDAO themeDAO;
    @Resource
    private UserDAO userDAO;

    @Override
    public Session getSession() {
      // return this.sessionFactory.openSession();
        return this.sessionFactory.getCurrentSession();
        
    }

    @Override
    public InputStream add_yes(String themeID) throws Exception {
        FlsThemeEntity themeEntity_db = themeDAO.getThemeByID(themeID, getSession());
        //System.out.println(themeEntity_db.getTheme_yes());
        themeEntity_db.setTheme_yes(themeEntity_db.getTheme_yes() + 1);
        //System.out.println(themeEntity_db.getTheme_yes());
        themeDAO.updateTheme(themeEntity_db, getSession());

        return new StringBufferInputStream(themeEntity_db.getTheme_yes() + "");
    }

    @Override
    public InputStream add_no(String themeID) throws Exception {
        FlsThemeEntity themeEntity_db = themeDAO.getThemeByID(themeID, getSession());
        //System.out.println(themeEntity_db.getTheme_no());
        themeEntity_db.setTheme_no(themeEntity_db.getTheme_no() + 1);
        //System.out.println(themeEntity_db.getTheme_no());
        themeDAO.updateTheme(themeEntity_db, getSession());

        return new StringBufferInputStream(themeEntity_db.getTheme_no() + "");
    }

    @Override
    public InputStream addToFav(String userID, String themeID) throws Exception {



        FlsThemeEntity themeEntity = themeDAO.getThemeByID(themeID, getSession());
        FlsUserEntity userEntity_db = userDAO.getUserByID(userID, getSession());

        boolean flag = false;

        Set<FlsThemeEntity> set_db = userEntity_db.getUser_keepThemes();
        Iterator<FlsThemeEntity> iterator_db = set_db.iterator();
        while (iterator_db.hasNext()) {

            FlsThemeEntity themeEntity_db = iterator_db.next();

            if (themeEntity_db.getTheme_id().equals(themeID)) {
                flag = true;
            }
        }

        if (flag) {
            //System.out.println("ALREADY_ADDED");
            return new StringBufferInputStream("ALREADY_ADDED");

        } else {
            //System.out.println("SUCCESSFULLY_ADDED");
            userEntity_db.getUser_keepThemes().add(themeEntity);
            userDAO.updateUser(userEntity_db, getSession());

            return new StringBufferInputStream("SUCCESSFULLY_ADDED");
        }

    }

    @Override
    public InputStream delFromFav(String userID, String themeID) throws Exception {

        boolean flag = false;
        FlsUserEntity userEntity_db = userDAO.getUserByID(userID, getSession());


        Set<FlsThemeEntity> set_db = userEntity_db.getUser_keepThemes();
        Iterator<FlsThemeEntity> iterator_db = set_db.iterator();
        while (iterator_db.hasNext()) {

            FlsThemeEntity themeEntity_db = iterator_db.next();

            if (themeEntity_db.getTheme_id().equals(themeID)) {
                flag = true;
            }
        }

        if (flag) {
            Set<FlsThemeEntity> set_delete = userEntity_db.getUser_keepThemes();
            Iterator<FlsThemeEntity> iterator_delete = set_delete.iterator();
            Set<FlsThemeEntity> set_new = new HashSet<FlsThemeEntity>();

            while (iterator_delete.hasNext()) {
                FlsThemeEntity themeEntity_delete = iterator_delete.next();
                if (!themeEntity_delete.getTheme_id().equals(themeID)) {
                    set_new.add(themeEntity_delete);
                }

            }
            userEntity_db.setUser_keepThemes(set_new);
            userDAO.updateUser(userEntity_db, getSession());

            return new StringBufferInputStream("ALREADY_DLETE");


        } else {

            return new StringBufferInputStream("NO_ADD");


        }

    }

    @Override
    public InputStream addFllow(String viewUserID, String seesionUserID) throws Exception {
        FlsUserEntity userEntity_view = userDAO.getUserByID(viewUserID, getSession());
        FlsUserEntity userEntity_session = userDAO.getUserByID(seesionUserID, getSession());


        Set<FlsUserEntity> set_view = userEntity_view.getUser_followUsers();
        boolean flag = false;
        Iterator<FlsUserEntity> iterator_view = set_view.iterator();
        while (iterator_view.hasNext()) {
            FlsUserEntity type = (FlsUserEntity) iterator_view.next();
            if (userEntity_session.getUser_id().equals(type.getUser_id())) {

                flag = true;
            }

        }
        if (flag) {

            Set<FlsUserEntity> set_new = new HashSet<FlsUserEntity>();
            Set<FlsUserEntity> set_old = userEntity_session.getUser_funUsers();
            Iterator<FlsUserEntity> iterator_old = set_old.iterator();
            while (iterator_old.hasNext()) {
                FlsUserEntity userEntity = (FlsUserEntity) iterator_old.next();
                if (!userEntity_view.getUser_id().equals(userEntity.getUser_id())) {
                    set_new.add(userEntity);
                }

            }

            userEntity_session.setUser_funUsers(set_new);
            
            userEntity_session.setUser_hot(HotCountUtil.gethot(userEntity_session.getUser_browse(), userEntity_session.getUser_issueReplys().size(), userEntity_session.getUser_issueThemes().size(), userEntity_session.getUser_funUsers().size(), userEntity_session.getUser_followUsers().size()));
           //人气
            userDAO.updateUser(userEntity_session, getSession());
            //getSession().flush();
            return new StringBufferInputStream("CANCELED_FOLLOWING");
        } else {
            userEntity_view.getUser_followUsers().add(userEntity_session);
           //人气
            userEntity_view.setUser_hot(HotCountUtil.gethot(userEntity_view.getUser_browse(), userEntity_view.getUser_issueReplys().size(), userEntity_view.getUser_issueThemes().size(), userEntity_view.getUser_funUsers().size(), userEntity_view.getUser_followUsers().size()));
           
            userDAO.updateUser(userEntity_view, getSession());
            //getSession().flush();
            return new StringBufferInputStream("FOLLOWING_OK");
        }
    }

    @Override
    public FlsUserEntity getUserForSession(String seesionUserID) throws Exception {
        FlsUserEntity userEntity=userDAO.getUserByID(seesionUserID, getSession());
        //强制同步数据库 否则页面显示将会有问题
        this.getSession().refresh(userEntity);
        return userEntity;
    }
}

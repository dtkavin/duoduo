/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userinfo.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.utils.HotCountUtil;
import org.fls.reply.dao.ReplyDAO;
import org.fls.theme.dao.ThemeDAO;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.fls.userinfo.service.UserInfoService;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息service 实现类
 *
 * @author Tone
 */
@Transactional
@Service("UserInfoService")
public class UserInfoServiceImpl extends AbstractFlsServiceImpl implements UserInfoService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private UserDAO userDAO;
    @Resource
    private ThemeDAO themeDAO;
    @Resource
    private ReplyDAO replyDAO;
    @Resource
    private FlsMsgEntity msgEntity ;
    @Resource
    private ServletContext servletContext;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public FlsUserEntity getUserByMail(String user_mail) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
    public FlsUserEntity getUserInfoByID(String user_id) throws Exception {
        return userDAO.getUserByID(user_id, getSession());
    }

    @Override
    public FlsMsgEntity updateUserInfo(FlsUserEntity userEntity) throws Exception {


        userDAO.updateUser(userEntity, getSession());
        msgEntity.setFlag(true);
        msgEntity.setMessage("个人信息修改成功");
        msgEntity.setLoginUser(userEntity);

        return msgEntity;
    }

    @Override
    public FlsUserEntity viewUserInfo(String viewuser_id, String session_id) throws Exception {
        FlsUserEntity userEntity_db = userDAO.getUserByID(viewuser_id, getSession());
        //更新浏览量
        if (viewuser_id != null && session_id != null && !session_id.equals(viewuser_id)) {
            int count_browse = userEntity_db.getUser_browse();
            count_browse++;
            userEntity_db.setUser_browse(count_browse);
            userEntity_db.setUser_hot(HotCountUtil.gethot(userEntity_db.getUser_browse(), userEntity_db.getUser_issueReplys().size(), userEntity_db.getUser_issueThemes().size(), userEntity_db.getUser_followUsers().size(), userEntity_db.getUser_funUsers().size()));

        }
        userDAO.updateUser(userEntity_db, getSession());


        FlsUserEntity userEntity_session_db = userDAO.getUserByID(session_id, getSession());
        String flag = "NO";
        for (Iterator<FlsUserEntity> iterator = userEntity_session_db.getUser_funUsers().iterator(); iterator.hasNext();) {
            FlsUserEntity userEntity = iterator.next();
            if (viewuser_id.equals(userEntity.getUser_id())) {
                flag = "YES";
            }
            userEntity_db.setFollow_flag(flag);
        }
        userEntity_db.setFollow_flag(flag);

        return userEntity_db;
    }

    @Override
    public FlsPageEntity queryFllowForPage(int pageSize, int currentPage, String viewuser_id, String session_id) throws Exception {
        List<FlsUserEntity> list_new = new ArrayList<FlsUserEntity>();

        FlsUserEntity userEntity_session_db = userDAO.getUserByID(session_id, getSession());
        FlsPageEntity pageEntity_db = this.queryUserFllow(pageSize, currentPage, viewuser_id);

        //循环遍历  看funs 中的用户 那些是 当前登录用户已经加过关注
        List<FlsUserEntity> lis_db = (List<FlsUserEntity>) pageEntity_db.getList();
        Iterator<FlsUserEntity> iterator_db = lis_db.iterator();

        Set<FlsUserEntity> set_session = userEntity_session_db.getUser_funUsers();



        while (iterator_db.hasNext()) {

            FlsUserEntity userEntity_follw = (FlsUserEntity) iterator_db.next();

            String flag = "NO";
            Iterator<FlsUserEntity> iterator_session = set_session.iterator();
            while (iterator_session.hasNext()) {
                FlsUserEntity userEntity_session = (FlsUserEntity) iterator_session.next();

                if (userEntity_follw.getUser_id().equals(userEntity_session.getUser_id())) {
                    flag = "YES";
                }

            }
            userEntity_follw.setFollow_flag(flag);
            list_new.add(userEntity_follw);
        }
        pageEntity_db.setList(list_new);

        return pageEntity_db;
    }

    @Override
    public FlsPageEntity queryFunsForPage(int pageSize, int currentPage, String viewuser_id, String session_id) throws Exception {

        List<FlsUserEntity> list_new = new ArrayList<FlsUserEntity>();

        FlsUserEntity userEntity_session_db = userDAO.getUserByID(session_id, getSession());

        FlsPageEntity pageEntity_db = this.queryUserFuns(pageSize, currentPage, viewuser_id);


        List<FlsUserEntity> list_db = (List<FlsUserEntity>) pageEntity_db.getList();

        Iterator<FlsUserEntity> iterator_db = list_db.iterator();

        Set<FlsUserEntity> set_session = userEntity_session_db.getUser_funUsers();


        while (iterator_db.hasNext()) {

            FlsUserEntity userEntity_follw = (FlsUserEntity) iterator_db.next();

            String flag = "NO";
            Iterator<FlsUserEntity> iterator_session = set_session.iterator();



            while (iterator_session.hasNext()) {
                FlsUserEntity userEntity_session = (FlsUserEntity) iterator_session.next();
                if (userEntity_follw.getUser_id().equals(userEntity_session.getUser_id())) {
                    flag = "YES";
                }

            }
            userEntity_follw.setFollow_flag(flag);

            list_new.add(userEntity_follw);
        }
        pageEntity_db.setList(list_new);


        return pageEntity_db;
    }

    @Override
    public FlsPageEntity queryThemeForPage(int pageSize, int currentPage, String viewuser_id) throws Exception {

        String hql = "from FlsThemeEntity  as  theme where  theme.theme_owner.user_id='" + viewuser_id + "' order by theme_newtime";
        return themeDAO.queryThemeForPage(hql, pageSize, currentPage, getSession());
    }

    @Override
    public FlsPageEntity queryUserFuns(int pageSize, int currentPage, String viewuser_id) throws Exception {
        String hql = "select user.user_followUsers from FlsUserEntity user where user.user_id='" + viewuser_id + "'";
        FlsPageEntity pageEntity = userDAO.queryUserForPage(hql, pageSize, currentPage, getSession());
        String realPath = servletContext.getRealPath("/Images/faces");
        for (Object object : pageEntity.getList()) {
            ((FlsUserEntity) object).setImageFlag(new File(realPath + File.separator + ((FlsUserEntity) object).getUser_imageurl()).exists());

        }
        return pageEntity;
        //return userDAO.queryUserForPage(hql, pageSize, currentPage, getSession());
    }

    @Override
    public FlsPageEntity queryUserFllow(int pageSize, int page, String viewuser_id) throws Exception {
        String hql = "select user.user_funUsers from FlsUserEntity user where user.user_id='" + viewuser_id + "'";
        FlsPageEntity pageEntity = userDAO.queryUserForPage(hql, pageSize, page, getSession());
        String realPath = servletContext.getRealPath("/Images/faces");
        for (Object object : pageEntity.getList()) {
            ((FlsUserEntity) object).setImageFlag(new File(realPath + File.separator + ((FlsUserEntity) object).getUser_imageurl()).exists());
        }
        return pageEntity;
        //return userDAO.queryUserForPage(hql, pageSize, page, getSession());
    }

    @Override
    public FlsPageEntity queryReplyForPage(int pageSize, int currentPage, String viewuser_id) throws Exception {
        String hql = "from FlsReplyEntity  as  reply where  reply.reply_owner.user_id='" + viewuser_id + "' order by reply.reply_newtime";

        return replyDAO.queryReplyForPage(hql, pageSize, currentPage, getSession());

    }

    @Override
    public FlsPageEntity queryFaveForPage(int pageSize, int currentPage, String viewuser_id) throws Exception {
        String hql = "select user.user_keepThemes from FlsUserEntity user where user.user_id='" + viewuser_id + "'";

        return themeDAO.queryThemeForPage(hql, pageSize, currentPage, getSession());
    }

    @Override
    public int getReplysCountBy(String theme_id) throws Exception {

        String hql = "from FlsReplyEntity  as  Reply where  Reply.reply_theme.theme_id='" + theme_id + "'";        //查询语句
        return replyDAO.getReplysConut(hql, getSession());
    }
}

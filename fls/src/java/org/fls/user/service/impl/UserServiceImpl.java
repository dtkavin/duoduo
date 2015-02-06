/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.user.service.impl;

import javax.annotation.Resource;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.utils.DesUtils;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.fls.user.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户service实现类
 *
 * @author Tone
 */
@Transactional
@Service("UserService")
public class UserServiceImpl extends AbstractFlsServiceImpl implements UserService {

    @Resource
    private FlsMsgEntity msgEntity ;
    @Resource
    private UserDAO userDAO;
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public FlsMsgEntity register(FlsUserEntity userEntity) throws Exception {
        String hql_getUserByMail = "FROM FlsUserEntity as USER WHERE USER.user_mail='" + userEntity.getUser_mail() + "'";
        int count_byMail = userDAO.getUsersConutByHQL(hql_getUserByMail, getSession());
        if (count_byMail > 0) {
            msgEntity.setFlag(false);
            msgEntity.setMessage("邮箱已被注册!");
            return msgEntity;
        }
        String hql_getUserByName = "FROM FlsUserEntity as USER WHERE USER.user_name='" + userEntity.getUser_name() + "'";
        int count_byName = userDAO.getUsersConutByHQL(hql_getUserByName, getSession());
        if (count_byName > 0) {
            msgEntity.setFlag(false);
            msgEntity.setMessage("用户名已被注册!");
            return msgEntity;
        }

        userDAO.saveUser(userEntity, getSession());
        msgEntity.setFlag(true);
        msgEntity.setMessage("注册成功!");
        return msgEntity;
    }

    @Override
    public FlsMsgEntity login(FlsUserEntity userEntity) throws Exception {
        DesUtils desUtils = new DesUtils();
        String hql_byMail = "from FlsUserEntity  as USER where USER.user_mail='" + userEntity.getUser_mail() + "'";
        int count_byMail = userDAO.getUsersConutByHQL(hql_byMail, getSession());
        //System.out.println("count_byMail:" + count_byMail);
        //if (count_byMail <0) {
        if (count_byMail <= 0) {
            msgEntity.setMessage("用户名不存在！");
            msgEntity.setFlag(false);
            return msgEntity;
        }

        FlsUserEntity userEntity_db = userDAO.getUniqueUserByHQL(hql_byMail, getSession());
        //System.out.println(desUtils.decrypt(userEntity_db.getUser_password()));
        //System.out.println(userEntity.getUser_password());
        // if (!userEntity.getUser_password().equals(desUtils.decrypt(userEntity_db.getUser_password()))) {
        if (!desUtils.decrypt(userEntity_db.getUser_password()).equals(userEntity.getUser_password())) {
            msgEntity.setMessage("密码错误！");
            msgEntity.setFlag(false);
            return msgEntity;
        } else {
            if ("F".equals(userEntity_db.getUser_flag())) {
                msgEntity.setFlag(false);
                msgEntity.setMessage("NOVIL");
                return msgEntity;
            } else {

                msgEntity.setFlag(true);
                msgEntity.setLoginUser(userEntity_db);
                return msgEntity;
            }
        }

    }
}

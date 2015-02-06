/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userphoto.service.impl;

import java.io.InputStream;
import javax.annotation.Resource;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.user.dao.UserDAO;
import org.fls.user.entity.FlsUserEntity;
import org.fls.userphoto.service.PhotoService;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户照片service 实现类
 *
 * @author Tone
 */
@Transactional
@Service("PhotoService")
public class PhotoServiceImpl extends AbstractFlsServiceImpl implements PhotoService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private UserDAO userDAO;

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public InputStream getUserPohtoByID(String viewuser_id) throws Exception {
        String hql = "from FlsUserEntity user where user.user_id='" + viewuser_id + "'";
        FlsUserEntity userEntity = userDAO.getUniqueUserByHQL(hql, getSession());

        return  userEntity.getUser_photo().getPhoto_blob().getBinaryStream();
    }
}

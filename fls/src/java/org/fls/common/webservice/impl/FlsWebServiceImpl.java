/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.webservice.impl;

import javax.annotation.Resource;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.service.impl.AbstractFlsServiceImpl;
import org.fls.common.webservice.FlsWebService;
import org.fls.user.entity.FlsUserEntity;
import org.fls.user.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 * webservice 实现类
 * @author Tone
 */
@Transactional
public class FlsWebServiceImpl extends AbstractFlsServiceImpl implements FlsWebService {

    @Resource
    private SessionFactory sessionFactory;
    @Resource
    private UserService userService;

    @Override
    public void test(String msg) throws Exception {
        System.out.println("Msg:" + msg);
    }

    @Override
    public String getApplicationInfo(String arg0, String username, String password) throws Exception {
        FlsUserEntity userEntity = new FlsUserEntity();
        System.out.println("帐号："+username);
        System.out.println("密码："+password);
        
        userEntity.setUser_mail(username);
        userEntity.setUser_password(password);
        
        FlsMsgEntity msgEntity = userService.login(userEntity);

        if (!msgEntity.isFlag()) {
            return "没有WebService的权限，请联系管理员.....原因：[" + msgEntity.getMessage() + "]";
        }
        if (!"root".equals(msgEntity.getLoginUser().getUser_power())) {
             return "没有WebService的权限，请联系管理员.....原因：[" + "登录用户非管理员"+ "]";
        }
        System.out.println(arg0);
        return "收到指令【"+arg0+"】";
    }

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}

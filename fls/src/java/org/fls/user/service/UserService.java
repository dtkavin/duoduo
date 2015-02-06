/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.user.service;

import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.user.entity.FlsUserEntity;

/**
 *用户service
 * @author Tone
 */
public interface UserService {
    /**
     * 注册
     * @param userEntity
     * @return FlsMsgEntity
     * @throws Exception 
     */
    public abstract FlsMsgEntity register(FlsUserEntity userEntity) throws Exception;
    /**
     * 登录
     * @param userEntity
     * @return FlsMsgEntity
     * @throws Exception 
     */
    public abstract FlsMsgEntity login(FlsUserEntity userEntity) throws Exception;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userinfo.service;

import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.base.entitys.FlsPageEntity;
import org.fls.user.entity.FlsUserEntity;

/**
 * 用户信息service
 *
 * @author Tone
 */
public interface UserInfoService {

    /**
     * 获取用户信息
     *
     * @param user_mail
     * @return FlsUserEntity
     * @throws Exception
     */
    public abstract FlsUserEntity getUserByMail(String user_mail) throws Exception;

    /**
     * 获取用户信息
     *
     * @param user_id
     * @return FlsUserEntity
     * @throws Exception
     */
    public abstract FlsUserEntity getUserInfoByID(String user_id) throws Exception;
/**
 * 更新用户信息
 * @param userEntity
 * @return
 * @throws Exception 
 */
    public abstract FlsMsgEntity updateUserInfo(FlsUserEntity userEntity) throws Exception;

    /**
     * 查询关注 分页
     *
     * @param pageSize
     * @param currentPage
     * @param viewuser_id
     * @param session_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryFllowForPage(int pageSize, int currentPage, String viewuser_id, String session_id) throws Exception;

    /**
     * 查询 粉丝 分页
     *
     * @param pageSize
     * @param currentPage
     * @param viewuser_id
     * @param session_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryFunsForPage(int pageSize, int currentPage, String viewuser_id, String session_id) throws Exception;

    /**
     * 查询主题 分页
     *
     * @param pageSize
     * @param currentPage
     * @param viewuser_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryThemeForPage(int pageSize, int currentPage, String viewuser_id) throws Exception;

    /**
     * 查询回复 分页
     *
     * @param pageSize
     * @param currentPage
     * @param viewuser_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryReplyForPage(int pageSize, int currentPage, String viewuser_id) throws Exception;

    /**
     * 查询 收藏 分页
     *
     * @param pageSize
     * @param currentPage
     * @param viewuser_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryFaveForPage(int pageSize, int currentPage, String viewuser_id) throws Exception;

    /**
     * 查询 粉丝
     *
     * @param pageSize
     * @param currentPage
     * @param viewuser_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryUserFuns(int pageSize, int currentPage, String viewuser_id) throws Exception;

    /**
     * 查询关注
     *
     * @param pageSize
     * @param page
     * @param viewuser_id
     * @return FlsPageEntity
     * @throws Exception
     */
    public abstract FlsPageEntity queryUserFllow(int pageSize, int page, String viewuser_id) throws Exception;

    /**
     * 查询用户信息
     *
     * @param viewuser_id
     * @param session_id
     * @return FlsUserEntity
     * @throws Exception
     */
    public abstract FlsUserEntity viewUserInfo(String viewuser_id, String session_id) throws Exception;

    /**
     * 查询回复总数
     *
     * @param theme_id
     * @return int
     * @throws Exception
     */
    public abstract int getReplysCountBy(String theme_id) throws Exception;
}

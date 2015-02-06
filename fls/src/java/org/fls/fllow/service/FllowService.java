/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.fllow.service;

import java.io.InputStream;
import org.fls.user.entity.FlsUserEntity;

/**
 * 处理关注的service
 *
 * @author Tone
 */
public interface FllowService {

    /**
     * 加yes
     *
     * @param themeID
     * @return InputStream
     * @throws Exception
     */
    public abstract InputStream add_yes(String themeID) throws Exception;

    /**
     * 加 no
     *
     * @param themeID
     * @return InputStream
     * @throws Exception
     */
    public abstract InputStream add_no(String themeID) throws Exception;

    /**
     * 加入收藏
     *
     * @param userID
     * @param themeID
     * @return InputStream
     * @throws Exception
     */
    public abstract InputStream addToFav(String userID, String themeID) throws Exception;

    /**
     * 删除收藏
     *
     * @param userID
     * @param themeID
     * @return InputStream
     * @throws Exception
     */
    public abstract InputStream delFromFav(String userID, String themeID) throws Exception;

    /**
     * 加关注
     *
     * @param viewUserID
     * @param seesionUserID
     * @return InputStream
     * @throws Exception
     */
    public abstract InputStream addFllow(String viewUserID, String seesionUserID) throws Exception;

    /**
     * 获取user
     *
     * @param seesionUserID
     * @return FlsUserEntity
     * @throws Exception
     */
    public abstract FlsUserEntity getUserForSession(String seesionUserID) throws Exception;
}

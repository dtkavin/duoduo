/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.utils;

/**
 * 人气工具类
 *
 * @author Tone
 */
public class HotCountUtil {

    /**
     * 计算人气值
     *
     * @param user_browse
     * @param user_reply
     * @param user_theme
     * @param user_funs
     * @param user_follow
     * @return int
     */
    public static int gethot(int user_browse, int user_reply, int user_theme, int user_funs, int user_follow) {
        int user_funs_new = user_funs * 30 / 100;
        int user_browse_new = user_browse * 20 / 100;
        int user_theme_new = user_theme * 10 / 100;
        int user_reply_new = user_reply * 10 / 100;
        int user_follow_new = user_follow * 10 / 100;

        int total = 100 + user_funs_new + user_browse_new + user_theme_new + user_reply_new + user_follow_new;
        return total;
    }
}

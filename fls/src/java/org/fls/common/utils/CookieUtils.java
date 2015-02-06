/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.utils;

import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;

/**
 *cookie 工具类
 * @author Tone
 */
public class CookieUtils {
    /**
     * 或缺 cookie
     * @param user_id
     * @param user_pw
     * @param days
     * @return  Cookie
     */
    public static Cookie getCookie(String user_id, String user_pw, int days) {
        String path = ServletActionContext.getRequest().getContextPath();
        Cookie cookie = new Cookie("ReUser", user_id + "#" + user_pw);
        cookie.setMaxAge(days * 24 * 60 * 60);
        cookie.setPath(path);
        return cookie;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}

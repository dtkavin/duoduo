/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *基础继承action 会被其他action继承并实现
 * @author Tone
 */
public abstract class AbstractFlsBaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {

    public static final String LOGIN_USER = "LOGIN_USER";
    public static final String LOGIN_MSG = "LOGIN_MSG";
    public static final String YESMSG = "yesmsg";
    public static final String NOMSG = "nomsg";

    public abstract void setMessage(String mesFalg, String message);
}

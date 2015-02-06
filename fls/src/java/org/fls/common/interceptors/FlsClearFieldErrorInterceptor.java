/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tone
 */
@Component("FlsClearFieldErrorInterceptor")
public class FlsClearFieldErrorInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
        actionSupport.clearErrorsAndMessages();
        String resultCode = actionInvocation.invoke();
        return resultCode;
    }
}

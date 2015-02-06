/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

/**
 *权限控制拦截器
 * @author Tone
 */
@Component("FlsPowerInterceptor")
public class FlsPowerInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
       // System.out.println("---------------------FlsPowerInterceptor");
        HttpServletRequest request = ServletActionContext.getRequest();

        String url = request.getRequestURI();
        System.out.println("url:" + url);
        String param = request.getQueryString();
       // System.out.println("paramparam:" + param);
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

       
        if (true) {
            //System.out.println("进入判断");
            if (session.get("LOGIN_USER") == null) {
                if (url.indexOf("FllowAction")!=-1) {
                    return  actionInvocation.invoke();
                }
                request.setAttribute("nomsg", "请先登录");
                return "login";
            }
        }
        return  actionInvocation.invoke();

    }
}

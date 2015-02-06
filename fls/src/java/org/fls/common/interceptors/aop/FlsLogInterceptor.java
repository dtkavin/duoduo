/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.interceptors.aop;

import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.fls.common.base.entitys.FlsLogEntity;
import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.common.service.LogService;
import org.fls.common.utils.DateUtils;
import org.springframework.stereotype.Component;

/**
 *日志里路切入程序
 * @author Tone
 */
@Aspect
@Component
public class FlsLogInterceptor {

    @Resource
    private LogService logService;

    @Pointcut("execution(* org.fls.user.service.impl.UserServiceImpl.login(..))")
    private void anyMethod() {
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
        FlsMsgEntity msgEntity=(FlsMsgEntity) joinPoint.proceed();
        if (msgEntity.isFlag()) {
			
		
		String ip=ServletActionContext.getRequest().getRemoteAddr();
		String id=msgEntity.getLoginUser().getUser_id();
		
		
		FlsLogEntity logEntity=new FlsLogEntity();
		logEntity.setLog_user_id(id);
		logEntity.setLog_type("login_log");
		logEntity.setLog_user_ip(ip);
		logEntity.setLog_date(DateUtils.getNowDate());
		
		logService.insertLog(logEntity);
		}
		return msgEntity;
       
    }
}

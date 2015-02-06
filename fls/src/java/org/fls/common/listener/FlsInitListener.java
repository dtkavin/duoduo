/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.fls.common.base.entitys.FlsAreaConfigEntity;
import org.fls.common.base.entitys.FlsBaseConfigEntity;
import org.fls.common.service.InitService;
import org.fls.common.utils.DateUtils;
import org.fls.user.entity.FlsUserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *系统初始化监听程序
 * @author Tone
 */
@Component("FlsInitListener")
public class FlsInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("["+DateUtils.getFormatNowDate()+"]启动初始化.......开始");
        
        ServletContext context = servletContextEvent.getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        InitService initService = (InitService) applicationContext.getBean("InitService");
        
        //
        List<FlsBaseConfigEntity> Categorylist = new ArrayList<FlsBaseConfigEntity>();
        List<FlsAreaConfigEntity> provinces = new ArrayList<FlsAreaConfigEntity>();
        List<FlsAreaConfigEntity> citys = new ArrayList<FlsAreaConfigEntity>();
        List<FlsAreaConfigEntity> areas = new ArrayList<FlsAreaConfigEntity>();
        List<String> tagsList = new ArrayList<String>();
        List<FlsUserEntity> userList = new ArrayList<FlsUserEntity>();
        List<FlsBaseConfigEntity> urlList=new ArrayList<FlsBaseConfigEntity>();
        
        StringBuffer keyWordBuffer=new  StringBuffer();

        int userNum = 0;
        int themeNum = 0;
        try {
            //initService.executeCustomSQL();
            
            Categorylist = initService.getThemeCategorys();
            provinces = initService.getAreaConfigsByType("1");
            citys = initService.getAreaConfigsByType("2");
            areas = initService.getAreaConfigsByType("3");
            tagsList = initService.getTags();
            userList = initService.getUser();

            userNum = initService.getAllUserNumber();
            themeNum = initService.getAllThemeNumber();
            
            urlList=initService.getUrl();
            keyWordBuffer=initService.getKeyWordList();



            //System.out.println("Categorylist:"+Categorylist.size());
            context.setAttribute("provinces", provinces);
            context.setAttribute("citys", citys);
            context.setAttribute("areas", areas);
            context.setAttribute("Categorylist", Categorylist);
            context.setAttribute("tagsList", tagsList);
            context.setAttribute("userList", userList);

            context.setAttribute("userNum", userNum);
            context.setAttribute("themeNum", themeNum);
            context.setAttribute("urlList", urlList);
            
            context.setAttribute("keyword", keyWordBuffer);
            
        } catch (Exception ex) {
            Logger.getLogger(FlsInitListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("["+DateUtils.getFormatNowDate()+"]启动初始化.......结束");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.fls.common.base.entitys.FlsAreaConfigEntity;
import org.fls.common.base.entitys.FlsBaseConfigEntity;
import org.fls.common.listener.FlsInitListener;
import org.fls.common.service.InitService;
import org.fls.common.utils.DateUtils;
import org.fls.user.entity.FlsUserEntity;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务 更新配置信息
 * @author Tone
 */
public class FlsApplicationUpdateTimer extends QuartzJobBean {

    private InitService initService;
    private ServletContext servletContext;
    int i = 0;

    @Override
    protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("["+DateUtils.getFormatNowDate()+"]定时更新.......开始");
       

        List<FlsBaseConfigEntity> Categorylist = new ArrayList<FlsBaseConfigEntity>();
        List<FlsAreaConfigEntity> provinces = new ArrayList<FlsAreaConfigEntity>();
        List<FlsAreaConfigEntity> citys = new ArrayList<FlsAreaConfigEntity>();
        List<FlsAreaConfigEntity> areas = new ArrayList<FlsAreaConfigEntity>();
        List<String> tagsList = new ArrayList<String>();
        List<FlsUserEntity> userList = new ArrayList<FlsUserEntity>();
        List<FlsBaseConfigEntity> urlList = new ArrayList<FlsBaseConfigEntity>();

        int userNum = 0;
        int themeNum = 0;
        try {
            
            Categorylist = getInitService().getThemeCategorys();
            provinces = getInitService().getAreaConfigsByType("1");
            citys = getInitService().getAreaConfigsByType("2");
            areas = getInitService().getAreaConfigsByType("3");
            tagsList = getInitService().getTags();
            userList = getInitService().getUser();

            userNum = getInitService().getAllUserNumber();
            themeNum = getInitService().getAllThemeNumber();

            urlList = getInitService().getUrl();



            //System.out.println("Categorylist:"+Categorylist.size());
            getServletContext().setAttribute("provinces", provinces);
            getServletContext().setAttribute("citys", citys);
            getServletContext().setAttribute("areas", areas);
            getServletContext().setAttribute("Categorylist", Categorylist);
            getServletContext().setAttribute("tagsList", tagsList);
            getServletContext().setAttribute("userList", userList);

            getServletContext().setAttribute("userNum", userNum);
            getServletContext().setAttribute("themeNum", themeNum);
            getServletContext().setAttribute("urlList", urlList);
            if (servletContext.getAttribute("updateTime") == null) {
                servletContext.setAttribute("updateTime", i++);
            } else {
                int j = (Integer) servletContext.getAttribute("updateTime");
                servletContext.setAttribute("updateTime", j + 1);

            }

        } catch (Exception ex) {
            Logger.getLogger(FlsInitListener.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("定时任务执行异常");
        }
        System.out.println("["+DateUtils.getFormatNowDate()+"]定时更新.......结束");
    }

    /**
     * @return the initService
     */
    public InitService getInitService() {
        return initService;
    }

    /**
     * @param initService the initService to set
     */
    public void setInitService(InitService initService) {
        this.initService = initService;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * @param servletContext the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

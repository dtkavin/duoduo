/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.entitys;

import java.util.Date;

/**
 *日志类
 * @author Tone
 */
public class FlsLogEntity {
    private String log_id;
    private String log_type;
    private String log_user_id;
    private String log_user_ip;
    private Date log_date;

    /**
     * @return the log_id
     */
    public String getLog_id() {
        return log_id;
    }

    /**
     * @param log_id the log_id to set
     */
    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    /**
     * @return the log_type
     */
    public String getLog_type() {
        return log_type;
    }

    /**
     * @param log_type the log_type to set
     */
    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }

    /**
     * @return the log_user_id
     */
    public String getLog_user_id() {
        return log_user_id;
    }

    /**
     * @param log_user_id the log_user_id to set
     */
    public void setLog_user_id(String log_user_id) {
        this.log_user_id = log_user_id;
    }

    /**
     * @return the log_user_ip
     */
    public String getLog_user_ip() {
        return log_user_ip;
    }

    /**
     * @param log_user_ip the log_user_ip to set
     */
    public void setLog_user_ip(String log_user_ip) {
        this.log_user_ip = log_user_ip;
    }

    /**
     * @return the log_date
     */
    public Date getLog_date() {
        return log_date;
    }

    /**
     * @param log_date the log_date to set
     */
    public void setLog_date(Date log_date) {
        this.log_date = log_date;
    }
}

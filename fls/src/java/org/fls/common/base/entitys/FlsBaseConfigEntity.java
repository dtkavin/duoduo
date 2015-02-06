/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.entitys;

import java.sql.Date;

/**
 *基础配置类
 * @author Tone
 */
public class FlsBaseConfigEntity {

    private int config_id;
    private String config_key;
    private String config_value;
    private String config_db_value;
    private String config_flag;
    private String config_mark;
    private String config_modifydate;

    /**
     * @return the config_id
     */
    public int getConfig_id() {
        return config_id;
    }

    /**
     * @param config_id the config_id to set
     */
    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    /**
     * @return the config_key
     */
    public String getConfig_key() {
        return config_key;
    }

    /**
     * @param config_key the config_key to set
     */
    public void setConfig_key(String config_key) {
        this.config_key = config_key;
    }

    /**
     * @return the config_value
     */
    public String getConfig_value() {
        return config_value;
    }

    /**
     * @param config_value the config_value to set
     */
    public void setConfig_value(String config_value) {
        this.config_value = config_value;
    }

    /**
     * @return the config_db_value
     */
    public String getConfig_db_value() {
        return config_db_value;
    }

    /**
     * @param config_db_value the config_db_value to set
     */
    public void setConfig_db_value(String config_db_value) {
        this.config_db_value = config_db_value;
    }

    /**
     * @return the config_flag
     */
    public String getConfig_flag() {
        return config_flag;
    }

    /**
     * @param config_flag the config_flag to set
     */
    public void setConfig_flag(String config_flag) {
        this.config_flag = config_flag;
    }

    /**
     * @return the config_mark
     */
    public String getConfig_mark() {
        return config_mark;
    }

    /**
     * @param config_mark the config_mark to set
     */
    public void setConfig_mark(String config_mark) {
        this.config_mark = config_mark;
    }

    /**
     * @return the config_modifydate
     */
    public String getConfig_modifydate() {
        return config_modifydate;
    }

    /**
     * @param config_modifydate the config_modifydate to set
     */
    public void setConfig_modifydate(String config_modifydate) {
        this.config_modifydate = config_modifydate;
    }
}

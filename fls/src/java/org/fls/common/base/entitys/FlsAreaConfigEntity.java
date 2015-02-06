/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.entitys;

/**
 *地区类
 * @author Tone
 */
public class FlsAreaConfigEntity {

    private int id;
    private String topid;
    private String name;
    private String levlFlag;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the topid
     */
    public String getTopid() {
        return topid;
    }

    /**
     * @param topid the topid to set
     */
    public void setTopid(String topid) {
        this.topid = topid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the levlFlag
     */
    public String getLevlFlag() {
        return levlFlag;
    }

    /**
     * @param levlFlag the levlFlag to set
     */
    public void setLevlFlag(String levlFlag) {
        this.levlFlag = levlFlag;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.entitys;

/**
 *
 * @author Tone
 */
public class KeyWordEntity {
    private int key_id;
    private String key_value;
    private String remark;

    /**
     * @return the key_id
     */
    public int getKey_id() {
        return key_id;
    }

    /**
     * @param key_id the key_id to set
     */
    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    /**
     * @return the key_value
     */
    public String getKey_value() {
        return key_value;
    }

    /**
     * @param key_value the key_value to set
     */
    public void setKey_value(String key_value) {
        this.key_value = key_value;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}

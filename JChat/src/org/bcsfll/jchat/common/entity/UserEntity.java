/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.jchat.common.entity;

import java.io.Serializable;

/**
 *
 * @author tone
 */
public class UserEntity implements Serializable{
    private String userLocalHostIP;
    private String userLocalHostName;
    private String userName;

    public UserEntity(String userLocalHostIP, String userLocalHostName, String userName) {
        this.userLocalHostIP = userLocalHostIP;
        this.userLocalHostName = userLocalHostName;
        this.userName = userName;
    }
    public UserEntity(String userLocalHostIP, String userLocalHostName) {
        this.userLocalHostIP = userLocalHostIP;
        this.userLocalHostName = userLocalHostName;
        this.userName = userLocalHostName;
    }

    /**
     * @return the userLocalHostIP
     */
    public String getUserLocalHostIP() {
        return userLocalHostIP;
    }

    /**
     * @param userLocalHostIP the userLocalHostIP to set
     */
    public void setUserLocalHostIP(String userLocalHostIP) {
        this.userLocalHostIP = userLocalHostIP;
    }

    /**
     * @return the userLocalHostName
     */
    public String getUserLocalHostName() {
        return userLocalHostName;
    }

    /**
     * @param userLocalHostName the userLocalHostName to set
     */
    public void setUserLocalHostName(String userLocalHostName) {
        this.userLocalHostName = userLocalHostName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public boolean equals(Object obj) {
        
        if(obj == null || this == obj) {
            return false;
        }
        if(obj instanceof UserEntity) {
            UserEntity userEntity = (UserEntity)obj;
            if(userEntity.userLocalHostIP.equals(this.userLocalHostIP)&&
                  userEntity.userLocalHostName.equals(this.userLocalHostName) && 
                    userEntity.userName.equals(this.userName)) {
                return true;
            }
        }
        return super.equals(obj);
    }
}

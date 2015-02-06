/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.webservice;

/**
 * webservice
 * @author Tone
 */
public interface FlsWebService {
    /**
     * 测试方法
     * @param msg
     * @throws Exception 
     */
    public abstract void test(String msg) throws Exception;
    /**
     * 业务处理方法
     * @param arg0
     * @param username
     * @param password
     * @return String
     * @throws Exception 
     */
    public abstract String getApplicationInfo(String arg0,String username,String password)throws Exception;
}

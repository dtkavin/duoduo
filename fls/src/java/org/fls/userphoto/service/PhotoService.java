/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.userphoto.service;


import java.io.InputStream;


/**
 *用户照片service
 * @author Tone
 */
public interface PhotoService {
    /**
     * 获取诈骗
     * @param viewuser_id
     * @return InputStream
     * @throws Exception 
     */
    public abstract InputStream getUserPohtoByID(String viewuser_id) throws Exception;
}

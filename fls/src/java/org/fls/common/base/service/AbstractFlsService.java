/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.base.service;

import org.hibernate.classic.Session;

/**
 *核心service 其实现类将被其他service继承
 * @author Tone
 */
public interface AbstractFlsService {
   /**
    * 获取 session对象
    * @return  org.hibernate.classic.Session
    */
    public abstract Session getSession();
}

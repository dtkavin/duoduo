/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.test.dao;

import org.fls.test.entity.FlsBugEntity;
import org.hibernate.classic.Session;

/**
 * bug处理
 *
 * @author Tone
 */
public interface BugDAO {

    /**
     * 保存bug
     *
     * @param bugEntity
     * @param session
     * @throws Exception
     */
    public abstract void saveBug(FlsBugEntity bugEntity, Session session) throws Exception;
}

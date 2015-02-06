/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao;

import java.util.List;
import org.fls.common.base.entitys.KeyWordEntity;
import org.hibernate.classic.Session;

/**
 *
 * @author Tone
 */
public interface KeyWordDAO {
    public abstract List<KeyWordEntity> getKeyWordEntitys(String hql,Session session)throws Exception;
}

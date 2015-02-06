/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.dao.impl;

import java.util.List;
import org.fls.common.base.dao.impl.AbstractFlsBaseDAOImpl;
import org.fls.common.base.entitys.KeyWordEntity;
import org.fls.common.dao.KeyWordDAO;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tone
 */
@Repository("KeyWordDAO")
public class KeyWordDAOImpl extends AbstractFlsBaseDAOImpl implements KeyWordDAO{

    @Override
    public List<KeyWordEntity> getKeyWordEntitys(String hql,Session session) throws Exception {
        return  (List<KeyWordEntity>) this.getAllObjectByHQL(hql, session);
    }
    
}

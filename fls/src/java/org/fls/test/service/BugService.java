/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.test.service;

import org.fls.common.base.entitys.FlsMsgEntity;
import org.fls.test.entity.FlsBugEntity;

/**
 *
 * @author Tone
 */
public interface BugService {
  public abstract FlsMsgEntity submitBug(FlsBugEntity bugEntity)throws Exception;
}

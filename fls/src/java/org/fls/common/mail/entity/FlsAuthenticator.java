/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.mail.entity;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 验证类
 *
 * @author Tone
 */
public class FlsAuthenticator extends Authenticator {

    private String userName;
    private String password;

    public FlsAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(userName, password);
    }
}

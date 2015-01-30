/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.jchat.common.utiliy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tone
 */
public class NetUtil {

    /**
     * 获取本机的主机名
     *
     * @return
     */
    public static String getLocalhostName() {
        String hostName = null;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostName = inetAddress.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hostName;
    }

    /**
     * 获取本机的IP地址
     *
     * @return
     */
    public static String getLocalhostIP() {
        String hostIP = null;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostIP = inetAddress.getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hostIP;
    }
   
}

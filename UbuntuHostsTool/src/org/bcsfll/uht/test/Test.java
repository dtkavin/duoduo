/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bcsfll.uht.ui.utiliy.NetUtil;
import org.bcsfll.uht.ui.utiliy.OSUtil;

/**
 *
 * @author tone
 */
public class Test {
     private  final  static String COOKIE="hostspasscode=%s; Hm_lvt_e26a7cd6079c926259ded8f19369bf0b=1421846509,1421846927,1421847015,1421849633; Hm_lpvt_e26a7cd6079c926259ded8f19369bf0b=1421849633";
   
    public  static  void main(String[] args) throws  Exception{
        StringBuffer buffer=new StringBuffer();
        String hostName=OSUtil.getInstance().getLocalhostName();
        buffer.append("#LOCALHOST begin"+"\n");
        buffer.append("127.0.0.1\tlocalhost"+"\n");
        if (hostName!=null&&!"".equals(hostName)) {
             buffer.append("127.0.1.1\t"+hostName+"\n");
        }
        
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
        
        
        
}

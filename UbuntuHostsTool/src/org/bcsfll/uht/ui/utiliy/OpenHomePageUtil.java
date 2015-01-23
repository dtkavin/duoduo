/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.ui.utiliy;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tone
 */
public class OpenHomePageUtil {

    public OpenHomePageUtil(String url) throws Exception {
        //获取系统类型 MAC  linux  Windows
        String osName = System.getProperty("os.name");


        if (osName.startsWith("Mac OS")) {

            Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
            Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[]{String.class});
            openURL.invoke(null, new Object[]{url});
        } else if (osName.startsWith("Windows")) {
            //Windows 
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else {
            //Unix or Linux 
            //列举 Unix or Linux 平台下可能的浏览器
            String[] browsers = {"firefox", "opera", "konqueror",
                "epiphany", "mozilla", "netscape", "w3m"};
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++) {
                if (Runtime.getRuntime().exec(
                        new String[]{"which", browsers[count]})
                        .waitFor() == 0) {
                    browser = browsers[count];
                }
            }
            if (browser != null) {
                Runtime.getRuntime().exec(new String[]{browser, url});
            }
        }

    }
}

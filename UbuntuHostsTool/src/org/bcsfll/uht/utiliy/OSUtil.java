/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.utiliy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tone
 */
public class OSUtil {

    private final static String OSNAME_LINUX = "Linux";
    private final static String HOSTS_LINUX = "/etc/hosts";
    private final static String HOSTS_LINUX_PATH = "/etc";
    private final static String OSNAME_WINDOWS = "Windows";
    private final static String HOSTS_WINDOWS = "C:\\WINDOWS\\system32\\drivers\\etc\\hosts";
    private final static String HOSTS_WINDOWS_PATH = "C:\\WINDOWS\\system32\\drivers\\etc";
    private static String osType = null;
    private static OSUtil instance;
    public final static String ERROR_STRING = "HOSTSTOOLSCMDERROR";

    public static OSUtil getInstance() {
        if (instance == null) {
            instance = new OSUtil();
        }
        return instance;
    }

    private OSUtil() {
        osType = getOSType();

    }

    /**
     * 取得hosts文件的全路径名称
     *
     * @return
     * @throws Exception
     */
    public String getHostsFilePathName() throws Exception {
        if (osType.startsWith(OSNAME_LINUX)) {
            return HOSTS_LINUX;
        } else if (osType.startsWith(OSNAME_WINDOWS)) {
            return HOSTS_WINDOWS;
        } else {
            throw new Exception("暂不支持的操作系统！");
        }


    }

    /**
     * 取得hosts放置的路径
     *
     * @return
     * @throws Exception
     */
    public String getHostsFilePath() throws Exception {
        if (osType.startsWith(OSNAME_LINUX)) {
            return HOSTS_LINUX_PATH;
        } else if (osType.startsWith(OSNAME_WINDOWS)) {
            return HOSTS_WINDOWS_PATH;
        } else {
            throw new Exception("暂不支持的操作系统！");
        }


    }

    /**
     * 取得操作系统类型
     *
     * @return
     */
    private String getOSType() {

        return System.getProperty("os.name");
    }

    /**
     * 获取本机HOST名
     *
     * @return
     * @throws UnknownHostException
     */
    public String getLocalhostName() throws UnknownHostException {
        String hostName = null;

        InetAddress inetAddress = InetAddress.getLocalHost();
        hostName = inetAddress.getHostName();

        return hostName;
    }

    public String reSatrtNet() {
        final StringBuffer msg = new StringBuffer();

        try {
            if (osType.startsWith(OSNAME_LINUX)) {

                ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"/bin/sh", "-c", "/etc/init.d/networking restart"});

                Process process = processBuilder.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    msg.append(line);
                }


            } else if (osType.startsWith(OSNAME_WINDOWS)) {

                Process process = Runtime.getRuntime().exec("cmd.exe /c ipconfig /flushdns");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    msg.append(line);
                }

            } else {
                msg.append(ERROR_STRING + ":" + "不支持的操作系统");
               
            }
        } catch (IOException ex) {
            Logger.getLogger(OSUtil.class.getName()).log(Level.SEVERE, null, ex);
            msg.append(ERROR_STRING + ":" + ex);
        }



        System.out.println("3:" + msg.toString());
        return msg.toString();

    }
}

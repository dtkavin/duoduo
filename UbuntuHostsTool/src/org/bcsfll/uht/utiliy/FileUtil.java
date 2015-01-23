/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.utiliy;

import org.bcsfll.uht.utiliy.OSUtil;
import org.bcsfll.uht.utiliy.DateUtil;
import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;
import org.bcsfll.uht.ui.utiliy.ProgressUtil;

/**
 *
 * @author tone
 */
public class FileUtil {
    //编码格式

    private final static String ENCODING = "UTF-8";
    private final static String TAG = "hoststoolbak";

    /**
     * 读取文件内容 主要用于读取本机文件内容
     *
     * @param pathName 文件全路径名
     * @return String类型的文件内容
     * @throws Exception
     */
   /* public static String readFile(String pathName) throws Exception {


        StringBuffer fileContent = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(pathName)), ENCODING);
        
        //
        char[] temp = new char[1024];
        int index;
        while ((index = reader.read(temp)) != -1) {
            //System.out.println(index);
            fileContent.append(new String(temp, 0, index));
        }
        reader.close();

        return fileContent.toString();


    }*/
    public static String readFile(String pathName) throws Exception {

        ProgressMonitorInputStream pmis=ProgressUtil.getMonitorInputStream(new FileInputStream(new File(pathName)), "读取文件内容");
        StringBuffer fileContent = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(pmis, ENCODING);
        
        //
        char[] temp = new char[1024];
        int index;
        while ((index = reader.read(temp)) != -1) {
            //System.out.println(index);
            fileContent.append(new String(temp, 0, index));
        }
        reader.close();
        pmis.close();
        
        return fileContent.toString();


    }
    public static String readFile2(String pathName) throws Exception {


        StringBuffer fileContent = new StringBuffer();
        //InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(pathName)), ENCODING);
        ProgressMonitorInputStream pmis=new ProgressMonitorInputStream(null,"",new FileInputStream(new File(pathName)));
        
        ProgressMonitor progressMonitor=pmis.getProgressMonitor();
        progressMonitor.setMillisToDecideToPopup(0);
        
        progressMonitor.setMillisToPopup(0);
        //InputStreamReader reader = new InputStreamReader(new ProgressMonitorInputStream(null,"",new FileInputStream(new File(pathName))), ENCODING);
       InputStreamReader reader = new InputStreamReader(pmis, ENCODING);
        //
        char[] temp = new char[1024];
        int index;
        while ((index = reader.read(temp)) != -1) {
            //System.out.println(index);
            fileContent.append(new String(temp, 0, index));
        }
        reader.close();
        pmis.close();

        return fileContent.toString();


    }

    /**
     * 备份文件
     *
     * @param srcPathName 原有hosts文件全路径名
     * @return 返回备份完成的文件的全路径名
     * @throws Exception IO相关一场
     */
    public static String copyFileToBak(String srcPathName) throws Exception {
        File srcFile = new File(srcPathName);
        if (!srcFile.exists()) {
            throw new Exception("准备复制的文件[" + srcPathName + "] 不存在");
        }
        String tagPathName = srcFile.getCanonicalPath() + "." + TAG + DateUtil.getCopyTime();
        
        copyFile(srcFile, new File(tagPathName));

        return tagPathName;

    }
    /**
     * 还原HOSTS文件
     * @param srcPathName
     * @return
     * @throws Exception 
     */
    public static String copyFileToHost(String bakFilePathName) throws Exception {
        File srcFile = new File(bakFilePathName);
        if (!srcFile.exists()) {
            throw new Exception("准备还原的文件[" + bakFilePathName + "] 不存在");
        }
       String hostPathName= OSUtil.getInstance().getHostsFilePathName();
       copyFile(srcFile, new File(hostPathName));
       
       return  bakFilePathName;
    }
    
    /**
     * 复制文件
     * @param srcFile
     * @param tagFile
     * @throws Exception 
     */
    private static  void copyFile(File srcFile,File tagFile) throws Exception{
        FileInputStream inputStream = new FileInputStream(srcFile);
        FileOutputStream outputStream = new FileOutputStream(tagFile);

        byte[] temp = new byte[1024];
        int len;
        while ((len = inputStream.read(temp)) != -1) {
            outputStream.write(temp, 0, len);
        }
        outputStream.flush();
        outputStream.close();
    }
       
       

    /**
     * 获取文件列表
     *
     * @param path 文件路径
     * @throws Exception 错误的异常信息
     */
    public static ArrayList<String>  getFileList(String path,boolean flag) throws Exception {

        File srcFile = new File(path);
        if (!srcFile.exists()) {
            throw new Exception("文件路径[" + path + "] 不存在！");
        }
        ArrayList<String> fileNames = new ArrayList<String>();
        if (srcFile.isDirectory()) {
            for (File file : srcFile.listFiles()) {
                if (!file.isFile()) {
                    continue;
                } else {
                    if (file.getName().indexOf(TAG) != -1&&!file.getName().endsWith("~")) {
                        fileNames.add(file.getCanonicalPath());
                    }
                }
            }
        }
        return sortFileByName(fileNames, flag);
    }
    /**
     * 将文件名集合按照名称排序
     * @param fileNames
     * @param flag
     * @return 
     */
    private static ArrayList<String> sortFileByName(ArrayList<String> fileNames, final boolean flag) {
       
        Collections.sort(fileNames, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if (flag) {
                    return str1.compareTo(str2);
                } else {
                    return -str1.compareTo(str2);
                }

            }
        });
        return fileNames;
    }
    
    public static void writeFile(String hosts,String hostPathName) throws Exception{
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(hostPathName)),ENCODING));
        bufferedWriter.write(hosts);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.File;
import java.net.URL;

/**
 *
 * @author Tone
 */
public class Test {

    public static void main(String [] a) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        URL url = classLoader.getResource("");
        System.out.println("url:" + url);
        String ROOT_CLASS_PATH = url.getPath();
        System.out.println("ROOT_CLASS_PATH" + ROOT_CLASS_PATH);
        File rootFile = new File(ROOT_CLASS_PATH);
        String WEB_INFO_DIRECTORY_PATH = rootFile.getParent();
        System.out.println("WEB_INFO_DIRECTORY_PATH" + WEB_INFO_DIRECTORY_PATH);
        File webinfoDir = new File(WEB_INFO_DIRECTORY_PATH);


        String SERVLET_CONTEXT_PATH = webinfoDir.getParent() ;

        System.out.println(SERVLET_CONTEXT_PATH);


        String pathString = SERVLET_CONTEXT_PATH + File.separator + "Video";

        File file = new File(pathString);
        System.out.println(file.listFiles()[0].getName());
        
        System.out.println(20%4);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.ui.utiliy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tone
 */
public class PropertiesUtil {

    private static PropertiesUtil instance;
    private static Properties properties = null;

    private PropertiesUtil(File file) {
        InputStream inputStream = null;
        try {
            properties = new Properties();
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private PropertiesUtil(InputStream inputStream) {
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PropertiesUtil getInstance(String pathname) {
        if (instance == null) {

            instance = new PropertiesUtil(new File(pathname));
        }
        return instance;
    }
    public static PropertiesUtil getInstance(InputStream inputStream) {
        if (instance == null) {
            instance = new PropertiesUtil(inputStream);
        }
        return instance;
    }
    public static PropertiesUtil getInstance(File file) {
        if (instance == null) {
            instance = new PropertiesUtil(file);
        }
        return instance;
    }

    

    public String getValueByKey(String key) {
        return (String) properties.get(key) == null ? "空" : (String) properties.get(key);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.utils;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tone
 */
public class KeyWordFilter {

    private static Pattern pattern = null;
    private static KeyWordFilter instance;

    private KeyWordFilter(StringBuffer keyBuffer) {
         
        try {
            pattern = Pattern.compile(keyBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static KeyWordFilter getInstance(StringBuffer keyBuffer) {
        if (instance == null) {
            instance = new KeyWordFilter(keyBuffer);
        }
        return instance;
    }

    public  String doFilter(String string) {
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceAll("*");
        return string;
    }
    public static void main(String[] args){
        StringBuffer keyBuffer=new StringBuffer();
        keyBuffer.append("用");
        
        KeyWordFilter filter=KeyWordFilter.getInstance(keyBuffer);
        System.out.println(filter.doFilter("TMD"
                + "这是一句话 测试用的"));
    }
}

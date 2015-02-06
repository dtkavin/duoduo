/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Tone
 */
public class DateUtils {
   private final static SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 或缺当前时间
     *
     * @return Date
     */
    public static Date getNowDate() {

        return new Date();
    }
    public static String getFormatNowDate() {

         return  DATE_FORMAT.format(new Date());
    }

    public static void main(String[] ars) {
        //System.out.println(getNowDate());
    }
}

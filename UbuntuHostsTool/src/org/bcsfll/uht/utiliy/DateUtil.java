/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.utiliy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tone
 */
public class DateUtil {
       private  final  static  SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
       /**
        * 获取备份操作的当前时间
        * @return 
        */
       public static String getCopyTime(){
           return DATE_FORMAT.format(new Date());
       } 
}

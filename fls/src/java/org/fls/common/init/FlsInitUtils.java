/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tone
 */
@Component("FlsInitUtils")
public  final class FlsInitUtils {

    public   ArrayList<String>  getHibernateInfo() {
         ArrayList<String> sqlList=new ArrayList<String>();
         BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("initarea.sql")));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line.substring(0,line.length()-1));
                sqlList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlsInitUtils.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(FlsInitUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sqlList;
    }
    public  static  void main(String[] args){
       new FlsInitUtils().getHibernateInfo();
    }

    public ArrayList<String> getAreaList() {
        ArrayList<String> sqlList=new ArrayList<String>();
         BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("initarea.sql"),"UTF-8"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
               if (line.length()>=1) {
                    line=line.substring(0, line.length()-1);
                }
               
                sqlList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlsInitUtils.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(FlsInitUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sqlList;
    }

    public ArrayList<String> getConfigList() {
        ArrayList<String> sqlList=new ArrayList<String>();
         BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("initbaseconfig.sql"),"UTF-8"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length()>=1) {
                    line=line.substring(0, line.length()-1);
                }
                sqlList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlsInitUtils.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(FlsInitUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sqlList;
    }
}

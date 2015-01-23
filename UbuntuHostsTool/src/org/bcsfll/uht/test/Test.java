/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.test;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;
import org.bcsfll.uht.ui.utiliy.PropertiesUtil;
import org.bcsfll.uht.utiliy.FileUtil;
import org.bcsfll.uht.utiliy.NetUtil;
import org.bcsfll.uht.utiliy.OSUtil;

/**
 *
 * @author tone
 */
public class Test {

    public void reda() {
        ProgressMonitorInputStream pmis = null;
        try {
            // TODO add your handling code here:
            StringBuffer fileContent = new StringBuffer();
            pmis = new ProgressMonitorInputStream(null, "", new FileInputStream(new File("/home/tone/Resident.Evil.Damnation.2012.1080p.BluRay.x264.DTS-WiKi.mkv")));
            ProgressMonitor progressMonitor = pmis.getProgressMonitor();
            progressMonitor.setMillisToDecideToPopup(0);
            //InputStreamReader reader = new InputStreamReader(new ProgressMonitorInputStream(null,"",new FileInputStream(new File(pathName))), ENCODING);
            InputStreamReader reader = new InputStreamReader(pmis);
            //
            char[] temp = new char[2048];
            int index;
            while ((index = reader.read(temp)) != -1) {
                //System.out.println(index);
                //fileContent.append(new String(temp, 0, index));
            }
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pmis.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String readStream(InputStream inputStream, String encoding, Component c1) throws Exception {
        StringBuffer buffer = new StringBuffer();
        ProgressMonitorInputStream pmis = null;

        InputStreamReader inputStreamReader = null;
        GZIPInputStream gZIPInputStream = null;
        if ("123".equals(encoding)) {
            //gZIPInputStream = new GZIPInputStream(inputStream);
            //inputStreamReader = new InputStreamReader(gZIPInputStream, ENCODING);
            gZIPInputStream = new GZIPInputStream(inputStream);
            pmis = new ProgressMonitorInputStream(c1, "读取网络hosts", gZIPInputStream);

            inputStreamReader = new InputStreamReader(pmis, "UTF-8");
        } else {

            // inputStreamReader = new InputStreamReader(inputStream, ENCODING);
            pmis = new ProgressMonitorInputStream(c1, "读取网络hosts", inputStream);
            inputStreamReader = new InputStreamReader(pmis, "UTF-8");

        }
        ProgressMonitor progressMonitor = pmis.getProgressMonitor();
        progressMonitor.setMillisToDecideToPopup(0);
        progressMonitor.setMillisToPopup(0);
        char[] c = new char[2];

        int lenI;
        while ((lenI = inputStreamReader.read(c)) != -1) {

            buffer.append(new String(c, 0, lenI));
           
        }
        System.out.println(buffer.toString());
        if (inputStream != null) {
            inputStream.close();
        }
        if (gZIPInputStream != null) {
            gZIPInputStream.close();
        }
        if (pmis != null) {
            pmis.close();
        }


        return buffer.toString();


    }
    
    public  static  void  main(String[]a) throws Exception{
        FileUtil.readFile("/home/tone/hosts");
    }
}

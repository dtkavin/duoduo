/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.ui.utiliy;

import java.io.InputStream;
import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;

/**
 *
 * @author tone
 */
public class ProgressUtil {
    public  static ProgressMonitorInputStream getMonitorInputStream(InputStream inputStream,String title){
        ProgressMonitorInputStream pmis=new ProgressMonitorInputStream(null, title, inputStream);
        
        ProgressMonitor progressMonitor = pmis.getProgressMonitor();
        progressMonitor.setMillisToDecideToPopup(0);
        progressMonitor.setMillisToPopup(0);
        
        return pmis;
        
    }
}

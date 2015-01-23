/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.ui.utiliy;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.IOException;

/**
 *
 * @author tone
 */
public class ClipboardUtil {
    public static void saveTextOnClipboard(String text) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
    }

    public static String getTextFromClipboard() throws Exception {
        Transferable transferable=Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (null!=transferable&&transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            String text=(String) transferable.getTransferData(DataFlavor.stringFlavor);
            return text;
        }
        return "";
    }
    
}

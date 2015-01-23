/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.ui.utiliy;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tone
 */
public class PropertiesUtilTest {
    
    public PropertiesUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class PropertiesUtil.
     */
    @Test
    public void testGetInstance_String() {
        System.out.println("getInstance");
        String pathname = "/home/tone/about.properties";
        PropertiesUtil expResult = null;
        PropertiesUtil result = PropertiesUtil.getInstance(pathname);
        String aString=result.getValueByKey("info");
         String aString2=result.getValueByKey("version");
        System.out.println(aString);
        System.out.println(aString2);
    }

    
}

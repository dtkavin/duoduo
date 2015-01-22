/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.uht.ui.utiliy;

import java.util.ArrayList;
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
public class FileUtilTest {
    
    public FileUtilTest() {
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
     * Test of readFile method, of class FileUtil.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String pathName = "/home/tone/DateUtil.java";
        String expResult = "";
        String result = FileUtil.readFile(pathName);
        System.out.println(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public  void testCopyFileToBak() throws Exception{
        System.out.println("copyFileToBak");
        String srcPathName="/home/tone/hosts";
        String result = FileUtil.copyFileToBak(srcPathName);
        System.out.println(result);
        
    }
    @Test
    public  void testGetFileList() throws Exception{
        System.out.println("getFileList");
        String srcPathName="/home/tone";
        ArrayList<String> result = FileUtil.getFileList(srcPathName,true);
        for (String string : result) {
            System.out.println(string);
        }
        
        
    }
    @Test
    public  void testWriteFile()throws Exception{
        System.out.println("testWriteFile");
        String srcPathName="/home/tone";
        FileUtil.writeFile("123", "/home/tone/11");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jchat;

import org.bcsfll.jchat.server.hanhler.ServerHandler;


/**
 *
 * @author tone
 */
public class JMSG_Server {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        if (args.length!=0) {
            int serverPort=Integer.valueOf(args[0]);
            ServerHandler.getInstance(serverPort).run();
        }else{
             ServerHandler.getInstance().run();
        }
        
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.jchat.server.hanhler;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bcsfll.jchat.common.entity.UserEntity;


/**
 *
 * @author tone
 */
public class ServerHandler {
    private static final int  SERVERPORT=9999;
    private static ServerHandler instance=null;
    private static  ArrayList<ObjectOutputStream> clientOutputStreams=null;
    private static  ArrayList<UserEntity> userEntitys=null;
    private static ServerSocket serverSocket =null;

    /**
     * @return the userEntitys
     */
    public  ArrayList<UserEntity> getUserEntitys() {
        return userEntitys;
    }

    /**
     * @param aUserEntitys the userEntitys to set
     */
    public  void setUserEntitys(ArrayList<UserEntity> aUserEntitys) {
        userEntitys = aUserEntitys;
    }
    private ServerHandler(int port) {
        try {
            clientOutputStreams=new ArrayList<ObjectOutputStream>(); 
            userEntitys=new ArrayList<UserEntity>();
            serverSocket = new ServerSocket(port);
            System.out.println("**** 服务器启动成功");
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ServerHandler() {
        try {
            clientOutputStreams=new ArrayList<ObjectOutputStream>(); 
            userEntitys=new ArrayList<UserEntity>();
            serverSocket = new ServerSocket(SERVERPORT);
            System.out.println("**** 服务器启动成功");
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the clientOutputStreams
     */
    public ArrayList<ObjectOutputStream> getClientOutputStreams() {
        return clientOutputStreams;
    }
   
   

    public static ServerHandler getInstance(int port) {
        if (instance==null) {
            instance=new ServerHandler(port);
        }
        return instance;
    }
    public static ServerHandler getInstance() {
        if (instance==null) {
            instance=new ServerHandler();
        }
        return instance;
    }
    public void run() {
        try {
            
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("**** "+clientSocket.getInetAddress() + "连接到服务器！");
                
                
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(clientSocket.getOutputStream());
                getClientOutputStreams().add(objectOutputStream);
               
                
                Thread thread=new Thread(new ClientHandler(clientSocket));
               
                thread.start();
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

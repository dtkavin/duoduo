/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.jchat.server.hanhler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bcsfll.jchat.common.entity.MsgEntity;
import org.bcsfll.jchat.common.entity.UserEntity;
import org.bcsfll.jchat.common.utiliy.CommonType;

/**
 *
 * @author tone
 */
public class ClientHandler implements Runnable {
    
    private ObjectInputStream objectInputStream;
    private Socket socket;
    
    public ClientHandler(Socket clientSocket) {
        
        socket = clientSocket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {
            Object object;
            
            while (!socket.isClosed() && (object = objectInputStream.readObject()) != null) {
                MsgEntity msgEntity = (MsgEntity) object;
                System.out.println(msgEntity.toString());
                if (CommonType.MSGRECEIVERTYPE_PRIVATE.equals(msgEntity.getMsgType()) && "list".equals(msgEntity.getMsgContent())) {
                    StringBuffer temp = new StringBuffer();
                    temp.append(">>>>>>>>>>用户列表<<<<<<<<<<" + "\n");
                    for (Iterator<UserEntity> it = ServerHandler.getInstance().getUserEntitys().iterator(); it.hasNext();) {
                        UserEntity userEntity = it.next();
                        temp.append(userEntity.getUserName() + "(" + userEntity.getUserLocalHostName() + "@" + userEntity.getUserLocalHostIP() + ")" + "\n");
                    }
                    temp.append(">>>>>>>>>>用户列表<<<<<<<<<<" + "\n");
                    msgEntity.setMsgContent(temp.toString());
                    
                    tellEveryone(msgEntity);
                    continue;
                }
                if (CommonType.MSGTYPE_LOGIN.equals(msgEntity.getMsgType())) {
                    ServerHandler.getInstance().getUserEntitys().add(msgEntity.getMsgSender());
                    tellEveryone(msgEntity);
                    continue;
                }
                if (CommonType.MSGTYPE_LOGOUT.equals(msgEntity.getMsgType())) {
                    System.out.println(ServerHandler.getInstance().getUserEntitys().size());
                    ArrayList<UserEntity> tempEntitys = new ArrayList<UserEntity>();
                    UserEntity sender = msgEntity.getMsgSender();
                    for (Iterator<UserEntity> it = ServerHandler.getInstance().getUserEntitys().iterator(); it.hasNext();) {
                        UserEntity userEntity = it.next();
                        if (userEntity.getUserName().equals(sender.getUserName()) && userEntity.getUserLocalHostIP().equals(sender.getUserLocalHostIP()) && userEntity.getUserLocalHostName().equals(sender.getUserLocalHostName())) {
                            
                        } else {
                            tempEntitys.add(userEntity);
                        }
                        
                    }
                    ServerHandler.getInstance().setUserEntitys(tempEntitys);
                    
                    System.out.println(tempEntitys.size());
                    tellEveryone(msgEntity);
                    socket.close();
                    continue;
                    
                }
                tellEveryone(msgEntity);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tellEveryone(Object object) {
        for (Iterator<ObjectOutputStream> it = ServerHandler.getInstance().getClientOutputStreams().iterator(); it.hasNext();) {
            try {
               
                it.next().writeObject(object);
            } catch (IOException ex) {
                
                //Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}

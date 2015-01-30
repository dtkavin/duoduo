/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jchat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bcsfll.jchat.common.entity.MsgEntity;
import org.bcsfll.jchat.common.entity.UserEntity;
import org.bcsfll.jchat.common.utiliy.CommonType;
import org.bcsfll.jchat.common.utiliy.NetUtil;

/**
 *
 * @author tone
 */
public class JMSG_Client {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("java -jar JChat.jar address port username");
            System.exit(0);
        }
        String address = args[0];
        int port = Integer.valueOf(args[1]);
        String userName = args[2];
        System.out.println(userName);

        //final Socket socket = new Socket("127.0.0.1", 9999);
        final Socket socket = new Socket(address, port);
        final UserEntity userEntity;
        if ("".equals(userName) || userName == null) {
            
            userEntity = new UserEntity(NetUtil.getLocalhostIP(), NetUtil.getLocalhostName());
        } else {
            userEntity = new UserEntity(NetUtil.getLocalhostIP(), NetUtil.getLocalhostName(), userName);
        }




        Thread thread = new Thread(new Runnable() {
            boolean flag = true;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            @Override
            public void run() {
                try {
                    objectOutputStream.writeObject(new MsgEntity(CommonType.MSGTYPE_LOGIN, userEntity, null, null, null, null));
                    objectOutputStream.flush();
                } catch (Exception ex) {
                    Logger.getLogger(JMSG_Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (flag) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String msg = reader.readLine();


                        
                        if ("exit".equals(msg)) {
                            objectOutputStream.writeObject(new MsgEntity(CommonType.MSGTYPE_LOGOUT, userEntity, null, null, null, null));
                            objectOutputStream.flush();
                            flag = false;
                            System.exit(0);
                        }
                        if ("list".equals(msg)) {
                            //查看在线用户列表
                            objectOutputStream.writeObject(new MsgEntity(CommonType.MSGRECEIVERTYPE_PRIVATE, userEntity, userEntity, null, null, msg));
                            objectOutputStream.flush();
                            continue;
                        }
                        if ("sendto".equals(msg)) {
                            //私聊
                            continue;
                        }
                        objectOutputStream.writeObject(new MsgEntity(CommonType.MSGRECEIVERTYPE_PUBLIC, userEntity, null, null, null, msg));
                        objectOutputStream.flush();

                    } catch (Exception ex) {
                        Logger.getLogger(JMSG_Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            @Override
            public void run() {
                Object object;
                try {
                    while ((object = inputStream.readObject()) != null) {
                        MsgEntity msgEntity = (MsgEntity) object;
                        UserEntity sender = msgEntity.getMsgSender();
                         
                        if (CommonType.MSGTYPE_LOGIN.equals(msgEntity.getMsgType())) {
                            System.out.println("### 用户登录：" + "" + sender.getUserName() + "(" + sender.getUserLocalHostName() + "@" + sender.getUserLocalHostIP() + ")");
                        }
                        if (CommonType.MSGTYPE_LOGOUT.equals(msgEntity.getMsgType())) {
                            System.out.println("### 用户退出：" + "" + sender.getUserName() + "(" + sender.getUserLocalHostName() + "@" + sender.getUserLocalHostIP() + ")");
                        }
                        if (CommonType.MSGRECEIVERTYPE_PUBLIC.equals(msgEntity.getMsgType())) {
                            System.out.println("*** "+sender.getUserName()+"("+ sender.getUserLocalHostName() + "@" + sender.getUserLocalHostIP() +")"+":"+msgEntity.getMsgContent());
                        }
                        if (CommonType.MSGRECEIVERTYPE_PRIVATE.equals(msgEntity.getMsgType())&&msgEntity.getMsgReceiver().equals(userEntity)) {
                            System.out.println(msgEntity.getMsgContent());
                        }


                    }
                } catch (IOException ex) {
                    Logger.getLogger(JMSG_Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JMSG_Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread1.start();
    }
}

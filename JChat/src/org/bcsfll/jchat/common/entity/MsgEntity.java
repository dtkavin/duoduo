/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bcsfll.jchat.common.entity;

import java.io.Serializable;

/**
 *
 * @author tone
 */
public class MsgEntity implements Serializable{

    

    private String msgType;
    private UserEntity msgSender;
    private UserEntity msgReceiver;
    private String msgFileType;
    private String msgFileName;
    private String msgContent;
    private String msgDate;

    public MsgEntity(String msgType, UserEntity msgSender, UserEntity msgReceiver, String msgFileType, String msgFileName, String msgContent) {
        this.msgType = msgType;
        this.msgSender = msgSender;
        this.msgReceiver = msgReceiver;
        this.msgFileType = msgFileType;
        this.msgFileName = msgFileName;
        this.msgContent = msgContent;
        
    }

    /**
     * @return the msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * @param msgType the msgType to set
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * @return the msgSender
     */
    public UserEntity getMsgSender() {
        return msgSender;
    }

    /**
     * @param msgSender the msgSender to set
     */
    public void setMsgSender(UserEntity msgSender) {
        this.msgSender = msgSender;
    }

    /**
     * @return the msgReceiver
     */
    public UserEntity getMsgReceiver() {
        return msgReceiver;
    }

    /**
     * @param msgReceiver the msgReceiver to set
     */
    public void setMsgReceiver(UserEntity msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    /**
     * @return the msgFileType
     */
    public String getMsgFileType() {
        return msgFileType;
    }

    /**
     * @param msgFileType the msgFileType to set
     */
    public void setMsgFileType(String msgFileType) {
        this.msgFileType = msgFileType;
    }

    /**
     * @return the msgFileName
     */
    public String getMsgFileName() {
        return msgFileName;
    }

    /**
     * @param msgFileName the msgFileName to set
     */
    public void setMsgFileName(String msgFileName) {
        this.msgFileName = msgFileName;
    }

    /**
     * @return the msgContent
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * @param msgContent the msgContent to set
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
    
    @Override
    public String toString() {
        return "MsgEntity{" + "msgType=" + msgType + ", msgSender=" + msgSender + ", msgReceiver=" + msgReceiver + ", msgFileType=" + msgFileType + ", msgFileName=" + msgFileName + ", msgContent=" + msgContent + '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DatabaseHandler.UserData;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.*;
import rmi.client.*;
import view.IClientView;

/**
 *
 * @author sarah
 */
public class ChatModel implements IChatModel {
    
    
    User user;
    Message msg;
    String joptionPaneMassage;
    int serviceNumber;
    
    public ChatModel() {
        
        
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
    
    @Override
    public int getServiceNumber() {
        return serviceNumber;
    }
    
    @Override
    public User getUser() {
        return user;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String getJoptionPaneMassage() {
        return joptionPaneMassage;
    }
    
    public void setJoptionPaneMassage(String joptionPaneMassage) {
        this.joptionPaneMassage = joptionPaneMassage;
    }
    
}

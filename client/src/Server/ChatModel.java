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
    
    IClientListener clientListener;
    User user;
    String joptionPaneMassage;
    int serviceNumber;
    
    public ChatModel() {
        try {
            clientListener = new ClientListener();
            clientListener.changeModel(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

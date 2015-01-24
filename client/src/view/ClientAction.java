/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Contact;
import model.Message;
import model.User;

/**
 *
 * @author Radwa Manssour
 */
public class ClientAction implements IClientAction {
    private User user;
    private int serviceNum;
    private Contact con;
    private Message message;
    
    public ClientAction()throws RemoteException{
        
    }
    @Override
    public User getUser() {
        return user;
    }

    @Override
    public int getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(int serviceNum) {
        this.serviceNum = serviceNum;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Contact getContact() {
        return con;
    }

    public void setCon(Contact con) {
        this.con = con;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
   
    
    
    
}
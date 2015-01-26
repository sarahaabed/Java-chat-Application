/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Server.IServerListner;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contact;
import model.Message;
import model.User;
import view.ActionType;
import view.ClientAction;

/**
 *
 * @author Radwa Manssour
 */
public class ClientInputHandler implements IClientInputHandler {



    
    IServerListner sl;
    ClientAction ca;
    public ClientInputHandler(){
        
        try {
            ca = new ClientAction();
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",5030);
            sl= (IServerListner)reg.lookup("ChatApp");

        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void signUp(User user) {
        
        ca.setUser(user);
        ca.setServiceNum(ActionType.SIGN_UP);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void signIn(User user) {        
        ca.setUser(user);
        ca.setServiceNum(ActionType.SIGN_IN);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void addContact(String mail) {
        Contact con=new Contact(mail, null, null, null, 0);
        ca.setCon(con);
        ca.setServiceNum(ActionType.ADD_CONTACT);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void removeContact(String mail) {
        Contact con=new Contact(mail, null, null, null, 0);
        ca.setCon(con);
        ca.setServiceNum(ActionType.ADD_CONTACT);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changePhoto(User user) {
        ca.setUser(user);
        ca.setServiceNum(ActionType.CHANGE_PHOTO);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changeStatus(User user) {
        ca.setUser(user);
        ca.setServiceNum(ActionType.CHANGE_PHOTO);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changeState(User user) {
        ca.setUser(user);
        ca.setServiceNum(ActionType.CHANGE_STATE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void sendMessage(Message message) {
        ca.setMessage(message);
        ca.setServiceNum(ActionType.SEND_MESSAGE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addMember(int RoomId, String mail) {
        Contact con=new Contact(mail, null, null, null, 0);
        Message message=new Message(RoomId, null, null, null,false);
        ca.setCon(con);
        ca.setMessage(message);
        ca.setServiceNum(ActionType.SEND_MESSAGE);
        try {
            sl.processClientAction(ca);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientInputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void leaveConversation(int RoomId) {
        
    }

    @Override
    public void acceptContact(String mail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rejectContact(String mail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayMessage(Message message) {
        
    }

}
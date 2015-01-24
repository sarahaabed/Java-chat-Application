/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Server.IServerListner;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import model.Contact;
import model.Message;
import model.User;

/**
 *
 * @author Radwa Manssour
 */
public class ClientInputHandler extends UnicastRemoteObject implements IClientInputHandler {

    final static int ADD_CONTACT = 1;
    final static int REMOVE_CONTACT = 2;
    final static int ACCEPT_FRIEND = 3;
    final static int CHANGE_STATE = 4;
    final static int WRITE_STATUS = 5;
    final static int SIGN_UP=6;
    final static int SIGN_IN=7;
    final static int REJECT_FRIEND=8;
    final static int ADD_MEMBER=9;
    final static int LEAVE_CONV=10;
    final static int CHANGE_PHOTO=11;
    final static int SEND_MESSAGE=12;

    
    IServerListner sl;
    ClientAction ca;
    public ClientInputHandler() throws RemoteException {
        
        ca = new ClientAction();

    }

    @Override
    public void signUp(User user) {
        
        ca.setUser(user);
        ca.setServiceNum(SIGN_UP);
        sl.processClientAction(ca);
        
    }

    @Override
    public void signIn(String mail, String pass) {
        User user=new User(mail, pass, null, null);
        ca.setUser(user);
        ca.setServiceNum(SIGN_IN);
        sl.processClientAction(ca);

    }

    @Override
    public void addContact(String mail) {
        Contact con=new Contact(mail, null, null, null, null);
        ca.setCon(con);
        ca.setServiceNum(ADD_CONTACT);
        sl.processClientAction(ca);
        
    }

    @Override
    public void removeContact(String mail) {
        Contact con=new Contact(mail, null, null, null, null);
        ca.setCon(con);
        ca.setServiceNum(ADD_CONTACT);
        sl.processClientAction(ca);
    }

    @Override
    public void changePhoto(User user) {
        ca.setUser(user);
        ca.setServiceNum(CHANGE_PHOTO);
        sl.processClientAction(ca);
    }

    @Override
    public void changeStatus(User user) {
        ca.setUser(user);
        ca.setServiceNum(CHANGE_PHOTO);
        sl.processClientAction(ca);
    }

    @Override
    public void changeState(User user) {
        ca.setUser(user);
        ca.setServiceNum(CHANGE_STATE);
        sl.processClientAction(ca);
       
    }

    @Override
    public void sendMessage(Message message) {
        ca.setMessage(message);
        ca.setServiceNum(SEND_MESSAGE);
        sl.processClientAction(ca);
    }

    @Override
    public void addMember(int RoomId, String mail) {
        Contact con=new Contact(mail, null, null, null, null);
        Message message=new Message(RoomId, null, null, null,false);
        ca.setCon(con);
        ca.setMessage(message);
        ca.setServiceNum(SEND_MESSAGE);
        sl.processClientAction(ca);
        
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
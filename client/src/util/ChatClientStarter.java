/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Server.IChatModel;
import Server.ChatModel;
import Server.IServerListner;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import pkg1.chatCui;
import view.ClientInputHandler;
import view.ClientView;

/**
 *
 * @author bishoy
 */
public class ChatClientStarter {
    public ChatClientStarter(){
        
        ClientView clv = new ClientView(new chatCui());
        clv.getC().setVisible(true);
        ClientInputHandler cih = new ClientInputHandler();
        cih.signUp(new User("mo@yahoo", "123", "bishoy", "male"));
        
    }
    public static void main(String [] args){
        new ChatClientStarter();
    }
}

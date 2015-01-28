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
import rmi.client.ClientListener;
import view.ClientInputHandler;

/**
 *
 * @author bishoy
 */
public class ChatClientStarter {
    
    public ChatClientStarter(){
        
        ClientInputHandler cih = new ClientInputHandler();
        chatCui clv = new chatCui(cih);
        cih.setCc(clv);
        clv.setVisible(true);
        
    }
    public static void main(String [] args){
        new ChatClientStarter();
    }
}

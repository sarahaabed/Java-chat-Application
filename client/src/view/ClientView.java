/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import Server.IChatModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Radwa Manssour
 */
public class ClientView extends UnicastRemoteObject implements IClientView{

    public ClientView()throws RemoteException{
        
    }
    @Override
    public void changeModel(IChatModel chatModel) {
    
    }
    
}
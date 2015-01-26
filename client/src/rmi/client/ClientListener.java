/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi.client;

import Server.IChatModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.User;
import view.ModelType;


/**
 *
 * @author Radwa Manssour
 */
public class ClientListener extends UnicastRemoteObject implements IClientListener{
   /* IClientView clientView;
    public ClientListener(IClientView clientView)throws RemoteException{
        this.clientView=clientView;
    }*/

    public ClientListener() throws RemoteException {
    }
    
    
    @Override
    public void changeModel(IChatModel chatModel) {
        switch(chatModel.getServiceNumber()){
            case ModelType.USER_FOUND:
                User u = chatModel.getUser();
        
        }
        
    }

    @Override
    public void isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author sarah
 */
public class ServerListner extends UnicastRemoteObject implements IServerListner {
    IserverController obj;
     Vector<IClientAction> clientsvector=new Vector<IClientAction>();
    
    public ServerListner() throws RemoteException{
        
        
    }
   
    @Override
    public void processClientAction(IClientAction clientAction) {
        obj=new ServerController(clientAction); 
    }

    @Override
    public void register(IClientAction clientRef) {
        clientsvector.add(clientRef);
        System.out.println("Client Added");
    }

    @Override
    public void unRegister(IClientAction clientRef) {
        clientsvector.remove(clientRef);
        System.out.println("Client Removed");
    }
    
    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import controller.ClientAction;
import controller.IserverController;
import controller.ServerController;
import java.rmi.Remote;

/**
 *
 * @author sarah
 */
public class ServerListner implements IserverListner{
    IserverController obj;
    int serviceNumber;
    public ServerListner(IserverController e){
        this.obj=e;
    }

    @Override
    public void processClientAction(ClientAction clientAction) {
        obj=new ServerController();
        serviceNumber=clientAction.getServiceNo();
        switch(serviceNumber){
            case 1:
               obj.addContact(clientAction.getContact());
                break;
            case 2:
                obj.removeContact(clientAction.getContact().getEmail());
                break;
            case 3:
                obj.acceptFriend(clientAction.getContact().getEmail());
                break;
            case 4:
                obj.changeState();
                break;
            case 5:
                obj.writeState(clientAction.getContact().getStatus());
                break;
        }
    
    }
    

    
}

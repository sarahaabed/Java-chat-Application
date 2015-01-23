/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;

/**
 *
 * @author sarah
 */
public class ServerListner implements IServerListner{
    IserverController obj;
    
    @Override
    public void processClientAction(ClientAction clientAction) {
        obj=new ServerController(clientAction);
   
    
    }
    

    
}

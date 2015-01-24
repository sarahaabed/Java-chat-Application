/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;

/**
 *
 * @author it
 */
public interface IServerListner extends Remote{
    
    public void processClientAction(ClientAction clientAction);
}

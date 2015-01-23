/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import controller.ClientAction;
import java.rmi.Remote;

/**
 *
 * @author sarah
 */
public interface IserverListner extends Remote{
 
        public void processClientAction(ClientAction clientAction);
        
}

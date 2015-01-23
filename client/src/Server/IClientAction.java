/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import model.*;


/**
 *
 * @author it
 */
public interface IClientAction {
    
    public User getUser();

    public Message getMessage();

    public State getState();
    
    public int getServiceNo();

    public Contact getContact();
    
     public Room getRooom();
}

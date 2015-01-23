/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import model.*;

/**
 *
 * @author sarah
 */
class ClientAction implements IClientAction{
    /*
    final static int addContactServiceNo = 1;
    final static int removeContactServiceNo = 2;
    final static int acceptFriendServiceNo = 3;
    final static int changeStateServiceNo = 4;
    final static int writeStateServiceNo = 5;
    */
    //must implemented by radwa to send service no
    
    User user;
    Contact contact;
    Message message;
    State state;
    Room rooom;

    public Room getRooom() {
        return rooom;
    }

    public User getUser() {
        return user;
    }

    public Message getMessage() {
        return message;
    }

    public State getState() {
        return state;
    }
    
    public int getServiceNo() {
        return 1;
        
    }

    public Contact getContact() {
        contact= new Contact("sarahAabed@yahoo", "Sarah", null, null, null);
        return contact;
    }
}

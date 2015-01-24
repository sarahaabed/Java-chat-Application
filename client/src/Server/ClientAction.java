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

  
    @Override
    public User getUser() {
        user=new User("aliaa@yahoo.com","145267","jihad","female");
        return user;
    }

    @Override
    public Message getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getServiceNo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contact getContact() {
        contact= new Contact("sarahAabed@yahoo", "Sarah", null, null, null);
        return contact;
    }
}

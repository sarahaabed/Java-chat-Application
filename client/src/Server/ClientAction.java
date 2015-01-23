/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import model.Contact;

/**
 *
 * @author sarah
 */
class ClientAction {
    final static int addContactServiceNo=1;
    final static int removeContactServiceNo=2;
    final static int acceptFriendServiceNo=3;
    final static int changeStateServiceNo=4;
    final static int writeStateServiceNo=5;
    //must implemented by radwa to send servicde no
    int getServiceNo(){
        return 1;
    }
  Contact getContact(){
        Contact c=new Contact("sarahAabed@yahoo","Sarah", null, null, null);
        return c;
    }
}

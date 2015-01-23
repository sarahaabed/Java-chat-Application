/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Contact;

/**
 *
 * @author sarah
 */
public class ClientAction {
    final static int addContactServiceNo=1;
    final static int removeContactServiceNo=2;
    final static int acceptFriendServiceNo=3;
    final static int changeStateServiceNo=4;
    final static int writeStateServiceNo=5;
    //must implemented by radwa to send servicde no
    public int getServiceNo(){
        return 1;
    }
  public Contact getContact(){
        Contact c=new Contact("sarahAabed@yahoo","Sarah", null, null, null);
        return c;
    }
}

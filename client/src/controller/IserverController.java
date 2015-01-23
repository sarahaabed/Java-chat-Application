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
public interface IserverController {

    void addContact(Contact e);

    void removeContact(String emailId);
    
    void acceptFriend(String emailId);
    
    void changeState();
    
    void writeState(String state);

    public void showAdvertisment();

    public chatModel changeModel(int serviceNo);

}

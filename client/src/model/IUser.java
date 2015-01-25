/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author it
 */
public interface IUser extends Serializable {

    public String getUserEmail();

    public void setUserEmail(String userEmail);

    public String getUserPassword();

    public void setUserPassword(String userPassword);

    public String getUserName();

    public void setUserName(String userName);

    public String getUserGender();

    public void setUserGender(String userGender);

    public State getUserState();

    public void setUserState(State userState);

    public ImageIcon getUserImage();

    public void setUserImage(ImageIcon userImage);

    public String getUserStatus();

    public void setUserStatus(String userStatus);

    public boolean validEmail(String mail);

    public boolean validUserName(String name);

    public boolean validPassword(String pass);

    public Vector<Contact> getUserContacts();

    public void setUserContacts(Vector<Contact> userContacts);

    public Vector<Room> getUserRooms();

    public void setUserRooms(Vector<Room> userRooms);
}

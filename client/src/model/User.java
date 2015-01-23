/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;

/**
 *
 * @author it
 */
public class User implements IUser {

    private String userEmail;
    private String userPassword;
    private String userName;
    private String userGender;
    private State userState;
    private ImageIcon userImage;
    private String userStatus;
    /*About user Profile*/
    public Vector<Contact> userContacts = new Vector<Contact>();
    public Vector<Room> userRooms = new Vector<Room>();
    //want to make vector of friend Requests

    public User(String userEmail, String userPassword, String userName, String userGender) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;

    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public State getUserState() {
        return userState;
    }

    public void setUserState(State userState) {
        this.userState = userState;
    }

    public ImageIcon getUserImage() {
        return userImage;
    }

    public void setUserImage(ImageIcon userImage) {
        this.userImage = userImage;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public boolean validEmail(String mail) {
        //"^(.+)@([^@]+[^.])$"
        if (mail.matches("^(.+)@([^@]+[^.])$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validUserName(String name) {
        //"^(.+)@([^@]+[^.])$"
        if (name.matches("^([a-zA-z_]{5,30})$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validPassword(String pass) {
        //"^(.+)@([^@]+[^.])$"
        if (pass.matches("^([a-zA-z_&%$-.]{6,20})$")) {
            return true;
        } else {
            return false;
        }
    }
}

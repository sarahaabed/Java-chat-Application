/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author it
 */
public interface IUser {
    
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
    
    
}

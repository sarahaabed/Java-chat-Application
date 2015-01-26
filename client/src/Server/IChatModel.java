/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import javax.swing.ImageIcon;
import model.*;

/**
 *
 * @author it
 */
public interface IChatModel {

    public int getServiceNumber();

    public User getUser();

    public String getJoptionPaneMassage();

    public void setUser(User user);

    public void setJoptionPaneMassage(String joptionPaneMassage);

    public void setServiceNumber(int serviceNumber);
    
    public Contact getContact();

    public void setContact(Contact contact);
    

}

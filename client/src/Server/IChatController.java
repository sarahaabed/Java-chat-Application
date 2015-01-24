/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import javax.swing.ImageIcon;
import model.*;

/**
 *
 * @author it
 */
public interface IChatController {

    public void addUser(User user);

    public void addContact(Contact contact);

    public void removeContact(String emailId);

    public void acceptFriend(String emailId);

    public void rejectFriend(String emailId);

    public void changeState(State state);

    public void changeStatus(String status);

    public void ChangeProfilePic(ImageIcon image);

    public void leaveConversation(String email);

    public void sendMessage(String msg);

    public void sendFile(File file);

    public void addContactToRoom(Contact contact);
    //register and unregister
}

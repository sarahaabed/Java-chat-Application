/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import model.*;

/**
 *
 * @author it
 */
public interface IChatController {
    public void sendMessage(String msg);
    public void sendFile(File file);
    public void addContactToRoom(Contact contact);
    //register and unregister
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DatabaseHandler.UserData;
import java.io.File;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.Contact;
import model.State;
import model.User;
import rmi.client.ClientListener;
import view.ModelType;

/**
 *
 * @author it
 */
public class ChatController implements IChatController {

    UserData userData;
    IChatModel chatModel;
    Vector<view.IClientAction> clientsvector = new Vector<view.IClientAction>();

    public ChatController() {
        userData = new UserData();
        chatModel = new ChatModel();
    }

    @Override
    public void sendMessage(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendFile(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addContactToRoom(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(User user) {
        nullChatModel();
        boolean inserted = userData.InsertUser(user);
        String str=user.getUserEmail();
        if (inserted == false) {
            chatModel.setJoptionPaneMassage("E-mail is Already used");
            System.out.println("E-mail is Already used");
        } else {
            System.out.println("User E-mail: "+str);
            chatModel.setJoptionPaneMassage("Inserted successfully");
            chatModel.setServiceNumber(ModelType.USER_FOUND);
            chatModel.setUser(userData.selectUser(user.getUserEmail()));
            User u=new User();
            u=chatModel.getUser();
            System.out.println("User E-mail: "+u.getUserEmail());
           
        }
        
        sendChatModel();
    }

    @Override
    public void addContact(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeContact(String emailId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptFriend(String emailId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rejectFriend(String emailId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ChangeProfilePic(ImageIcon image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leaveConversation(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void register(view.IClientAction clientRef) {
        clientsvector.add(clientRef);
        System.out.println("Client Added");
    }

    @Override
    public void unRegister(view.IClientAction clientRef) {
        clientsvector.remove(clientRef);
        System.out.println("Client Removed");
    }
    void sendChatModel(){
    try {
            ClientListener clientListener = new ClientListener();
            clientListener.changeModel(chatModel);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    void nullChatModel(){
        chatModel.setJoptionPaneMassage(null);
        chatModel.setServiceNumber(0);
        chatModel.setUser(null);
    }
}

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
import model.Room;
import model.State;
import model.User;
import rmi.client.ClientListener;
import rmi.client.IClientListener;
import view.ModelType;

/**
 *
 * @author it
 */
public class ChatController implements IChatController {

    UserData userData;
    IChatModel chatModel;
    public static Vector<IClientListener> clientsvector = new Vector<>();
    

    public ChatController() {
        userData = new UserData();
        chatModel = new ChatModel();
    }

    @Override
    public void sendMessage(String msg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendFile(File file) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addContactToRoom(Contact contact) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(User user) {
        nullChatModel();
        boolean inserted = userData.InsertUser(user);
        String str = user.getUserEmail();
        /* rejectFriend(new User(str,null,null,null), new Contact(str, null, null, null, 8));
         System.out.println("rejected frined succsssefully");*/
        
        
       if (inserted == false) {
            chatModel.setJoptionPaneMassage("E-mail is Already used");
            System.out.println("E-mail is Already used");
            chatModel.setServiceNumber(ModelType.USER_FOUND);
            /*  rejectFriend(user, new Contact(str, null, null, null, 8));
             System.out.println("rejected frined succsssefully");*/
        } else {
            System.out.println("User E-mail: " + str);
            chatModel.setJoptionPaneMassage("Inserted successfully");
            chatModel.setServiceNumber(ModelType.USER_NOTFOUND);
            chatModel.setUser(userData.selectUser(user.getUserEmail()));
            /*  User u=new User();
             u=chatModel.getUser();
             System.out.println("User E-mail: "+u.getUserEmail());*/
            /*  System.out.println("connect to database");
             Contact c=new Contact("sara@yahoo", "ahmed", "ay7aga", null, 8);
             User u=new User();
             u.setUserEmail("rania.huissen@gmail.com");
             acceptFriend(u,c );
             System.out.println("accept frined succsssefully");*/
            // rania.huissen@gmail.com
        }

        //  sendChatModel();
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
    public void acceptFriend(User user, Contact contact) {
        System.out.println("accepted");
        boolean accepted = userData.acceptContact(user.getUserEmail(), contact.getEmail());
        if (accepted) {
            System.out.println("Accept Friend: ");
            chatModel.setJoptionPaneMassage("Accepted successfully");
            chatModel.setServiceNumber(ModelType.ACCEPT_FRIEND);
            chatModel.setContact(userData.selectContact(contact.getEmail()));
        } else {
            System.out.println("NOT Accept Friend: ");
            chatModel.setJoptionPaneMassage("NOt Accepted");
            chatModel.setServiceNumber(ModelType.NOT_ACCEPT_FRIEND);
        }

    }

    @Override
    public void rejectFriend(User user, Contact contact) {
        boolean rejected = userData.rejectContact(user.getUserEmail(), contact.getEmail());
        if (rejected) {
            System.out.println("reject Friend: ");
            chatModel.setJoptionPaneMassage("rejected successfully");
            chatModel.setServiceNumber(ModelType.REJECTED);

        } else {
            System.out.println("NOT reject Friend: ");
            chatModel.setJoptionPaneMassage("NOt rejected");
            chatModel.setServiceNumber(ModelType.NOT_REJECTED);
        }
    }

    @Override
    public void changeState(int state) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeStatus(User user) {
        userData.changeStatus(user);
        try {
            IClientListener clientListner = new ClientListener();
            chatModel.setServiceNumber(ModelType.CHANGE_STATUS);
            clientListner.changeModel(chatModel);

        } catch (RemoteException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    public void register(IClientListener clientRef) {
        clientsvector.add(clientRef);
        System.out.println("Client Added");
    }

    @Override
    public void unRegister(IClientListener clientRef) {
        clientsvector.remove(clientRef);
        System.out.println("Client Removed");
    }
    void sendChatModel(){
    /*try {
            ClientListener clientListener = new ClientListener();
            clientListener.changeModel(chatModel);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    
    }

    void nullChatModel() {
        chatModel.setJoptionPaneMassage(null);
        chatModel.setServiceNumber(0);
        chatModel.setUser(null);
    }

    @Override
    public void signIn(User user,IClientListener clientListener) {
        nullChatModel();
        boolean validMail=false;
        if(userData.validateMail(user.getUserEmail())){
            System.out.println(user.getUserEmail());
            if(userData.validatePass(user.getUserEmail(), user.getUserPassword())){
                try {
                    chatModel.setServiceNumber(ModelType.USER_FOUND);
                    user=userData.retrievetUserInfo(user);
                    chatModel.setUser(user);
                    clientListener.changeModel(chatModel);
                    register(clientListener);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                chatModel.setJoptionPaneMassage("wrong password");
            }
        }else{
            chatModel.setJoptionPaneMassage("invalid password");
        }
        
    }

}

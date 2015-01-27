/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import model.Contact;
import model.User;
import view.*;

/**
 *
 * @author sarah
 */
public class ServerController implements IserverController {

    static view.IClientAction clientAction;
    IChatController chatController;
    IChatModel chatModel;
    int serviceNumber;

    public ServerController(view.IClientAction clientAction) {
        this.clientAction = clientAction;
    }

    public void impelmentClientAction() {
        chatController = new ChatController();
       // ChatModel rr= new ChatModel();
        serviceNumber=clientAction.getServiceNum();
        //serviceNumber = 1;
        //User u=new User("ruhsn@yahoo.com","145267","jihad","female");
        switch (serviceNumber) {
            
            case ActionType.SIGN_UP:
                chatController.addUser(clientAction.getUser());
                //chatController.addUser();
                break;
                
            case ActionType.ADD_CONTACT:
                chatController.addContact(clientAction.getContact());
                break;
                
            case ActionType.REMOVE_CONTACT:
                chatController.removeContact(clientAction.getContact().getEmail());
                break;
                
            case ActionType.ACCEPT_FRIEND:
                chatController.acceptFriend(clientAction.getUser(),clientAction.getContact());
                break;
                
            case ActionType.REJECT_FRIEND:
                chatController.rejectFriend(clientAction.getUser(),clientAction.getContact());
                break;
                
            case ActionType.CHANGE_STATE:
                chatController.changeState(clientAction.getContact().getState());
                break;
                
            case ActionType.WRITE_STATUS:
                chatController.changeStatus(clientAction.getUser());//must has String as parameter
            
            case ActionType.CHANGE_PHOTO:
                chatController.ChangeProfilePic(clientAction.getUser().getUserImage());
            
            case ActionType.LEAVE_CONV:
                chatController.leaveConversation(clientAction.getUser().getUserEmail());
            
            case ActionType.ADD_MEMBER:
                /*Services Related to chathandler*/
                chatController.addContactToRoom(clientAction.getContact());
            
            case ActionType.SEND_MESSAGE:
                chatController.sendMessage("");//must have user message
            
            case ActionType.SIGN_IN:
                chatController.sendFile(new File(""));//must have user file to send
                break;
        }
    }
/*
    public static void main(String[] args) {
        ServerController c = new ServerController(clientAction);
        c.impelmentClientAction();
    }
*/
}

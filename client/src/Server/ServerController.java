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
public class ServerController implements IServerController {

    static view.IClientAction clientAction;
    IChatController chatController;
    IChatModel chatModel;
    int serviceNumber;

    public ServerController(view.IClientAction clientAction) {
        this.clientAction = clientAction;
    }

    public void impelmentClientAction() {
        chatController = new ChatController();
        ChatModel rr= new ChatModel();
        serviceNumber=clientAction.getServiceNum();
       // serviceNumber = 1;
        User u=new User("r@yahoo.com","145267","jihad","female");
        switch (serviceNumber) {
            case 1:
                //chatModel.addUser(clientAction.getUser());
                chatController.addUser(u);
                break;
            case 2:
                chatController.addContact(clientAction.getContact());
                break;
            case 3:
                chatController.removeContact(clientAction.getContact().getEmail());
                break;
            case 4:
                chatController.acceptFriend(clientAction.getContact().getEmail());
                break;
            case 5:
                chatController.rejectFriend(clientAction.getContact().getEmail());
                break;
            case 6:
                chatController.changeState(clientAction.getContact().getState());
                break;
            case 7:
                chatController.changeStatus(clientAction.getUser().getUserStatus());//must has String as parameter
            case 8:
                chatController.ChangeProfilePic(clientAction.getUser().getUserImage());
            case 9:
                chatController.leaveConversation(clientAction.getUser().getUserEmail());
            case 10:
                /*Services Related to chathandler*/
                chatController.addContactToRoom(clientAction.getContact());
            case 11:
                chatController.sendMessage("");//must have user message
            case 12:
                chatController.sendFile(new File(""));//must have user file to send
                break;
        }
    }

    public static void main(String[] args) {
        ServerController c = new ServerController(clientAction);
        c.impelmentClientAction();
    }

}

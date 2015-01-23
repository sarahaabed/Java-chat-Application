/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import model.Contact;

/**
 *
 * @author sarah
 */
public class ServerController implements IserverController{

    IClientAction clientAction;
    IChatController chatController;
    IChatModel chatModel;
    int serviceNumber ;

    public ServerController(IClientAction clientAction) {
        this.clientAction = clientAction;
    }
    
    public void impelmentClientAction(){
     chatController=new ChatController();
     chatModel=new chatModel();
     serviceNumber=clientAction.getServiceNo();
        switch(serviceNumber){
            case 1:
               chatModel.addUser(clientAction.getUser());
                break;
            case 2:
               chatModel.addContact(clientAction.getContact());
                break;
            case 3:
                chatModel.removeContact(clientAction.getContact().getEmail());
                break;
            case 4:
                chatModel.acceptFriend(clientAction.getContact().getEmail());
                break;
            case 5:
                chatModel.rejectFriend(clientAction.getContact().getEmail());
                break;
            case 6:
                chatModel.changeState(clientAction.getContact().getState());
                break;
            case 7:
                chatModel.changeStatus(clientAction.getUser().getUserStatus());//must has String as parameter
            case 8:
                chatModel.ChangeProfilePic(clientAction.getUser().getUserImage());
            case 9:
                chatModel.leaveConversation(clientAction.getUser().getUserEmail());
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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi.client;

import Server.IChatModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.User;
import pkg1.chatCui;
import pkg1.conversation;
import view.ModelType;


/**
 *
 * @author Radwa Manssour
 */
public class ClientListener extends UnicastRemoteObject implements IClientListener{
   /* IClientView clientView;
    public ClientListener(IClientView clientView)throws RemoteException{
        this.clientView=clientView;
    }*/
    private chatCui gui;
    public ClientListener(chatCui gui) throws RemoteException {
        this.gui=gui;
    }
    
    
    @Override
    public void changeModel(IChatModel chatModel) {
        switch(chatModel.getServiceNumber()){
            case ModelType.USER_FOUND:
                User u = chatModel.getUser();
                break;
            case ModelType.RECIEVE_MESSAGE:
                for (int i = 0; i < gui.room.rooms_tabs.getTabCount(); i++) {
                    if(((conversation)gui.room.rooms_tabs.getTabComponentAt(i)).getRoomId()==chatModel.getRoom().getRoomId()){
                        ((conversation)gui.room.rooms_tabs.getTabComponentAt(i)).text2.append("\n"+chatModel.getMsg().getSender()+" : "+chatModel.getMsg().getTxt());
                        break;
                    }
                    
                }
                break;
            case ModelType.RECIEVE_ROOM_ID:
                conversation conv=new conversation();
                conv.setRoomId(chatModel.getRoom().getRoomId());
                conv.setRoom(chatModel.getRoom());
                gui.room.rooms_tabs.insertTab(chatModel.getRoom().getName(),null , conv, null,gui.room.rooms_tabs.getTabCount() );
                break;
        
        }
        
    }

    @Override
    public void isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
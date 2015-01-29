/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import Server.IChatModel;
import java.awt.CardLayout;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import model.User;
import pkg1.chatCui;

import pkg1.conversation;

import pkg1.messenger;

import view.ModelType;

/**
 *
 * @author Radwa Manssour
 */
public class ClientListener extends UnicastRemoteObject implements IClientListener {
    /* IClientView clientView;
     public ClientListener(IClientView clientView)throws RemoteException{
     this.clientView=clientView;
     }*/

    chatCui gui;

    public ClientListener(chatCui gui) throws RemoteException {
        this.gui = gui;
    }

    @Override
    public void changeModel(IChatModel chatModel) {
        switch (chatModel.getServiceNumber()) {
            case ModelType.USER_FOUND:
                User user = chatModel.getUser();
                System.out.println(user.getUserEmail() + "clientlistener");
                gui.setUser(user);
                CardLayout card = (CardLayout) gui.parentPanel.getLayout();
                gui.mess = new messenger(gui.room, gui, user);
                gui.parentPanel.add("messenger", gui.mess);
                card.show(gui.parentPanel, "messenger");
                break;
            case ModelType.SERROR_MESSAGE:
                String errorMessage = chatModel.getJoptionPaneMassage();
                JOptionPane.showMessageDialog(null, new String(errorMessage));
                break;

            case ModelType.RECIEVE_MESSAGE:
                boolean foundId = false;
                for (int i = 0; i < gui.room.rooms_tabs.getTabCount(); i++) {
                    if (((conversation) gui.room.rooms_tabs.getTabComponentAt(i)).getRoomId() == chatModel.getRoom().getRoomId()) {
                        ((conversation) gui.room.rooms_tabs.getTabComponentAt(i)).text2.append("\n" + chatModel.getMsg().getSender() + " : " + chatModel.getMsg().getTxt());
                        foundId = true;
                        break;
                    }

                }
                if (!foundId) {
                    conversation conv = new conversation();
                    conv.setRoomId(chatModel.getRoom().getRoomId());
                    conv.setRoom(chatModel.getRoom());
                    gui.room.rooms_tabs.insertTab(chatModel.getRoom().getName(), null, conv, null, gui.room.rooms_tabs.getTabCount());

                }
                break;
            case ModelType.RECIEVE_ROOM_ID:
                conversation conv = new conversation();
                conv.setRoomId(chatModel.getRoom().getRoomId());
                conv.setRoom(chatModel.getRoom());
                gui.room.rooms_tabs.insertTab(chatModel.getRoom().getName(), null, conv, null, gui.room.rooms_tabs.getTabCount());
                break;

        }

    }

    @Override
    public void isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

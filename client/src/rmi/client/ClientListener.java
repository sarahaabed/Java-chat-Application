/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import Server.IChatModel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.TokenType;
import model.Contact;
import model.Room;
import model.User;
import pkg1.ContactPanel;
import pkg1.chatCui;
import pkg1.conversation;
import pkg1.messenger;
import pkg1.request;
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
                gui.mess = new messenger(gui, user);
                gui.parentPanel.add("messenger", gui.mess);
                card.show(gui.parentPanel, "messenger");
                break;

            case ModelType.SERROR_MESSAGE:
                String errorMessage = chatModel.getJoptionPaneMassage();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        JOptionPane.showMessageDialog(null, new String(errorMessage));
                    }
                });

                break;

            case ModelType.RECIEVE_MESSAGE:
                //boolean foundId = false;
                
                    
                     if(!gui.rooms.containsKey(chatModel.getRoom().getRoomId())){
                         conversation conv=new conversation(gui);
                         conv.setRoom(chatModel.getRoom());
                         conv.setVisible(true);
                         gui.rooms.put(chatModel.getRoom().getRoomId(), conv);
                         gui.rooms.get(chatModel.getRoom().getRoomId()).text2.append("\n" + chatModel.getMsg().getSender() + " : " + chatModel.getMsg().getTxt());
                     }else{
                         gui.rooms.get(chatModel.getRoom().getRoomId()).text2.append("\n" + chatModel.getMsg().getSender() + " : " + chatModel.getMsg().getTxt());
                         System.out.println("room id  :  "+chatModel.getRoom().getRoomId());
                   

                }

                break;
            case ModelType.RECIEVE_ROOM_ID:
                conversation conv = new conversation(gui);
                conv.setRoomId(chatModel.getRoom().getRoomId());
                conv.setRoom(chatModel.getRoom());
                //gui.room.rooms_tabs.insertTab(chatModel.getRoom().getName(), null, conv, null, gui.room.rooms_tabs.getTabCount());
                break;

            case ModelType.RECICVE_FILE:
                String msg = chatModel.getJoptionPaneMassage();
                byte[] bs = chatModel.getBs();
                System.out.println("recive file ");
                //  JOptionPane.showMessageDialog(null,new String(msg));
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 JFileChooser f = new JFileChooser();
                if (f.showSaveDialog(gui) == JFileChooser.APPROVE_OPTION) {
                    String path = f.getSelectedFile().getPath();
                try {
                    FileOutputStream fos=new FileOutputStream(path);
                    fos.write(bs);
                    fos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            }
        });
               
            break;
                
                
            case ModelType.REQUEST_SEND:
                gui.setUser(chatModel.getUser());
                CardLayout card1 = (CardLayout) gui.parentPanel.getLayout();
                gui.mess = new messenger( gui, chatModel.getUser());
                gui.parentPanel.add("messenger", gui.mess);
                card1.show(gui.parentPanel, "messenger");
                break;
                
            case ModelType.REQUEST_NOT_SEND:
                String errorMsg=chatModel.getJoptionPaneMassage();
                java.awt.EventQueue.invokeLater( new Runnable() {

            @Override
            public void run() {
               JOptionPane.showMessageDialog(null,new String(errorMsg));
            }
        });
                gui.setUser(chatModel.getUser());
                CardLayout card2 = (CardLayout) gui.parentPanel.getLayout();
                gui.mess = new messenger( gui, chatModel.getUser());
                gui.parentPanel.add("messenger", gui.mess);
                card2.show(gui.parentPanel, "messenger");
                break;
            case ModelType.ACCEPT_FRIEND:
                gui.user.userRequests.remove(chatModel.getContact().getEmail());
                gui.user.userContacts.add(chatModel.getContact());
                gui.mess.requestsPanel.removeAll();
                gui.mess.requestsPanel.repaint();
                Set<String> entrySet = gui.user.userRequests.keySet();
                Iterator<String> it = entrySet.iterator();

                while (it.hasNext()) {
                    System.out.println("requesttttttt");
                    String i = it.next();
                    Contact c = gui.user.userRequests.get(i);
                    request r = new request();
                    ImageIcon ico = new ImageIcon(c.getPhoto());
                    r.img.setIcon(ico);
                    r.name.setText(c.getName());
                    gui.mess.requestsPanel.add(r);
                    r.accept.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gui.cih.acceptContact(gui.user, c);


                            /*ContactPanel c1=new ContactPanel(window,c);
                             ImageIcon i =new ImageIcon(c.getPhoto());
                             c1.img.setIcon(i);
                             c1.name.setText(c.getName());
                             c1.status.setText(c.getStatus());
                             c1.state.setIcon(stateColor[c.getState()]);
                             contactsPanel.add(c1);*/
                        }
                    });
                }

                gui.mess.requestsPanel.repaint();
                ContactPanel cont = new ContactPanel(gui, chatModel.getContact());

                gui.mess.contactsPanel.add(cont);

                //cont.img.setIcon(new ImageIcon(chatModel.getContact().getPhoto()));
                cont.name.setText(chatModel.getContact().getName());
                cont.status.setText(chatModel.getContact().getStatus());
                break;
            case ModelType.REJECTED:
                gui.user.userRequests.remove(chatModel.getContact().getEmail());
                gui.user.userContacts.add(chatModel.getContact());
                gui.mess.requestsPanel.removeAll();
                gui.mess.requestsPanel.repaint();
                Set<String> entrySet1 = gui.user.userRequests.keySet();
                Iterator<String> it1 = entrySet1.iterator();

                while (it1.hasNext()) {
                    System.out.println("requesttttttt");
                    String i = it1.next();
                    Contact c = gui.user.userRequests.get(i);
                    request r = new request();
                    ImageIcon ico = new ImageIcon(c.getPhoto());
                    r.img.setIcon(ico);
                    r.name.setText(c.getName());
                    gui.mess.requestsPanel.add(r);
                    r.accept.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gui.cih.acceptContact(gui.user, c);
                        }
                    });
                }

                gui.mess.requestsPanel.repaint();

        }
        
        

    }

    @Override

    public void isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

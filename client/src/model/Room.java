/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author bishoy
 */
public class Room implements IRoom{
    private ImageIcon img;
    private String roomId;
    public Vector<Contact> contactVector=new Vector<Contact>();
    public Vector<Message> messageVector=new Vector<Message>();
    private String name;

    public Room() {
    }
    
    
    public Room(String roomId){
        this.roomId = roomId;
    }
    @Override
    public String getRoomId(){
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public ImageIcon getImg() {
        return img;
    }

    @Override
    public String getName() {
        return name;
    }
    
}

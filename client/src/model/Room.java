/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author bishoy
 */
public class Room {
    private int roomId;
    public Vector<Contact> contactVector;
    public Vector<Message> messageVector;
    public Room(int roomId){
        this.roomId = roomId;
    }
    int getRoomId(){
        return roomId;
    }
}

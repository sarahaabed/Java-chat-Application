/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author bishoy
 */
public class Message implements Serializable{
    private int roomId;
    private Timestamp timestamp;
    private Contact sender;
    private String txt;
    
    public Message(int room,Timestamp timestamp,Contact sender,String txt){
        this.timestamp =timestamp;
        this.sender = sender;
        this.txt = txt;
    }
    public int getRoomId(){
        return roomId;
    }
    public Timestamp getTimestamp(){
        return timestamp;
    }
    public Contact getSender(){
        return sender;
    }
    public String getTxt(){
        return txt;
    }
    
}

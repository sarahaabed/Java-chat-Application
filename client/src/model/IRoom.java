/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author bishoy
 */
public interface IRoom extends Serializable{
    

    public void setRoomId(int roomId);
    public int getRoomId();
}

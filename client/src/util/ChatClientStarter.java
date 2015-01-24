/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Server.IChatModel;
import Server.chatModel;

/**
 *
 * @author bishoy
 */
public class ChatClientStarter {
    public ChatClientStarter(){
        IChatModel chModel;
        chModel = new chatModel();
    }
    public static void main(){
        new ChatClientStarter();
    }
}

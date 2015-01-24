/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import Server.IChatModel;
import java.rmi.Remote;

/**
 *
 * @author Radwa Manssour
 */
public interface IClientView{
    public void changeModel(IChatModel chatModel);
    
}
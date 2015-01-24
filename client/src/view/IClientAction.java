/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import java.rmi.Remote;
import model.Contact;
import model.Message;
import model.User;

/**
 *
 * @author Radwa Manssour
 */
public interface IClientAction extends Serializable {

    public User getUser();

    public int getServiceNum();

    public Message getMessage();

    public Contact getContact();



}

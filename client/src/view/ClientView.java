/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import Server.IChatModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import pkg1.SignInForm;
import pkg1.SignUpForm;
import pkg1.chatCui;

/**
 *
 * @author Radwa Manssour
 */
public class ClientView implements IClientView{
    private SignInForm sin;
    private SignUpForm sup;
    private chatCui c;

    public ClientView(chatCui c) {
        this.c = c;
    }

    public SignInForm getSin() {
        return sin;
    }

    public void setSin(SignInForm sin) {
        this.sin = sin;
    }

    public SignUpForm getSup() {
        return sup;
    }

    public void setSup(SignUpForm sup) {
        this.sup = sup;
    }

    public chatCui getC() {
        return c;
    }

    public void setC(chatCui c) {
        this.c = c;
    }

    public ClientView(){
        
    }
    @Override
    public void changeModel(IChatModel chatModel) {
    
    }
    public void disposeAll(){
        if(sin != null) sin.dispose();
        if(sup != null) sup.dispose();
        if(c != null) c.dispose();
    }
    
}
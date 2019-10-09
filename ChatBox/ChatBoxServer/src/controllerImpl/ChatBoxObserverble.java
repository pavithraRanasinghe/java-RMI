/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.ChatBoxObserver;

/**
 *
 * @author PAVITHRA
 */
public class ChatBoxObserverble{

    private ArrayList<ChatBoxObserver> observer = new ArrayList<>();
    private String text;

    public void add(ChatBoxObserver chatBoxObserver) throws RemoteException {
        observer.add(chatBoxObserver);
    }

    public void remove(ChatBoxObserver chatBoxObserver) throws RemoteException {
        observer.remove(chatBoxObserver);
    }

    public void setText(String text) throws RemoteException {
        if (this.text != text) {
            this.text = text;
            notifyChat();
        }
    }
    private void notifyChat() throws RemoteException{
        for (ChatBoxObserver observer : observer) {
            new Thread(){
                public void run(){
                    try {
                        observer.update(text);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ChatBoxObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}

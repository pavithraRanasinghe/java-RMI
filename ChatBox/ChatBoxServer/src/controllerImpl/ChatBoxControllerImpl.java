/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.ChatBoxController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.ChatBoxObserver;

/**
 *
 * @author PAVITHRA
 */
public class ChatBoxControllerImpl extends UnicastRemoteObject implements ChatBoxController{
    private ChatBoxObserverble chatBoxObserverble = new ChatBoxObserverble();
    public ChatBoxControllerImpl()throws RemoteException{
        
    }
    @Override
    public void add(ChatBoxObserver chatBoxObserver) throws RemoteException {
        chatBoxObserverble.add(chatBoxObserver);
    }

    @Override
    public void remove(ChatBoxObserver chatBoxObserver) throws RemoteException {
        chatBoxObserverble.remove(chatBoxObserver);
    }

    @Override
    public void setText(String text) throws RemoteException {
        chatBoxObserverble.setText(text);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.ChatBoxObserver;
import observer.ClientView;

/**
 *
 * @author PAVITHRA
 */
public class ChatBoxObserverImpl extends UnicastRemoteObject implements ChatBoxObserver{

    private ClientView clientView;
    
    
    public ChatBoxObserverImpl(ClientView clientView)throws RemoteException{
        this.clientView = clientView;
    }
    @Override
    public void update(String text) throws RemoteException {
        clientView.setText(text);
    }
    
}

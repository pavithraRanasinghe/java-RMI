/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import observer.ChatBoxObserver;

/**
 *
 * @author PAVITHRA
 */
public interface ChatBoxController extends Remote{
    public void add(ChatBoxObserver chatBoxObserver)throws RemoteException;
    public void remove(ChatBoxObserver chatBoxObserver)throws RemoteException;
    public void setText(String text)throws RemoteException;
}

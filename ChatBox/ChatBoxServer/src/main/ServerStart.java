/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllerImpl.ChatBoxControllerImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author PAVITHRA
 */
public class ServerStart {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(5050);
        System.out.println("Server Start...");
        registry.rebind("ChatBoxServer", new ChatBoxControllerImpl());
    }    
}

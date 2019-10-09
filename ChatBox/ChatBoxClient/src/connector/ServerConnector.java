/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import controller.ChatBoxController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author PAVITHRA
 */
public class ServerConnector {
    private static ServerConnector serverConnector;
    private ChatBoxController chatBoxController;
    
    public ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        chatBoxController = (ChatBoxController) Naming.lookup("rmi://localhost:5050/ChatBoxServer");
    }
    
    public static ServerConnector getInstance() throws NotBoundException, MalformedURLException, RemoteException{
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }
    public ChatBoxController getChatBoxController(){
        return chatBoxController;
    }
}

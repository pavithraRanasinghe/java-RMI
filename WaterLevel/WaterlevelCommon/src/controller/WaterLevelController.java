/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PAVITHRA
 */
public interface WaterLevelController extends Remote{
    public void addWaterLevel(WaterLevelObserver WaterLevelObserver)throws RemoteException;
    
    public void notifyWaterLevel() throws RemoteException;
    
    public void setWaterLevel(int waterLevel) throws RemoteException; 
}

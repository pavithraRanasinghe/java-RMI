/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.WaterLevelController;
import controller.WaterLevelObserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author PAVITHRA
 */
public class WaterLevelControllerImpl extends UnicastRemoteObject implements WaterLevelController{

    public WaterLevelControllerImpl()throws RemoteException{
    
    }
    
    private ArrayList<WaterLevelObserver> arrayList = new ArrayList<>();
    private int waterLevel;

    @Override
    public void addWaterLevel(WaterLevelObserver WaterLevelObserver) throws RemoteException{
        System.out.println("Controller add");
        arrayList.add(WaterLevelObserver);
    }

    @Override
    public void notifyWaterLevel() throws RemoteException{
        for (WaterLevelObserver waterLevelObserver : arrayList) {
            System.out.println("Controller Update : "+waterLevel);
            waterLevelObserver.update(waterLevel);
        }
    }

    @Override
    public void setWaterLevel(int waterLevel) throws RemoteException{
        System.out.println("Controller set : "+waterLevel);
        if (this.waterLevel != waterLevel) {
            this.waterLevel = waterLevel;
            notifyWaterLevel();
            System.out.println("Set Over");
        }
    }
}

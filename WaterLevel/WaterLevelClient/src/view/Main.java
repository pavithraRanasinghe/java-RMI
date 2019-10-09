/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.WaterLevelController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PAVITHRA
 */
public class Main {

    public static void main(String[] args){
        try {
            WaterLevelController waterLevelController = (WaterLevelController) Naming.lookup("rmi://localhost:5050/WaterLevelServer");
            waterLevelController.addWaterLevel(new AlarmWindow());
            waterLevelController.addWaterLevel(new DisplayWindow());
            new WaterTank().setVisible(true);
        } catch (NotBoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

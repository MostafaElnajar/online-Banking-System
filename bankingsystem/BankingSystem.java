/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import gui.UserRegistration;
import gui.login;
import gui.makeAccount;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.swing.JFrame;

/**
 *
 * @author Top
 */
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidKeySpecException, NoSuchAlgorithmException, ClassNotFoundException {

        
        
        
        
        login logIn = new login();
        logIn.setVisible(true);
        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
                
    }
    
}

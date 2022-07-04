/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bankingsystem.userDataBase;
import javax.swing.JFrame;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Top
 */
public class Guim {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args)  throws FileNotFoundException, IOException, ClassNotFoundException, InvalidKeySpecException, NoSuchAlgorithmException {
        // TODO code application logic here
        
        
        
        login lnn = new login();
        lnn.setVisible(true);
        lnn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        UserRegistration ur = new UserRegistration();
        ur.setVisible(true);
        ur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        
        makeAccount mk = new makeAccount();
        mk.setVisible(true);
        mk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        ArrayList<makeAccount> ac = new ArrayList<makeAccount>();
        mk.userID= mk.jtxt1.getText();
        mk.brsnchloc=mk.jtxt3.getText();
        ac.add(mk);
        try{
        ObjectOutputStream myfile = new ObjectOutputStream(new FileOutputStream ("C:\\Users\\Top\\Documents\\NetBeansProjects\\banksystem\\myfile.txt"));
        myfile.writeObject(mk);
        myfile.close();
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("C:\\Users\\Top\\Documents\\NetBeansProjects\\task\\myfile.txt"));
        Iterator <makeAccount> listx = ac.iterator();
        while(listx.hasNext())
        {          
          System.out.println(listx.next()+mk.userID);
        }
        }
        catch (IOException ex) {
        JOptionPane.showMessageDialog(null,"the file was not saved");
        }
    }
  
    
}




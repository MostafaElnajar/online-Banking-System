/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bankingsystem.userDataBase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Top
 */
public class UserRegistration extends JFrame implements Serializable {
    JLabel userName = new JLabel ("Username: ");
    JTextField tuserName = new JTextField();
    JLabel Bdate = new JLabel("Birth date: ");
    JTextField tBdate = new JTextField();
    JLabel Mobile = new JLabel("Mobile no.: ");
    JTextField tMobile = new JTextField();
    JLabel Mail = new JLabel("E-mail: ");
    JTextField tMail = new JTextField();
    JLabel Pass = new JLabel("Password: ");
    JPasswordField Tpass = new JPasswordField();
    JRadioButton male = new JRadioButton("Male",true);
    JRadioButton female = new JRadioButton("Female",false);
    JButton Sign = new JButton("Sign up");
    
    public UserRegistration()
    {
    setTitle ("User registration");
    setSize(800,550);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ButtonGroup gender = new ButtonGroup();
         gender.add(male);
         gender.add(female);
    Container cp=getContentPane();
    cp.setLayout(null);
    userName.setBounds(20, 20, 150, 80);
    cp.add(userName);
    tuserName.setBounds(userName.getBounds().width+30, 40, 100, 40);
    cp.add(tuserName);
    Bdate.setBounds(20, 160, 150, 80);
    cp.add(Bdate);
    tBdate.setBounds(userName.getBounds().width +30, 180, 100, 40);
    cp.add(tBdate);
    Mobile.setBounds(20, 230, 150, 80);
    cp.add(Mobile);
    tMobile.setBounds(userName.getBounds().width+30, 250, 100, 40);
    cp.add(tMobile);
    Mail.setBounds(20, 300, 150, 80);
    cp.add(Mail);
    tMail.setBounds(userName.getBounds().width+30, 320, 100, 40);
    cp.add(tMail);
    Pass.setBounds(20, 370, 150, 80);
    cp.add(Pass);
    Tpass.setBounds(userName.getBounds().width+30, 390, 100, 40);
    cp.add(Tpass);
    male.setBounds(320, 190, 100, 110);
    cp.add(male);
    female.setBounds(420, 190, 100, 110);
    cp.add(female);
    Sign.setBounds(550, 200, 150, 80);
    cp.add(Sign);
    Sign.addActionListener(new UserRegistration.UserAction());
    }
    private class UserAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            FileInputStream FIS = null;
            ObjectInputStream OIS = null;
            ObjectOutputStream OOS = null;
            FileOutputStream FOS = null;
            try {
                FIS = new FileInputStream("database.txt");
                OIS = new ObjectInputStream(FIS);
                userDataBase newDB = (userDataBase) OIS.readObject();
                
                String username = tuserName.getText();
                String pass = String.valueOf(Tpass.getPassword());
                
                newDB.register(username, pass);
                
                
                 FOS = new FileOutputStream("database.txt");
                 OOS = new ObjectOutputStream(FOS);
                 OOS.writeObject(newDB);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | InvalidKeySpecException | NoSuchAlgorithmException ex) {
                Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    FIS.close();
                    OOS.close();
                    JOptionPane.showMessageDialog(null, "You have successfully signed up!");
                    dispose();
                    login lnn = new login();
                    lnn.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    
    }
    }
}

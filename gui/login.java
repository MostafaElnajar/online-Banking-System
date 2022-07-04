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
public class login extends JFrame {

    JLabel userName = new JLabel("User name: ");
    JTextField tuserName = new JTextField();
    JLabel pass = new JLabel("Password: ");
    JPasswordField tpass = new JPasswordField();
    JButton login = new JButton("Log in");
    JButton SignUp = new JButton("Sign up");

    public login() {
        setTitle("Sign in");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(null);
        userName.setBounds(20, 20, 150, 80);
        cp.add(userName);
        tuserName.setBounds(userName.getBounds().width + 30, 40, 100, 40);
        cp.add(tuserName);
        pass.setBounds(20, 90, 150, 80);
        cp.add(pass);
        tpass.setBounds(userName.getBounds().width + 30, 110, 100, 40);
        cp.add(tpass);
        login.setBounds(70, 180, 100, 40);
        cp.add(login);
        SignUp.setBounds(userName.getBounds().width + 30, 180, 100, 40);
        cp.add(SignUp);
        SignUp.addActionListener(new login.SignUpAction());
        login.addActionListener(new login.loginAction());
    }

    private class loginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            FileInputStream FIS = null;
            try {
                String username = tuserName.getText();
                String password = tpass.getText();
                FIS = new FileInputStream("database.txt");
                ObjectInputStream OIS = new ObjectInputStream(FIS);
                userDataBase DB = (userDataBase) OIS.readObject();

                if (DB.authenticateUser(username, password) == true) {
                    //Go to login form
                    JOptionPane.showMessageDialog(null, "Welcome back!");
                    makeAccount mk = new makeAccount();
                    login ln = new login();
                    ln.setVisible(false);
                    mk.setVisible(true);

                } else //User doesn't exist or wrong password
                {
                    JOptionPane.showMessageDialog(null, "No user exists with this username/password combination. Try signing up");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | InvalidKeySpecException | NoSuchAlgorithmException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    FIS.close();
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
    private class SignUpAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "You will be redirected to the registration page");
            UserRegistration ur = new UserRegistration();
            ur.setVisible(true);
            login ln = new login();
            ln.setVisible(false);
        }
        
    }
}

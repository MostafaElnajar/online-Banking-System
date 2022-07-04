/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bankingsystem.userDataBase;
import clientgui.ClientGUI;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Top
 */
public class makeAccount extends JFrame implements Serializable {

    JLabel jlb1 = new JLabel("Username: ");
    JTextField jtxt1 = new JTextField();
    JLabel jlb2 = new JLabel("User password: ");
    JPasswordField jp = new JPasswordField();
    JLabel jlb3 = new JLabel("Branch location: ");
    JTextField jtxt3 = new JTextField();
    JComboBox jcb1 = new JComboBox();
    JFrame ac = new JFrame();
    JButton bt = new JButton("OK!");
    FileWriter fw;
    String userID = jtxt1.getText();
    String brsnchloc = jtxt3.getText();
    // Account ac = new Account();

    public makeAccount() {

        setTitle("Account control panel");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jcb1.addItem("Check balance");
        jcb1.addItem("Create an account");
        jcb1.addItem("Delete an account");
        jcb1.addItem("Actions");
        jcb1.addItem("Request card");
        jcb1.addItem("Request support");
        jcb1.addActionListener(new accountAction());
        Container cp = getContentPane();
        cp.setLayout(null);
        jlb1.setBounds(20, 20, 150, 80);
        cp.add(jlb1);
        jtxt1.setBounds(jlb1.getBounds().width + 30, 40, 100, 40);
        cp.add(jtxt1);
        jlb2.setBounds(20, 90, 150, 80);
        cp.add(jlb2);
        jp.setBounds(jlb1.getBounds().width + 30, 110, 100, 40);
        cp.add(jp);
        jlb3.setBounds(20, 160, 150, 80);
        cp.add(jlb3);
        jtxt3.setBounds(jlb1.getBounds().width + 30, 180, 100, 40);
        cp.add(jtxt3);
        jcb1.setBounds(350, 110, 160, 110);
        cp.add(jcb1);
        bt.setBounds(550, 260, 150, 80);
        cp.add(bt);
        bt.addActionListener(new accountAction());
    }

    private class accountAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String str1 = jtxt1.getText();
            String str3 = jtxt3.getText();
            if (jtxt1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "This field cannot be left blank");

            }
            if (jcb1.getSelectedItem().equals("Check balance")) {
                JOptionPane.showMessageDialog(null, "Your current balance: " + 0);
                // JOptionPane.showMessageDialog(null, "your current banance is"+ac.balance);
            }
            if (jcb1.getSelectedItem().equals("Create an account")) {
                str1 = jtxt1.getText();
                str3 = jtxt3.getText();

            }
            if (jcb1.getSelectedItem().equals("Delete an account")) {

                FileInputStream FIS = null;
                FileOutputStream FOS = null;
                try {

                    FIS = new FileInputStream("database.txt");
                    ObjectInputStream OIS = new ObjectInputStream(FIS);
                    userDataBase DB = (userDataBase) OIS.readObject();

                    DB.removeUser(jtxt1.getText());

                    FOS = new FileOutputStream("database.txt");
                    ObjectOutputStream OOS = new ObjectOutputStream(FOS);

                    OOS.writeObject(DB);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(makeAccount.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(makeAccount.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        FIS.close();
                        FOS.close();

                        JOptionPane.showMessageDialog(null, "Your account was successfuly deleted");
                        dispose();

                        login logIn = new login();
                        logIn.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(makeAccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

                if (jcb1.getSelectedItem().equals("Actions")) {
                    addActions aa = new addActions();
                    dispose();
                }
                if (jcb1.getSelectedItem().equals("Request card")) {
                    cardAdd aa = new cardAdd();
                    dispose();
                }
                if (jcb1.getSelectedItem().equals("Request support")) {
                    ClientGUI CG = new ClientGUI("localhost", 1500);
                    dispose();
                    CG.setVisible(true);
                }

            }
        }
    }


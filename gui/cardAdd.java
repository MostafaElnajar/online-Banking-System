/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Top
 */
public class cardAdd extends JFrame {
     JLabel jlb1 = new JLabel ("enter user id");
     JTextField jtxt1 = new JTextField();
     JLabel jlb2 = new JLabel("enter account id");
     JTextField jtxt2 = new JTextField();
     JLabel jlb3 = new JLabel ("enter the amount");
     JTextField jtxt3 = new JTextField();
     JButton jb1 = new JButton("my card balance");
     JRadioButton jrb1 = new JRadioButton("Debit card",true);
    JRadioButton jrb2 = new JRadioButton("Credit card",false);
    JComboBox jcb1 = new JComboBox();
    
     public cardAdd(){
         
        setVisible(true);
        setTitle ("the card actions");
        setSize(850,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jcb1.addItem("request card");
        jcb1.addItem("stop card");
         jcb1.addItem("add money");
         jcb1.addItem("take money");
        jcb1.addActionListener(new cardAdd.cardActions());
        
        ButtonGroup gb = new ButtonGroup();
         gb.add(jrb1);
         gb.add(jrb2);
     
         
        Container cp=getContentPane();
        cp.setLayout(null);
        jlb1.setBounds(20, 20, 150, 80);
        cp.add(jlb1);
        jtxt1.setBounds(jlb1.getBounds().width+30, 40, 100, 40);
        cp.add(jtxt1);
        jlb2.setBounds(20, 90, 150, 80);
        cp.add(jlb2);
        jtxt2.setBounds(jlb1.getBounds().width+30, 110, 100, 40);
        cp.add(jtxt2);
        jlb3.setBounds(20, 190, 100, 40);
        cp.add(jlb3);
        jtxt3.setBounds(jlb1.getBounds().width+30, 190, 100, 40);
        cp.add(jtxt3);
        jb1.setBounds(200  , 280, 150, 80);
        cp.add(jb1);
        jrb1.setBounds(350, 110, 100, 90);
        cp.add(jrb1);
        jrb2.setBounds(450, 110, 100, 90);
        cp.add(jrb2);
         jcb1.setBounds(600, 110, 120, 90);
        cp.add(jcb1);
        jb1.addActionListener(new cardAdd.cardActions());
       
     }
     
     private class cardActions implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
             
                JOptionPane.showMessageDialog(null, "your card balance is money");           
            
            
             if (jcb1.getSelectedItem().equals("request card")){
                 if(jrb1.isSelected()){
                JOptionPane.showMessageDialog(null, "A Debit card has been requested");           
            }
                 else{
                     JOptionPane.showMessageDialog(null, "A Credit card has been requested"); 
                 }
             }
            if (jcb1.getSelectedItem().equals("stop card")){
            if(jrb1.isSelected()){
                JOptionPane.showMessageDialog(null, "A Debit card has been stoped");           
            }
                 else{
                     JOptionPane.showMessageDialog(null, "A Credit card has been stoped"); 
                 }
            }
             if (jcb1.getSelectedItem().equals("add money")){
            if(jrb1.isSelected()){
                JOptionPane.showMessageDialog(null, "A money was added to the Debit card");           
            }
                 else{
                     JOptionPane.showMessageDialog(null, "A money was added ro the Credit card"); 
                 }
            }
              if (jcb1.getSelectedItem().equals("take money")){
             if(jrb1.isSelected()){
                JOptionPane.showMessageDialog(null, "A money was taken from the Debit card");           
            }
                 else{
                     JOptionPane.showMessageDialog(null, "A money was taken from the Debit card"); 
                 }
            }
              
              
        }
     }
}

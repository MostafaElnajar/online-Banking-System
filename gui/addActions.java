/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import bankingsystem.Payment;
import bankingsystem.Cheque;

/**
 *
 * @author Top
 */
public class addActions extends JFrame {

    public String from;
    public String to;
    public float value;

    JLabel jlb1 = new JLabel("from");
    JTextField jtxt1 = new JTextField(10);
    JLabel jlb2 = new JLabel("to");
    JTextField jtxt2 = new JTextField(10);
    JLabel jlb3 = new JLabel("value");
    JTextField jtxt3 = new JTextField(15);
    JComboBox jcb1 = new JComboBox();
    JRadioButton jrb1 = new JRadioButton("issue", true);
    JRadioButton jrb2 = new JRadioButton("cancel", false);

    public addActions() {

        setTitle("the account action");
        setSize(750, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(null);

        jcb1.addItem("paymant");
        jcb1.addItem("cheque");
        jcb1.addActionListener(new addActions.actions());

        ButtonGroup gb = new ButtonGroup();
        gb.add(jrb1);
        gb.add(jrb2);

        jlb1.setBounds(20, 20, 150, 80);
        cp.add(jlb1);
        jtxt1.setBounds(jlb1.getBounds().width + 30, 40, 100, 40);
        cp.add(jtxt1);
        jlb2.setBounds(20, 90, 150, 80);
        cp.add(jlb2);
        jtxt2.setBounds(jlb1.getBounds().width + 30, 110, 100, 40);
        cp.add(jtxt2);
        jlb3.setBounds(20, 180, 100, 40);
        cp.add(jlb3);
        jtxt3.setBounds(jlb1.getBounds().width + 30, 180, 100, 40);
        cp.add(jtxt3);
        jcb1.setBounds(550, 110, 120, 90);
        cp.add(jcb1);
        jrb1.setBounds(350, 110, 60, 90);
        cp.add(jrb1);
        jrb2.setBounds(410, 110, 70, 90);
        cp.add(jrb2);

    }

    private class actions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //action listener for combo box
            if (jcb1.getSelectedItem().equals("paymant")) {
                if (jrb1.isSelected()) {
                    Payment pay = new Payment();
                    pay.status = true;
                  //  pay.sendPayment(jtxt1.getText(), jtxt2.getText(), jtxt3.getText())=true;
                    JOptionPane.showMessageDialog(null, "the payment was interrupted");
                } else {
                    Payment pay = new Payment();
                    pay.cancelPayment(pay);
                    JOptionPane.showMessageDialog(null, "the payment was cancelled ");
                }
            }
            if (jcb1.getSelectedItem().equals("cheque")) {
                if (jrb1.isSelected()) {
                    Cheque cheq = new Cheque();
                    cheq.status = true;
                    //cheq.issueCheque(jtxt1.getText(), jtxt2.getText(), jtxt3.getText());
                    JOptionPane.showMessageDialog(null, "the cheque was interurpted");
                } else {
                    Cheque cheq = new Cheque();
                    cheq.CancelCheque(cheq);
                    //interrupted by a cause of a wrong operation
                    JOptionPane.showMessageDialog(null, "the cheque was cancelled ");
                }
            }
        }
    }
}

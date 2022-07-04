/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 *
 * @author Top
 */
public class Transaction {
    private String from;

    private String to;

    private int value;

    public Transaction() {
        value = 0;
        from = "";
        to = "";
    }

    public void makeTrasaction() {
    }

    public void CancelTransction() {
    }

    public boolean verifyTransction() {
        return true;
    }
}

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
public class Payment {
    Account from;
    Account to;
    private float value;
    public boolean status;
    
    public void sendPayment(Account from, Account to, float amount){
        from.balance -= amount;
        
        to.balance += amount;
        
        this.status = true;
    }
    
    public void cancelPayment(Payment O){
        O.status = false;
    }
    
    public boolean verifyPayment(Payment O){
        return O.status == true;
    }     
}

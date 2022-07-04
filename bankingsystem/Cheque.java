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
public class Cheque {
    
    public float value;
    Account from;
    Account to;
    public boolean status = false;
    
    public void issueCheque(Account from, Account to, float amount){
        from.balance -= amount;
        
        to.casheable = amount;
    }
    
    public void CancelCheque(Cheque O){
        O.status = false;
    }
    
    public boolean checkStatus(Cheque O){
        return O.status == true;
    }
}

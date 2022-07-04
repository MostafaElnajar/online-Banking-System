/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import static java.lang.Thread.sleep;

/**
 *
 * @author Top
 */
public class Deposit {
    Account ac;
    int amount;
     public Deposit(Account acc,int ammount)
    {
    this.ac=acc;
    this.amount=ammount;
    }
     public void run ()
    {
        try {
        for (int i=0;i<10;i++)
        {
            this.ac.deposit2(i,amount);
            
                sleep(10);
            }
        }
        catch (InterruptedException ex) {
                System.out.println(ex);
            }
        } 
}

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
public class Account {

    public double balance;

    private String userID;

    private long account_num;

    public float casheable;
    
     private int ammount;
    
    private final User person;
    Account(User u){
        person = u;
        ammount=0;
    }
    
    Account(User u, double balance_a, long account_n)
    {
        person = u;
        balance = balance_a;
        account_num = account_n;
    }
    
    public void deposit(double amount_deposited)
    {
        balance += amount_deposited;
    }
    
    public boolean withdraw(double amount_withdrawn)
    {  
        if(amount_withdrawn > balance){
            return false;
        }else{
        
        balance -= amount_withdrawn; 
            return true;
        }
    }
    //withdraw with threads
    public synchronized void withdraw2(int i,int value) throws InterruptedException
    {
     System.out.println("Sa7b " + value);
        int newbalance=ammount - value;
        //Thread.sleep(10);
        //ammount-=value;
        ammount=newbalance;
        System.out.println("3amlit sa7b rakm "+i+" Ma3ak " + ammount);
    }
    //deposit with threads
     public synchronized void deposit2(int i,int value) throws InterruptedException
    {
        System.out.println("Eida3 " + value);
        int newbalance=ammount + value;
        Thread.sleep(10);
        //ammount-=value;
        ammount=newbalance;
        System.out.println("3amalit eida3 rakm "+i+" Ma3ak " + ammount);
    }
    
    public double get_balance()
    {
        return balance;
        
    }
}

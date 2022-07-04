/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.io.Serializable;

/**
 *
 * @author Top
 */
public class User implements Serializable{
 
    public String username;

    public String password;

    private int userID;

    private String gender;

    private String birthdate;

    private long mobileNumber;

    private String mail;
    
    public String userSalt;

    public User() {
        username = "";
        gender = "";
        password = "";
        userID = 0;
        birthdate = "";
        mobileNumber = 0;
        mail = "";
    }

    
    public void setUserID(){
        userID++;
    }
    
    public boolean validate_user(String user, String pass){
        return (pass == null ? password == null : pass.equals(password));
    }
   
}

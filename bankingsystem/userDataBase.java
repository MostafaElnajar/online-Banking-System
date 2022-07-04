/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Top
 */
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import bankingsystem.User;
/**
 *
 * @author wessa
 */
public class userDataBase implements Serializable {
    
    public final Map<String, User> userDatabase;

    public userDataBase() {
        this.userDatabase = new HashMap<>();
    }
    
    public void register(String userName, String password) throws InvalidKeySpecException, NoSuchAlgorithmException{
        String salt = getSalt();
        String hashedPassword = EncryptPassword(password, salt);
        
        User U = new User();
        U.password = hashedPassword;
        U.username = userName;
        U.userSalt = salt;
        saveInfo(U);
    }
    
    public String EncryptPassword(String password, String salt) throws InvalidKeySpecException, NoSuchAlgorithmException{
        
        String instance = "PBKDF2WithHmacSHA1";
        int keyLength = 160;
        int iterations = 10000;
        
        byte[] saltBytes = Base64.getDecoder().decode(salt);
        
        KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, keyLength);
        
        SecretKeyFactory factory = SecretKeyFactory.getInstance(instance);
        
        byte[] encodedBytes = factory.generateSecret(spec).getEncoded();
        
        return Base64.getEncoder().encodeToString(encodedBytes);
    
    }
    
    public boolean authenticateUser(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {

        User U = userDatabase.get(username);

        if (U == null) {
            return false;
        } else {
            String salt = U.userSalt;
            String hashedPassword = EncryptPassword(password, salt);
            return hashedPassword.equals(U.password);

        }

    }
    
    public String getSalt() throws NoSuchAlgorithmException{
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[4];
        random.nextBytes(salt);
        
        return Base64.getEncoder().encodeToString(salt);
         
    }
    
    private void saveInfo(User U){
        userDatabase.put(U.username, U);
    }
    
    public void removeUser(String username){
        userDatabase.remove(username);
    }
    
}

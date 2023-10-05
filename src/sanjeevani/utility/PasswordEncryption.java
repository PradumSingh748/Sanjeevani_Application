/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.utility;

import java.util.Base64;

/**
 *
 * @author PRADUM SINGH
 */
public class PasswordEncryption {
    
    public static String getEncryptedPassword(String pwd) {
        Base64.Encoder en = Base64.getEncoder();
        
        byte arr[] = pwd.getBytes();
        String encpwd = en.encodeToString(arr);
        System.out.println(encpwd);
        return encpwd;
    }

}
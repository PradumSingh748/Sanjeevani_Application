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
public class PasswordDecryption {
    public static String DecryptPassword(String encodedpassword){
        System.out.println(encodedpassword);
        
         byte[] decodedBytes = Base64.getDecoder().decode(encodedpassword);
       
        String pass=new String(decodedBytes);
        System.out.println("passwordsknkasnkan"+pass);
        return pass;
    }
//    public static void main(String[] args) {
//        String password="WTIxR2RGbFhORDA9";
//        String newp=PasswordDecryption.DecryptPassword(password);
//        System.out.println(newp);
//    }
    
}
//
//public class PasswordDecryption{
//    public static void main(String[] args) {
//        String encodedPassword = "c29tZXNo"; // This is the Base64-encoded password
//
//        // Decode the password
//        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
//        String decodedPassword = new String(decodedBytes);
//
//        // Print the decoded password
//        System.out.println(decodedPassword);
//    }
//}
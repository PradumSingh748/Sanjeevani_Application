/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PRADUM SINGH
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-V9E579V:1521/xe","javaproject","sanjeevani");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Problem in DBConnection DB"+e.getMessage(), "Error in DBConnetion!", JOptionPane.ERROR_MESSAGE);
            System.out.println("error in connection to db:"+e.getMessage());
            e.printStackTrace();
            
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Class cannot be loaded!","Error!",JOptionPane.ERROR_MESSAGE);
            System.out.println("error"+e.getMessage());
            e.printStackTrace();
    }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
            try{
                conn.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Database Error"+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    
    
    
    
   
}
//class MyConnection {
//    public static void main(String[] args) {
//        System.out.println("Connection to be opened!");
//        DBConnection.getConnection();
//        System.out.println("Opened!");
//    }
//}
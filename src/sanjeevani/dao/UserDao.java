/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.User;
import sanjeevani.pojo.UserPojo;

/**
 *
 * @author PRADUM SINGH
 */
public class UserDao {
    public static String validateUser(User user)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select user_name from users where login_id=? and password=? and user_type=?"); 
        ps.setString(1, user.getLoginId());
        ps.setString(2, user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        String name=null;
        if(rs.next()){
            
            name=rs.getString("user_name");     // we can also use getString in this way 
        }
    
        return name;
    }
    
    public static void updateName(String currName,String newName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set user_name=? where user_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }
    public static boolean addUser(UserPojo user)throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values (?,?,?,?)");
        ps.setString(1,user.getLoginId());
        ps.setString(2,user.getUserName());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getUserType());
        return ps.executeUpdate()==1;
    }
    public static void deleteUserByUserName(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
//        String username=null;
//        PreparedStatement ps=conn.prepareStatement("select user_name from users where user_name=?");
//        ps.setString(1,name);
//        ResultSet rs=ps.executeQuery();
//        if(rs.next()){
//            username=rs.getString(1);
//        }
//        if(username!=null){
        PreparedStatement ps=conn.prepareStatement("delete from users where user_name=?");
        ps.setString(1, name);
        ps.executeUpdate();
//        }
    }
    public static UserPojo getUserDetails(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        
        PreparedStatement ps=conn.prepareStatement("select * from users where user_name=?");
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
//        System.out.println(rs.next());
        UserPojo user=new UserPojo();
        while(rs.next()){
            System.out.println("looop");
            user.setLoginId(rs.getString("login_id"));
            user.setPassword(rs.getString("password"));
            System.out.println("usr password form dao"+rs.getString("password"));
            user.setUserType(rs.getString("user_type"));
        }
        System.out.println("in dao");
        System.out.println(user.getLoginId());
        System.out.println(user.getPassword());
        System.out.println("from dao"+user.getLoginId());
        return user;
    }
    public static boolean updateUser(UserPojo updateUser,String oldName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set login_id=?, user_name=?, password=? where user_name=?");
        ps.setString(1,updateUser.getLoginId());
        ps.setString(2,updateUser.getUserName());
        ps.setString(3,updateUser.getPassword());
        ps.setString(4,oldName);
        return ps.executeUpdate()==1;
    }
   
}

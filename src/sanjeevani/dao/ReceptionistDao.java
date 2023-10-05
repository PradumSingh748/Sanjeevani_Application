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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.ReceptionistPojo;

/**
 *
 * @author PRADUM SINGH
 */
public class ReceptionistDao {
    public static void updateName(String currName,String newName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update receptionists set receptionist_name=? where receptionist_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }
    
    
       public static String getNewRecId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(receptionist_id) from receptionists");
        rs.next();
        System.out.println("rs.next():"+rs.getString(1));
        int recId=101;
        String id=rs.getString(1);
        System.out.println("\n\n\n\nString Id is:"+id);
        if(id!=null){
            String n=id.substring(3);
            recId=Integer.parseInt(n)+1;
        }
        return "REC"+recId;            
    }
    
       
        public static boolean addReceptionist (ReceptionistPojo rec)throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into receptionists values (?,?,?)");
        ps.setString(1,rec.getId());
        ps.setString(2,rec.getName());
        ps.setString(3,rec.getGender());
        
        return ps.executeUpdate()==1;
    }
        
        
        public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
            Connection conn=DBConnection.getConnection();
            Statement s=conn.createStatement();
            
            ResultSet rs=s.executeQuery("select * from receptionists");
            List<ReceptionistPojo> recList=new ArrayList<>();
            while(rs.next()){
                ReceptionistPojo rec=new ReceptionistPojo();
                rec.setId(rs.getString(1));
                rec.setName(rs.getString(2));
                rec.setGender(rs.getString(3));
                recList.add(rec);
        }
            return recList;
        }
        
        
        public static List<String> getAllReceptionistId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select receptionist_id from receptionists");
        
        List<String> recList=new ArrayList<>();
        while(rs.next()){
            recList.add(rs.getString(1));
        }
        return recList;
    }
        
        public static ReceptionistPojo getReceptionistDetails(String id)throws SQLException{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from receptionists where receptionist_id=?");
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            ReceptionistPojo rec=new ReceptionistPojo();  
            rec.setId(rs.getString(1));
            rec.setName(rs.getString(2));
            rec.setGender(rs.getString(3));
            return rec;
        }
        
        
        
        public static boolean deleteReceptionistById(String recId)throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select receptionist_name from receptionists where receptionist_id=?");
        ps.setString(1, recId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String recname=rs.getString(1);
        UserDao.deleteUserByUserName(recname);
        ps=conn.prepareStatement("delete from receptionists where receptionist_id=?");
        ps.setString(1, recId);
        return ps.executeUpdate()==1;
       
    }
        public static boolean deleteReceptionistByName(String recpName)throws SQLException{
           Connection conn  = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Delete from receptionists where receptionist_name =?");
        ps.setString(1, recpName);
        return ps.executeUpdate()==1;
    }
        
        public static boolean updateReceptionist(ReceptionistPojo rec)throws SQLException{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update receptionists set receptionist_name=?, gender=? where receptionist_id=?");
            ps.setString(1,rec.getName());
            ps.setString(2, rec.getGender());
            ps.setString(3,rec.getId());
            return ps.executeUpdate()==1;
        }
}

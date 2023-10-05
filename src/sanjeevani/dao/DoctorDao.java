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
import sanjeevani.pojo.DoctorPojo;

/**
 *
 * @author PRADUM SINGH
 */
public class DoctorDao {
    public static void updateName(String currName,String newName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update doctors set doctor_name=? where doctor_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }
    
    public static String getNewDocId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(doctor_id) from doctors");
        rs.next();
        System.out.println("rs.next():"+rs.getString(1));
        int docId=101;
        String id=rs.getString(1);
        System.out.println("\n\n\n\nString Id is:"+id);
        if(id!=null){
            String n=id.substring(3);
            docId=Integer.parseInt(n)+1;
        }
        return "DOC"+docId;            
    }
    public static boolean addDoctor(DoctorPojo doc)throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into doctors values (?,?,?,?,?,?,?)");
        ps.setString(1,doc.getDoctorID());
        ps.setString(2,doc.getDoctorName());
        ps.setString(3,doc.getEmailID());
        ps.setString(4,doc.getContactNo());
        ps.setString(5,doc.getQualification());
        ps.setString(6,doc.getGender());
        ps.setString(7,doc.getSpecialist());
        return ps.executeUpdate()==1;
    }
    public static List<String> getAllDocId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select doctor_id from doctors");
        
        List<String> docList=new ArrayList<>();
        while(rs.next()){
            docList.add(rs.getString(1));
        }
        return docList;
    }
    public static boolean deleteDoctorById(String docId)throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select doctor_name from doctors where doctor_id=?");
        ps.setString(1, docId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String docname=rs.getString(1);
        UserDao.deleteUserByUserName(docname);
        ps=conn.prepareStatement("delete from doctors where doctor_id=?");
        ps.setString(1, docId);
        return ps.executeUpdate()==1;
       
    }
    
    public static void deleteDoctorByName(String docName)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Delete from doctors where doctor_name=?");
        ps.setString(1,docName);
        ps.executeUpdate();
    }
    
    
    public static List<DoctorPojo> getAllDocDetails()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from doctors order by doctor_id");
        List<DoctorPojo> docList=new ArrayList<>();
        while(rs.next()){
            DoctorPojo doc=new DoctorPojo();
            doc.setDoctorID(rs.getString("doctor_id"));
            doc.setDoctorName(rs.getString("doctor_name"));
            doc.setContactNo(rs.getString("contact_no"));
            doc.setEmailID(rs.getString("email_id"));
                doc.setQualification(rs.getString("qualification"));
            doc.setSpecialist(rs.getString("specialist"));
            doc.setGender(rs.getString("gender"));
            docList.add(doc);
        }
        return docList;
    }
    public static String getDoctorNameByDoctorId(String id)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select doctor_name from doctors where doctor_id=?");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    
    
}

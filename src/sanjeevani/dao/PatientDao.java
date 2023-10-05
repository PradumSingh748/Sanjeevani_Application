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
import sanjeevani.pojo.PatientPojo;

/**
 *
 * @author PRADUM SINGH
 */
public class PatientDao {
        public static String getNewPatientId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(patient_id) from patients");
        rs.next();
        System.out.println("rs.next():"+rs.getString(1));
        int patientId=101;
        String id=rs.getString(1);
        System.out.println("\n\n\n\nString Id is:"+id);
        if(id!=null){
            String n=id.substring(3);
            patientId=Integer.parseInt(n)+1;
        }
        return "PAT"+patientId;            
    }
        
        
        public static boolean addPatient(PatientPojo pat)throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into patients values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,pat.getPatient_id());
        ps.setString(2,pat.getFirstName());
        ps.setString(3,pat.getLastName());
        ps.setInt(4,pat.getAge());
        ps.setString(5,pat.getGender());
        ps.setString(6,pat.getmStatus());
        ps.setString(7,pat.getAddress());
        ps.setString(8,pat.getCity());
        ps.setString(9,pat.getPhoneNo());
        ps.setDate(10,pat.getpDate());
        ps.setInt(11,pat.getOtp());
        ps.setString(12,pat.getOpd());
        ps.setString(13,pat.getDoctorId());
        ps.setString(14,pat.getStatus());
        ps.setString(15,pat.getEmail_id());
        
        
        return ps.executeUpdate()==1;
    }
        
        
        
        
        public static List<PatientPojo> getAllPatientDetails()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from patients order by patient_id");
        List<PatientPojo> patList=new ArrayList<>();
        while(rs.next()){
            PatientPojo pat=new PatientPojo();
            pat.setPatient_id(rs.getString("patient_id"));
            pat.setFirstName(rs.getString("first_name"));
            pat.setLastName(rs.getString("last_name"));
            pat.setAge(rs.getInt("age"));
            pat.setGender(rs.getString("gender"));
            pat.setmStatus(rs.getString("m_status"));
            pat.setAddress(rs.getString("address"));
            pat.setCity(rs.getString("city"));
            pat.setPhoneNo(rs.getString("mobile_no"));
            pat.setpDate(rs.getDate("p_date"));
            pat.setOtp(rs.getInt("otp"));
            pat.setOpd(rs.getString("opd"));
            pat.setDoctorId(rs.getString("doctor_id"));
            pat.setStatus(rs.getString("status"));
            pat.setEmail_id(rs.getString("email_id"));
            patList.add(pat);
        }
        return patList;
    }    
        
        
        public static PatientPojo getPatientDetailsById(String id) throws SQLException{
            Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from patients where patient_id=?");
            ps.setString(1,id);
            PatientPojo p=new PatientPojo();
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                p.setPatient_id(id);
                p.setPhoneNo(rs.getString("mobile_no"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                p.setAge(rs.getInt("age"));
                p.setCity(rs.getString("city"));
                p.setAddress(rs.getString("address"));
                p.setGender(rs.getString("gender"));
                p.setOpd(rs.getString("opd"));
                p.setmStatus(rs.getString("m_status"));
                p.setpDate(rs.getDate("p_date"));
                p.setDoctorId(rs.getString("doctor_id"));
                p.setStatus(rs.getString("status"));
                
        }
            return p;
        }
        public static List<String> getAllPatientId()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select patient_id from patients");
    List<String> patIdList=new ArrayList<>();
    while(rs.next()){
        patIdList.add(rs.getString(1));
    }
    return patIdList;
    }
        
       public static boolean updatePatient(PatientPojo pat)throws SQLException{
           Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement("update patients set first_name=?, last_name=?, age=?, gender=?, m_status=?, address=?, city=?, mobile_no=?, p_date=?, opd=?, doctor_id=? where patient_id=?");
           ps.setString(1,pat.getFirstName());
           ps.setString(2,pat.getLastName());
           ps.setInt(3, pat.getAge());
           ps.setString(4,pat.getGender());
           ps.setString(5,pat.getmStatus());
           ps.setString(6,pat.getAddress());
           ps.setString(7,pat.getCity());
           ps.setString(8,pat.getPhoneNo());
           ps.setDate(9,pat.getpDate());
           ps.setString(10,pat.getOpd());
           ps.setString(11,pat.getDoctorId());
           ps.setString(12,pat.getPatient_id());
           return ps.executeUpdate()==1;
       }
       
       
       
       public static boolean deletePatientById(String PatId)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("delete from patients where patient_id=?"); 
     ps.setString(1, PatId);
     return ps.executeUpdate()==1;
    }
       public static boolean updateStatus(String id,String status)throws SQLException{
           Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement("update patients set status=? where patient_id=?");
           ps.setString(1,status);
           ps.setString(2,id);
           return ps.executeUpdate()==1;
       }
}

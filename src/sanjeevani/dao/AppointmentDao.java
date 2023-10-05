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
import sanjeevani.pojo.AppointmentPojo;
import sanjeevani.pojo.PatientPojo;

/**
 *
 * @author PRADUM SINGH
 */
public class AppointmentDao {
    public static boolean addAppointment(AppointmentPojo app)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into appointments values (?,?,?,?,?,?,?,?)");
        ps.setString(1, app.getPatient_id());
        ps.setString(2,app.getPatient_name());
        ps.setString(3,app.getStatus());
        ps.setString(4, app.getOpd());
        ps.setString(5,app.getDate_time());
        ps.setString(6,app.getDoctor_name());
        ps.setString(7,app.getMobile_no());
        ps.setString(8,app.getEmail_id());
//        System.out.println("Appointment added"+ps.executeUpdate());

        return ps.executeUpdate()==1;
        
    }
    
    public static boolean updateStatus(AppointmentPojo app)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update appointments set status=?,date_time=? where patient_id=?" );
     ps.setString(1, app.getStatus());
     ps.setString(2, app.getDate_time());
     ps.setString(3,app.getPatient_id());
     return ps.executeUpdate()==1;
     
     
 }
    
    public static List<AppointmentPojo> getAllAppointmentByDoctorName(String docName)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from appointments where doctor_name=? and status='REQUEST' order by patient_id");
        ps.setString(1, docName);
        ResultSet rs=ps.executeQuery();
        List<AppointmentPojo> appList=new ArrayList<>();
        while(rs.next()){
            AppointmentPojo app=new AppointmentPojo();
            app.setPatient_id(rs.getString("patient_id"));
            app.setPatient_name(rs.getString("patient_name"));
            app.setOpd(rs.getString("opd"));
            app.setDate_time(rs.getString("date_time"));
            app.setStatus(rs.getString("status"));
            app.setMobile_no(rs.getString("mobile_no"));
            app.setDoctor_name(rs.getString("doctor_name"));
            app.setEmail_id(rs.getString("email_id"));
            appList.add(app);
        }
        return appList;
    }
    
    public static boolean updatePatientDetails(AppointmentPojo app)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update appointments set patient_name=?, opd=?, Date_time=?,doctor_name=?, mobile_no=? where patient_id=?");
        ps.setString(1,app.getPatient_name());
        ps.setString(2,app.getOpd());
        ps.setString(3,app.getDate_time());
        ps.setString(4,app.getDoctor_name());
        ps.setString(5,app.getMobile_no());
        ps.setString(6,app.getPatient_id());
        return ps.executeUpdate()==1;
    }
   
    
    public static List<AppointmentPojo> getConfirmedAppointments(String doctorName) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from appointments where status = 'CONFIRM' and doctor_name=? order by patient_id");
        ps.setString(1, doctorName);
        ResultSet rs=ps.executeQuery(); 
        List<AppointmentPojo>appList=new ArrayList<>();
        while(rs.next()){
            AppointmentPojo app = new AppointmentPojo();
            app.setPatient_id(rs.getString("patient_id"));
            app.setPatient_name(rs.getString("patient_name"));
            app.setOpd(rs.getString("opd"));
            app.setDate_time(rs.getString("date_time"));
            appList.add(app);
        } 
        return appList;
    }
    public static boolean deleteAppointentById(String id)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from appointments where patient_id=?");
        ps.setString(1, id);
        return ps.executeUpdate()==1;
    }
}

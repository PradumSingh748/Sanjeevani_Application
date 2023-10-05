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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.EmpPojo;

/**
 *
 * @author PRADUM SINGH
 */
public class EmpDao {
    public static String getNextEmpId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(emp_id) from employees");
        rs.next();
        String str=rs.getString(1);
        int empId=101;
        if(str!=null){
              String id=str.substring(1);
              empId=Integer.parseInt(id);
              empId++;
        }
        String newId="E"+empId;
        return newId;
        
    }
    public static boolean addEmployee(EmpPojo emp)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values (?,?,?,?)");
        ps.setString(1,emp.getEmpId());
        ps.setString(2,emp.getEmpName());
        ps.setString(3,emp.getEmpDepartment());
        ps.setDouble(4,emp.getEmpSal());
        int res=ps.executeUpdate();
        return res==1;
    }
    public static List<EmpPojo> getAllEmployees()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by emp_id");
        List<EmpPojo> elist=new ArrayList<>();
        while(rs.next()){
            EmpPojo emp=new EmpPojo();
            emp.setEmpId(rs.getString(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpDepartment(rs.getString(3));
            emp.setEmpSal(Double.parseDouble(rs.getString(4)));
            elist.add(emp);
        }
        return elist;
    }
    public static List<String> getAllEmpId()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        List<String> empid=new ArrayList<>();
        ResultSet rs=st.executeQuery("select emp_id from employees");
        while(rs.next()){
            empid.add(rs.getString(1));
        }
        return empid;
    }
    public static EmpPojo getEmployeeDetails(String empid)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employees where emp_id=?");
        ps.setString(1, empid);
        ResultSet rs=ps.executeQuery();
        
        rs.next();
        EmpPojo emp=new EmpPojo();
        emp.setEmpId(empid);
        emp.setEmpName(rs.getString(2));
        emp.setEmpDepartment(rs.getString(3));
        emp.setEmpSal(Double.parseDouble(rs.getString(4)));
        return emp;
    }
    
    
     public static boolean updateEmployee(EmpPojo emp)throws SQLException{
        updateName(emp);
        
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set emp_name=?,emp_salary=? where emp_id=?");
        ps.setString(1, emp.getEmpName());
        ps.setDouble(2, emp.getEmpSal());
        ps.setString(3, emp.getEmpId());
        return ps.executeUpdate()==1;
            
    }
    public static void updateName(EmpPojo emp)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select emp_name from employees where emp_id=?");
        ps.setString(1, emp.getEmpId());
        ResultSet rs=ps.executeQuery();
        rs.next();
        String currName=rs.getString(1);
        String newName=emp.getEmpName();
        
        UserDao.updateName(currName,newName);
        if(emp.getEmpDepartment().equalsIgnoreCase("Receptionist")){
            ReceptionistDao.updateName(currName,newName);
        }
        else if(emp.getEmpDepartment().equalsIgnoreCase("Doctor")){
            DoctorDao.updateName(currName,newName);
            
        }
    }
    public static boolean deleteEmployee(String empId)throws SQLException{
          Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("Select emp_name ,emp_department from employees where emp_id = ?");
         ps.setString(1,empId );
         ResultSet rs = ps.executeQuery();
         rs.next();
         String empName = rs.getString(1);
         String empDept = rs.getString(2);
         
          System.out.println(empName + " " + empDept);
         if(empDept.equalsIgnoreCase("DOCTOR"))
             DoctorDao.deleteDoctorByName(empName);
         else if(empDept.equalsIgnoreCase("RECEPTIONIST"))
             ReceptionistDao.deleteReceptionistByName(empName);
          
         
             UserDao.deleteUserByUserName(empName);
        
         ps = conn.prepareStatement("Delete from employees where emp_id=?");
         ps.setString(1, empId);
         return ps.executeUpdate()==1;
        
      }
    
    
    
//    public static boolean deleteEmployee(String empid)throws SQLException{
//        Connection conn=DBConnection.getConnection();
//        PreparedStatement ps=conn.prepareStatement("delete from employees where emp_id=?");
//        ps.setString(1,empid);
//        return ps.executeUpdate()==1;
//        
//    }
   public static Map<String,String> getUnRegDocIdList()throws SQLException{
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select emp_id, emp_name from employees where emp_department='DOCTOR' and emp_name not in (select user_name from users where user_type='doctor')order by emp_id");
       
       Map<String,String> unRegDocList=new HashMap<>();
       while(rs.next()){
       String docId=rs.getString(1);
         
       String docName=rs.getString(2);
           System.out.println("id:"+docId+"name:"+docName);
       unRegDocList.put(docId,docName);
       }
       return unRegDocList;
   }
   
   
    public static Map<String,String> getUnRegRecIdList()throws SQLException{
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select emp_id, emp_name from employees where emp_department='RECEPTIONIST' and emp_name not in (select user_name from users where user_type='receptionist')order by emp_id");
       
       Map<String,String> unRegRecList=new HashMap<>();
       while(rs.next()){
       String recId=rs.getString(1);
         
       String recName=rs.getString(2);
           System.out.println("id:"+recId+"name:"+recName);
       unRegRecList.put(recId,recName);
       }
       return unRegRecList;
   }
    public static boolean updateEmployeeName(String old_name,String new_name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set emp_name=? where emp_name=?");
        ps.setString(1, new_name);
        ps.setString(2, old_name);
        return ps.executeUpdate()==1;
    }
}


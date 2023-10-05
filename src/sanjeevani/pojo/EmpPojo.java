/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.pojo;

/**
 *
 * @author PRADUM SINGH
 */
public class EmpPojo {
    public EmpPojo(){
        
    }

    public EmpPojo(String empId,String empName,String empDepartment,Double empSal){
        this.empId=empId;
        this.empName=empName;
        this.empDepartment=empDepartment;
        this.empSal=empSal;
        
    }
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }
    private String empId;
    private String empName;
    private String empDepartment;
    private Double empSal;
}

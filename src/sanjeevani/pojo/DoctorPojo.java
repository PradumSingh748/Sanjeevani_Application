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
public class DoctorPojo {

    public DoctorPojo(){
        
    }
    
    public DoctorPojo(String doctorID, String doctorName, String emailID, String contactNo, String qualification, String gender, String specialist) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.emailID = emailID;
        this.contactNo = contactNo;
        this.qualification = qualification;
        this.gender = gender;
        this.specialist = specialist;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    private String doctorID;
    private String doctorName;
    private String emailID;
    private String contactNo;
    private String qualification;
    private String gender;
    private String specialist;
}

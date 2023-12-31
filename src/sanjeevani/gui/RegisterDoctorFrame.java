/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.gui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sanjeevani.dao.DoctorDao;
import sanjeevani.dao.EmpDao;
import sanjeevani.dao.UserDao;
import sanjeevani.pojo.DoctorPojo;
import sanjeevani.pojo.UserPojo;
import sanjeevani.utility.PasswordEncryption;
import sanjeevani.utility.SetDateTime;

/**
 *
 * @author pradu
 */
public class RegisterDoctorFrame extends javax.swing.JFrame {

    /**
     * Creates new form RegisterDoctorFrame
     */
    private Map<String,String> unRegDocList;
    private String empId,empName,logId,contactNo,qualification,specialist,email,password1,password2;
    public RegisterDoctorFrame() {
        initComponents();
        setTitle("Add Doctor Frame");
        setLocationRelativeTo(null);       
        loadDoctorDetails();
        getNewDocId();
        SetDateTime.setTime(lblDateTime);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcEmployeeId = new javax.swing.JComboBox<>();
        jcGender = new javax.swing.JComboBox<>();
        txtDoctorName = new javax.swing.JTextField();
        txtLoginId = new javax.swing.JTextField();
        txtDoctorId = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        txtSpecialist = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRetypePassword = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblDateTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel15.setText("SANJEEVANI APPLICATION");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 510, -1));

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 560, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevani/icons/HomePageBG1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1017, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Employee Id");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Doctor Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Login ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Password");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Retype Password");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Gender");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Doctor ID");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Contact No");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Qualification");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Specialist");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("E-Mail ID");

        jcEmployeeId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmployeeIdActionPerformed(evt);
            }
        });

        jcGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHER" }));

        txtDoctorName.setEditable(false);
        txtDoctorName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDoctorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorNameActionPerformed(evt);
            }
        });

        txtLoginId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLoginId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginIdActionPerformed(evt);
            }
        });

        txtDoctorId.setEditable(false);
        txtDoctorId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtContactNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtQualification.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSpecialist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel14.setText("ADD DOCTOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(142, 142, 142)
                        .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLoginId)
                                    .addComponent(txtDoctorName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcEmployeeId, javax.swing.GroupLayout.Alignment.TRAILING, 0, 122, Short.MAX_VALUE))
                                .addGap(83, 83, 83))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRetypePassword)
                                    .addComponent(txtPassword))
                                .addGap(91, 91, 91)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel13))
                                .addComponent(jLabel12))
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQualification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addComponent(txtDoctorId, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtSpecialist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSpecialist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 418, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevani/icons/images (2).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 427, -1, 238));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 671, 217, 36));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 725, 87, 36));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Logout");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 725, 100, 36));

        lblDateTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(lblDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 772, 180, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmployeeIdActionPerformed
        // TODO add your handling code here:
        if(jcEmployeeId.getSelectedIndex()==-1){
            return;
        }
        empId=jcEmployeeId.getSelectedItem().toString();
        empName=unRegDocList.get(empId);
        txtDoctorName.setText(empName);

    }//GEN-LAST:event_jcEmployeeIdActionPerformed

    private void txtDoctorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorNameActionPerformed

    private void txtLoginIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(validateInputs()==false){
            JOptionPane.showMessageDialog(null,"Please enter all data");
            return;
        }
        String passwordCheck=matchPassword();
        if(passwordCheck!=null){
            JOptionPane.showMessageDialog(null,passwordCheck);
            return;
        }
        if(isContactNoValid()==false){
            JOptionPane.showMessageDialog(null,"Invalid Mobile NO");
            return;
        }
        try{
            DoctorPojo doc=new DoctorPojo();
            doc.setDoctorID(txtDoctorId.getText());
            doc.setDoctorName(empName);
            doc.setContactNo(contactNo);
            doc.setEmailID(email);
            doc.setGender(jcGender.getSelectedItem().toString().trim());
            doc.setQualification(qualification);
            doc.setSpecialist(specialist);
            UserPojo user=new UserPojo();
            user.setLoginId(logId);
            user.setUserName(empName);
            user.setUserType("doctor");
            String encPassword=PasswordEncryption.getEncryptedPassword(password1);
            user.setPassword(encPassword);
            boolean result1=DoctorDao.addDoctor(doc);
            boolean result2=UserDao.addUser(user);
            if(result1==true && result2==true){
                JOptionPane.showMessageDialog(null,"Doctor Added successfully!");
                getNewDocId();
                clearAll();
                return;
            }
            JOptionPane.showMessageDialog(null,"Doctor Cannot be Added!");

            return;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error in DB"+e.getMessage());
            e.printStackTrace();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFrame option=new ManageDoctorFrame();
        option.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterDoctorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jcEmployeeId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDoctorId;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JPasswordField txtRetypePassword;
    private javax.swing.JTextField txtSpecialist;
    // End of variables declaration//GEN-END:variables

     private void loadDoctorDetails() {
        unRegDocList=new HashMap<>();
        try{
        unRegDocList=EmpDao.getUnRegDocIdList();
        Set<String> empIdSet=unRegDocList.keySet();
        for(String id:empIdSet){
            System.out.println(id);
            jcEmployeeId.addItem(id);
        }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error in DB"+e.getMessage());
            e.printStackTrace();
        }
    }

    private void getNewDocId() {
        try{
        String docId=DoctorDao.getNewDocId();
        txtDoctorId.setText(docId);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error in DB"+e.getMessage());
            e.printStackTrace();
        }
    }
    private boolean validateInputs(){
        logId=txtLoginId.getText().trim();
        char[]pwd1=txtPassword.getPassword();
        char[]pwd2=txtRetypePassword.getPassword();
        contactNo=txtContactNo.getText().trim();
        qualification=txtQualification.getText().trim();
        specialist=txtSpecialist.getText().trim();
        email=txtEmail.getText().trim();
       if(logId.isEmpty()||pwd1.length==0||pwd2.length==0||contactNo.isEmpty()||qualification.isEmpty()||specialist.isEmpty()||email.isEmpty()){
           return false;
        }
       password1=new String(pwd1);
       password2=new String(pwd2);
       return true;
    }

    private String matchPassword() {
        password1=password1.trim();
        password2=password2.trim();
        if(password1.length()<3||password2.length()<3){
            return "Password must be atleast three character long";
        }
        if(!password1.equals(password2)){
            return "Passwords do not match";
        }
        return null;
    }
    private boolean isContactNoValid(){
        if(contactNo.length()!=10){
            return false;
        }
//        for(int i=0;i<contactNo.length();i++){
//            if(Character.isDigit(contactNo.charAt(i))==false){
//                return false;
//            }
//        }
        char[]mob=contactNo.toCharArray();
        for(char ch:mob){
            if(Character.isDigit(ch)==false)
                return false;
        }
        return true;
    }

    private void clearAll() {
       txtDoctorName.setText("");
        txtLoginId.setText("");
        txtContactNo.setText("");
        txtSpecialist.setText("");
        txtQualification.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtRetypePassword.setText("");
        this.unRegDocList.remove(this.empId);
        this.jcEmployeeId.removeItem(empId);
        if(unRegDocList.size()==0){
            JOptionPane.showMessageDialog(null, "All doctors are registered!");
            JFrame option=new ManageDoctorFrame();
            option.setVisible(true);
            this.dispose();
        }
    }
}

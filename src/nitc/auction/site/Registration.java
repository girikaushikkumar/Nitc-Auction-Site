/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nitc.auction.site;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author girik
 */
public class Registration extends javax.swing.JFrame {
    
    public Registration() {
        initComponents();
    }
   
   
    public static boolean is_Valid_Password(String password) {

        if(password.length() < 8)
            return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 1 && numCount >= 1);
    }
    
    
     public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catadd1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        sans = new javax.swing.JTextField();
        fName = new javax.swing.JTextField();
        AddUser = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        userName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        stype = new javax.swing.JComboBox<>();
        phone = new javax.swing.JTextField();
        confirmpassword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        catadd1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        catadd1.setForeground(new java.awt.Color(255, 0, 0));
        catadd1.setText("X");
        catadd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catadd1MouseClicked(evt);
            }
        });
        getContentPane().add(catadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registration");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Last Name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Phone");

        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        sans.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sansActionPerformed(evt);
            }
        });

        fName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameActionPerformed(evt);
            }
        });

        AddUser.setBackground(new java.awt.Color(0, 0, 0));
        AddUser.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        AddUser.setForeground(new java.awt.Color(255, 255, 255));
        AddUser.setText("Submit");
        AddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddUserMouseClicked(evt);
            }
        });
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(0, 0, 0));
        clear.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        password.setMinimumSize(new java.awt.Dimension(64, 26));
        password.setOpaque(true);
        password.setPreferredSize(new java.awt.Dimension(64, 26));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        userName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("UserName");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("First Name");

        lName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("Already have an account?");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        stype.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        stype.setForeground(new java.awt.Color(255, 255, 255));
        stype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Favorite colour", "Your Nick Name", "Favourite Actor", "Favourite Cricket Player" }));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        confirmpassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpasswordActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Confirm Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(sans, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fName, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(confirmpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(AddUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                .addComponent(clear)
                                .addGap(58, 58, 58))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1)))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sans, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(AddUser))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/new background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void sansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sansActionPerformed

    private void fNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameActionPerformed

    private void AddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUserMouseClicked
        String sql = "insert into userdb values(?,?,?,?,?,?,?,?)";
        if(userName.getText().isEmpty() || fName.getText().isEmpty() || lName.getText().isEmpty()|| password.getText().isEmpty() || stype.getSelectedItem().toString().isEmpty() || sans.getText().isEmpty())
        JOptionPane.showMessageDialog(this,"Missing Information");
        else{
            try {
                Connection conn=DBConnection.connectDB();
                PreparedStatement st=(PreparedStatement)conn.prepareStatement(sql);
                boolean b = new Student().CheckUserName(userName.getText());
                if(b)
                   JOptionPane.showMessageDialog(this, "UserName already exist");
                else
                { 
                    if(userName.getText().length() >= 6)
                        st.setString(1, userName.getText());
                    else
                        JOptionPane.showMessageDialog(this, "User Name should minimum 6 character");
                }
                
                st.setString(2, fName.getText());
                st.setString(3,lName.getText());
                
                String mail=email.getText();
                if(mail.matches(".*@nitc.ac.in.*"))
                    st.setString(4, email.getText());
                else
                    JOptionPane.showMessageDialog(this, "Enter official College Mail ID");
                
                
                if(phone.getText().length() == 10)
                    st.setString(5, phone.getText());
                else
                {
                    JOptionPane.showMessageDialog(this, "Enter a valid mobile number");
                }
                
                if(is_Valid_Password(password.getText())){
                    if(confirmpassword.getText().equals(password.getText()))
                         st.setString(6, password.getText());
                    else
                        JOptionPane.showMessageDialog(this, "Password Mismatched");
                }
                else{
                    JOptionPane.showMessageDialog(this, "A password must be length of 8 and combination of character and numbers");
                }
                
                
               
                st.setString(7, stype.getSelectedItem().toString());
                st.setString(8, sans.getText());
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, "User Added Successfully");
                new Login().setVisible(true);
                this.dispose();
                conn.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddUserMouseClicked

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddUserActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        email.setText("");
        password.setText("");
        fName.setText("");
        lName.setText("");
        sans.setText("");
        userName.setText("");
    }//GEN-LAST:event_clearMouseClicked

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void lNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void catadd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catadd1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_catadd1MouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        
    }//GEN-LAST:event_passwordActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void confirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUser;
    private javax.swing.JButton catadd1;
    private javax.swing.JButton clear;
    private javax.swing.JTextField confirmpassword;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lName;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField sans;
    private javax.swing.JComboBox<String> stype;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}

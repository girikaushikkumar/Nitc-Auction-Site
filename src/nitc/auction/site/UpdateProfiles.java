/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nitc.auction.site;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class UpdateProfiles extends javax.swing.JFrame {

    String userId="";
    String type = "";
    public UpdateProfiles() {
        initComponents();
        SellerDashboard sd = new SellerDashboard();
        sd.suserId = userId;
        
    }
    
    public void ShowProfile()
    {
        String query = "select * from userdb where UserName='"+userId+"'";
         try {
            
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement(query);

            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
            if(rss.next())
            {
                fname.setText(rss.getString("firstName"));
                lname.setText(rss.getString("lastName"));
                email.setText(rss.getString("email"));
                phone.setText(rss.getString("phone"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catadd1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        phone = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/previous.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone");

        update.setBackground(new java.awt.Color(0, 0, 0));
        update.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UPDATE PROFILE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(174, 174, 174))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(lname)
                    .addComponent(fname))
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(update)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(50, 50, 50)
                .addComponent(update)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 550, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/new background.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       
            SellerDashboard sd = new SellerDashboard();
            sd.suserId = userId;
            sd.setVisible(true);
            this.dispose();
        
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void catadd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catadd1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_catadd1MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
           try {
            Connection con=DBConnection.connectDB();
            String query = "";
            if(phone.getText().length() == 10)
                query="update userdb set firstName='"+fname.getText()+"', lastName='"+lname.getText()+"', email='"+email.getText()+"', phone='"+phone.getText()+"' where UserName='"+userId+"'";
            else
            {
                JOptionPane.showMessageDialog(this, "Enter a valid mobile number");
            }
            java.sql.Statement st;
            st = con.createStatement();
            st.executeUpdate(query);
            ShowProfile();
            JOptionPane.showMessageDialog(this,"Updated successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ManageCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ShowProfile();
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(UpdateProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProfiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton catadd1;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField phone;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nitc.auction.site;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author girik
 */
public class ManageCategories extends javax.swing.JFrame {
    Admin admin=new Admin();
    java.sql.ResultSet rss = null;

    public ManageCategories() {
        initComponents();
        ShowCategory();
    }
    
    
    public void ShowCategory(){
         DefaultTableModel tableModel;
         tableModel=(DefaultTableModel) catTable.getModel(); 
         int rows = tableModel.getRowCount(); 
         for(int i = rows - 1; i >=0; i--)
         {
            tableModel.removeRow(i); 
         }
         
        rss = admin.showCategory();
        
        
        try {
            while(rss.next())
            {

                String category=rss.getString("catId");
                
                String catgoryName=rss.getString("catName");
                
                String tableData[]={category,catgoryName};
                
                tableModel.addRow(tableData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RemoveProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        catadd3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        catName = new javax.swing.JTextField();
        catId = new javax.swing.JTextField();
        catadd = new javax.swing.JButton();
        catupdt = new javax.swing.JButton();
        catdelete = new javax.swing.JButton();
        catclr = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        catTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/previous.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

        catadd3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        catadd3.setForeground(new java.awt.Color(255, 0, 0));
        catadd3.setText("X");
        catadd3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catadd3MouseClicked(evt);
            }
        });
        getContentPane().add(catadd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));
        jPanel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category Id");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category Name");

        catName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        catName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catNameActionPerformed(evt);
            }
        });

        catId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        catId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catIdActionPerformed(evt);
            }
        });

        catadd.setBackground(new java.awt.Color(0, 0, 0));
        catadd.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        catadd.setForeground(new java.awt.Color(255, 255, 255));
        catadd.setText("Add");
        catadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddCategory(evt);
            }
        });

        catupdt.setBackground(new java.awt.Color(0, 0, 0));
        catupdt.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        catupdt.setForeground(new java.awt.Color(255, 255, 255));
        catupdt.setText("Update");
        catupdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateCategory(evt);
            }
        });

        catdelete.setBackground(new java.awt.Color(0, 0, 0));
        catdelete.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        catdelete.setForeground(new java.awt.Color(255, 255, 255));
        catdelete.setText("Delete");
        catdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteCategory(evt);
            }
        });
        catdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catdeleteActionPerformed(evt);
            }
        });

        catclr.setBackground(new java.awt.Color(0, 0, 0));
        catclr.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        catclr.setForeground(new java.awt.Color(255, 255, 255));
        catclr.setText("Clear");
        catclr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catclrMouseClicked(evt);
            }
        });
        catclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catclrActionPerformed(evt);
            }
        });

        catTable.setBackground(new java.awt.Color(102, 102, 102));
        catTable.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        catTable.setForeground(new java.awt.Color(255, 255, 255));
        catTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Id", "Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        catTable.setDoubleBuffered(true);
        catTable.setName(""); // NOI18N
        catTable.setRowHeight(40);
        catTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        catTable.setShowGrid(false);
        catTable.setShowHorizontalLines(true);
        catTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(catTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(catId, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(catName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(catdelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(catclr)
                        .addGap(26, 26, 26)
                        .addComponent(catadd)
                        .addGap(18, 18, 18)
                        .addComponent(catupdt)
                        .addGap(39, 39, 39)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(catId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(catName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(catadd)
                            .addComponent(catupdt)
                            .addComponent(catclr)
                            .addComponent(catdelete))))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Categories");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/new background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void catNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catNameActionPerformed

    private void catIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catIdActionPerformed

    private void AddCategory(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCategory
         String sql="insert into category values(?,?,?,?)";
         if(catId.getText().isEmpty() || catName.getText().isEmpty())
             JOptionPane.showMessageDialog(this,"Missing Information");
         
        try {
            Connection con=DBConnection.connectDB();
            PreparedStatement st=(PreparedStatement)con.prepareStatement(sql);
            st.setString(1,catId.getText());
            st.setString(2,catName.getText());
            st.setString(3, null);
            st.setInt(4, 0);
            st.executeUpdate();
            ShowCategory();
            JOptionPane.showMessageDialog(this,"Added Successfully");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManageCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddCategory

    private void UpdateCategory(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateCategory
          if(catId.getText().isEmpty())
              JOptionPane.showMessageDialog(this, "Missing Information");
          
          
        try {
            Connection con=DBConnection.connectDB();
            String query="update category set catName='"+catName.getText()+"' where catId='"+catId.getText()+"'";
            java.sql.Statement st;
            st = con.createStatement();
            st.executeUpdate(query);
            ShowCategory();
            JOptionPane.showMessageDialog(this,"Category updated successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ManageCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_UpdateCategory

    private void DeleteCategory(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteCategory
        if(catId.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Select a category to delete");
        else{
            try{
                Connection con=DBConnection.connectDB();
                String id = catId.getText();
                System.out.println(id);
                java.sql.Statement st = con.createStatement();
                int executeUpdate = st.executeUpdate("delete from category where catId='"+catId.getText()+"'");
                ShowCategory();
                catId.setText("");
                catName.setText("");
                JOptionPane.showMessageDialog(this,"Category deleted successfully");
            }catch(HeadlessException | NumberFormatException | SQLException ex){
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DeleteCategory

    private void catdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catdeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catdeleteActionPerformed

    private void catclrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catclrMouseClicked
        catId.setText("");
        catName.setText("");
        
    }//GEN-LAST:event_catclrMouseClicked

    private void catTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catTableMouseClicked
       DefaultTableModel model = (DefaultTableModel)catTable.getModel();
        int row = catTable.getSelectedRow();
        catId.setText(model.getValueAt(row, 0).toString());
        catName.setText(model.getValueAt(row, 1).toString());
    }//GEN-LAST:event_catTableMouseClicked

    private void catadd3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catadd3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_catadd3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new AdminDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void catclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catclrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catclrActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCategories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField catId;
    private javax.swing.JTextField catName;
    private javax.swing.JTable catTable;
    private javax.swing.JButton catadd;
    private javax.swing.JButton catadd3;
    private javax.swing.JButton catclr;
    private javax.swing.JButton catdelete;
    private javax.swing.JButton catupdt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

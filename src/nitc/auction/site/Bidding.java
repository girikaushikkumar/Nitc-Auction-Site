/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nitc.auction.site;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author girik
 */
public class Bidding extends javax.swing.JFrame {
    
    String bidderId="";
    Student student=new Student();
    int CurrentPrice=0;
    String prevPId="";
    Login login=new Login();
    String type = "";
    int c=0;
    public Bidding() {
        initComponents();
        
        BidderDashboard bd = new BidderDashboard();
        bd.userId = bidderId;
        bd.type=type;
        
        
    }
    
    public void ShowProduct()
    {
        c=1;
        ResultSet rss = student.BiddingShowProduct();
        try {
            while(rss.next())
            {
//                category, subcategory, pdt_id, pdt_name, brand, pdt_info, price
                String category=rss.getString("category");
                String subcategory=rss.getString("subcategory");
                String ProductId=rss.getString("pdt_id");
                String ProductName=rss.getString("pdt_name");
                String Brand=rss.getString("brand");
                String ProductInfo=rss.getString("pdt_info");
                String Price=rss.getString("price");
                
                //Time comparision
                
                //Getting end time from database
                String time = rss.getString("time_end");
                String timesplit[] = time.split("-");
                String EndTime = timesplit[2]+"/"+"04"+"/"+timesplit[0]+" "+timesplit[3];
                
                //Getting current time
                String DATE_FORMAT_NOW = "yyyy/MM/dd HH:mm";
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
                String curTime = sdf.format(cal.getTime());
            
                DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu/MM/dd HH:mm" );
                LocalDateTime start = LocalDateTime.parse( curTime , f ) ;
                LocalDateTime stop = LocalDateTime.parse( EndTime , f ) ;
                boolean isBefore = start.isBefore( stop ) ;
                
                if(isBefore)
                {
                  String tableData[]={category, subcategory, ProductId, ProductName, Brand, ProductInfo, Price};
                  DefaultTableModel tableModel=(DefaultTableModel) BiddingTable.getModel();
                  tableModel.addRow(tableData);
                }
//                System.out.println( start + " is before " + stop + " = " + isBefore );
                
                
                
                
//                    jButton2.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bidding.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        curPrice.setText(""+CurrentPrice);
    }
    
    public String CheckBidderIsAlreadyExit(String pdtId, String biddId)
    {
        try {
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement("select bidderId from bidding where productId='"+pdtId+"' AND bidderId='"+biddId+"'");
            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
            if(rss.next())
            {
               return rss.getString("bidderId");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void CheckAmout(String pId)
    {
        try {
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement("select price from bidding where productId='"+pId+"'");
            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
            while(rss.next())
            {
                if(Integer.parseInt(rss.getString("price")) > CurrentPrice)
                    CurrentPrice = Integer.parseInt(rss.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        curPrice.setText(""+CurrentPrice);
    }
    
    public void SetEndTime(String pId)
    {
        try {
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement("select time_end from product where pdt_id='"+pId+"'");
//              PreparedStatement st=con.prepareStatement("select time_start from product where pdt_id='"+pId+"'");
            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
            if(rss.next())
            {
               endTime.setText(rss.getString("time_end"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String GetSellerId()
    {
        String sellerId="";
        try {
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement("select seller_id from product where pdt_id='"+pdtId.getText()+"'");
            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
            if(rss.next())
                sellerId = rss.getString("seller_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sellerId;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        catadd1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BiddingTable = new javax.swing.JTable();
        img1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        verify = new javax.swing.JButton();
        curPrice = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bidAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        feedback = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pdtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        endTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/previous.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1290, 763));

        BiddingTable.setBackground(new java.awt.Color(102, 102, 102));
        BiddingTable.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        BiddingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Type", "SubCategory", "Product Id", "Product Name", "Brand", "Product Information", "Base Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BiddingTable.setDoubleBuffered(true);
        BiddingTable.setName(""); // NOI18N
        BiddingTable.setRowHeight(40);
        BiddingTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        BiddingTable.setShowGrid(false);
        BiddingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BiddingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BiddingTable);
        if (BiddingTable.getColumnModel().getColumnCount() > 0) {
            BiddingTable.getColumnModel().getColumn(0).setResizable(false);
            BiddingTable.getColumnModel().getColumn(1).setResizable(false);
            BiddingTable.getColumnModel().getColumn(2).setResizable(false);
            BiddingTable.getColumnModel().getColumn(3).setResizable(false);
            BiddingTable.getColumnModel().getColumn(4).setResizable(false);
            BiddingTable.getColumnModel().getColumn(5).setResizable(false);
            BiddingTable.getColumnModel().getColumn(6).setResizable(false);
        }

        img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current Bid Amount");

        verify.setBackground(new java.awt.Color(0, 0, 0));
        verify.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(255, 255, 255));
        verify.setText("Make a bid");
        verify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BidForProduct(evt);
            }
        });
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });

        curPrice.setBackground(new java.awt.Color(0, 0, 0));
        curPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        curPrice.setForeground(new java.awt.Color(255, 255, 255));
        curPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bid Here");

        bidAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Feedback");

        feedback.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product Id");

        pdtId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Session End Time");

        endTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        endTime.setForeground(new java.awt.Color(255, 255, 255));
        endTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(verify))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(feedback, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(bidAmount)
                            .addComponent(pdtId))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(curPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(endTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pdtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(36, 36, 36)
                                .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(curPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1290, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/new background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BiddingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BiddingTableMouseClicked
        
       
        DefaultTableModel model = (DefaultTableModel)BiddingTable.getModel();
        int row = BiddingTable.getSelectedRow();
        String curPId=model.getValueAt(row, 2).toString();
        pdtId.setText(model.getValueAt(row, 2).toString());
        bidAmount.setText("");
        feedback.setText("");
        int price=Integer.parseInt(model.getValueAt(row, 6).toString());
         SetEndTime(model.getValueAt(row, 2).toString());
        if(!curPId.equals(prevPId))
            {
                CurrentPrice=0;
                
            }
        
        if(price > CurrentPrice)
        {
            CurrentPrice=price;
       
             curPrice.setText(""+CurrentPrice);
        
        }
        //Show Image
        CheckAmout(model.getValueAt(row, 2).toString());
        ResultSet rs = null;
        Connection con = DBConnection.connectDB();
        try {
            PreparedStatement st= con.prepareStatement("select * from product where pdt_id='"+pdtId.getText()+"'");
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Bidding.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            if(rs.next()){
                byte[] img = rs.getBytes("image");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);
                img1.setIcon(newImage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RemoveProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        prevPId=curPId;

    }//GEN-LAST:event_BiddingTableMouseClicked

    private void BidForProduct(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BidForProduct
        if(CheckBidderIsAlreadyExit(pdtId.getText(),bidderId) != null)
        {
            
            try {
                try {
                  int Value = Integer.parseInt(bidAmount.getText());
                  if(Integer.parseInt(bidAmount.getText()) > CurrentPrice)
                  {
                      java.sql.Timestamp curdate = new java.sql.Timestamp(new java.util.Date().getTime());
                      String query="update bidding set price='"+Integer.parseInt(bidAmount.getText())+"', bid_time='"+curdate+"' where bidderId='"+bidderId+"'";
                        Connection con=DBConnection.connectDB();
                        java.sql.Statement st;
                        st = con.createStatement();
                        st.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,"Bidding Successfully");
                        bidAmount.setText("");
                        feedback.setText("");
                        CheckAmout(pdtId.getText());
                        con.close();
                  }
                  else
                     JOptionPane.showMessageDialog(this, "Price Should be greater than current Price");
               } catch (NumberFormatException e) {
                   JOptionPane.showMessageDialog(this, "Price should be number only");
                }
                
               
            } catch (SQLException ex) {
                Logger.getLogger(Bidding.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
        
        String sql = "insert into bidding (sellerId,bidderId,productId,price,bid_time,feedback) values(?,?,?,?,?,?)";
        if(pdtId.getText().isEmpty())
           JOptionPane.showMessageDialog(this, "Please enter Product Id");
       
       try {
            Connection con=DBConnection.connectDB();
      
            PreparedStatement st=(PreparedStatement)con.prepareStatement(sql);

            
            st.setString(1,GetSellerId());
            
            st.setString(2, bidderId);
            st.setString(3, pdtId.getText());
            
            try {
                  int Value = Integer.parseInt(bidAmount.getText());
                  if(Integer.parseInt(bidAmount.getText()) > CurrentPrice)
                      st.setInt(4, Integer.parseInt(bidAmount.getText()));
                  else
                     JOptionPane.showMessageDialog(this, "Price Should be greater than current Price");
               } catch (NumberFormatException e) {
                   JOptionPane.showMessageDialog(this, "Price should be number only");
                }
            
            
            java.sql.Timestamp curdate = new java.sql.Timestamp(new java.util.Date().getTime());
            st.setTimestamp(5, curdate);

            st.setString(6, feedback.getText());
            
            st.executeUpdate();

            JOptionPane.showMessageDialog(this,"Bidding Successfully");
            bidAmount.setText("");
            feedback.setText("");
            CheckAmout(pdtId.getText());
            con.close();
            
         
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        }
    }//GEN-LAST:event_BidForProduct

    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verifyActionPerformed

    private void catadd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catadd1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_catadd1MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        BidderDashboard bd = new BidderDashboard();
        bd.userId = bidderId;
        bd.type=type;
        bd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ShowProduct();
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
            java.util.logging.Logger.getLogger(Bidding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bidding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bidding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bidding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bidding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BiddingTable;
    private javax.swing.JTextField bidAmount;
    private javax.swing.JButton catadd1;
    private javax.swing.JLabel curPrice;
    private javax.swing.JLabel endTime;
    private javax.swing.JTextField feedback;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pdtId;
    private javax.swing.JButton verify;
    // End of variables declaration//GEN-END:variables
}

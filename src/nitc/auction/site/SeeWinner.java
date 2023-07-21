/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nitc.auction.site;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author girik
 */
public class SeeWinner extends javax.swing.JFrame {

    /**
     * Creates new form SeeWinner
     */
    String BidderId="";
    String type = "";
    boolean f = false;
    public SeeWinner() {
        initComponents();
    }
    
     public ArrayList<String> SetProductId()
    {
        ArrayList<String> arr = new ArrayList<>();
        try {
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement("select productId from bidding where bidderId='"+BidderId+"'");
            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
             while(rss.next()){
                try {
//                    pdtId.addItem(rss.getString("productId"));
                    arr.add(rss.getString("productId"));
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(BiddingInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(BiddingInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return arr;
    }
     
      public void ShowDetails()
    {
        int Hprice=0;
        ArrayList<String> arr = SetProductId();
               String winnerName = "";
               DefaultTableModel tableModel;
               tableModel=(DefaultTableModel) pdtTable.getModel(); 
                int rows = tableModel.getRowCount(); 
                for(int i = rows - 1; i >=0; i--)
                {
                   tableModel.removeRow(i); 
                }
            try {
                Connection con=DBConnection.connectDB();
                
                //Set table content
                PreparedStatement stt=con.prepareStatement("select * from product");
                ResultSet rs = (java.sql.ResultSet) stt.executeQuery();
                while(rs.next())
                {
                    for(String id : arr)
                    {
                        if(id.equals(rs.getString("pdt_id")))
                        {
                            String ProductId = rs.getString("pdt_id");
                            String ProductName = rs.getString("pdt_name");
                            String status = "Completed";
                            //Getting end time from database
                            String time = rs.getString("time_end");
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
                                status = "Ongoing";
                            }

                            String tableData[]={ProductId, ProductName, status};

                            tableModel.addRow(tableData);
                        }
                    }
                    
                }
                
                
                
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(RemoveProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public boolean CheckWinnerOrNot(String userName)
      {
          if(BidderId.equals(userName))
        {
             f = true;
            return true;
           
        }
        else
            return false;
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pdtTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        winner = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        price = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        sts = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        GoToSellerDetails = new javax.swing.JButton();
        catadd1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));
        jPanel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 70));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        pdtTable.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        pdtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pdtTable.setDoubleBuffered(true);
        pdtTable.setName(""); // NOI18N
        pdtTable.setRowHeight(40);
        pdtTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        pdtTable.setShowGrid(false);
        pdtTable.setShowHorizontalLines(true);
        pdtTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdtTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pdtTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Current Winner ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Current Price");

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        winner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        winner.setForeground(new java.awt.Color(255, 255, 255));
        winner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        price.setForeground(new java.awt.Color(255, 255, 255));
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Status");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product Id");

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setForeground(new java.awt.Color(102, 102, 102));

        id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel6.setName(""); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(207, 34));

        sts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sts.setForeground(new java.awt.Color(255, 255, 255));
        sts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        sts.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sts, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sts, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact With Seller");

        GoToSellerDetails.setBackground(new java.awt.Color(0, 0, 0));
        GoToSellerDetails.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        GoToSellerDetails.setForeground(new java.awt.Color(255, 255, 255));
        GoToSellerDetails.setText("Check");
        GoToSellerDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GoToSellerDetailsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GoToSellerDetails)
                        .addGap(112, 112, 112))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(GoToSellerDetails)
                        .addGap(81, 81, 81))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 1280, 650));

        catadd1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        catadd1.setForeground(new java.awt.Color(255, 0, 0));
        catadd1.setText("X");
        catadd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catadd1MouseClicked(evt);
            }
        });
        getContentPane().add(catadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auction/image/previous.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        BidderDashboard bd = new BidderDashboard();
        bd.userId = BidderId;
        bd.type=type;
        bd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void catadd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catadd1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_catadd1MouseClicked

    private void pdtTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdtTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)pdtTable.getModel();
        int row = pdtTable.getSelectedRow();

        String ProductId = model.getValueAt(row, 0).toString();
        sts.setText(model.getValueAt(row, 2).toString());
        id.setText(model.getValueAt(row, 0).toString());
        int Hprice=0;
        String winnerName = "";
        String userName = "";
        try{
            Connection con=DBConnection.connectDB();
            PreparedStatement st=con.prepareStatement("SELECT pdt.pdt_name, usr.firstName, usr.UserName, usr.lastName, usr.email, usr.phone, bd.price from product as pdt inner join bidding as bd inner join userdb as usr on pdt_id='"+ProductId+"' and productId='"+ProductId+"' and bidderId=userName ");

            ResultSet rss = (java.sql.ResultSet) st.executeQuery();
            while(rss.next())
            {
                //                category, subcategory, pdt_id, pdt_name, brand, pdt_info, price
                String ProductName=rss.getString("pdt_name");
                String firstName=rss.getString("firstName");
                String lastName=rss.getString("lastName");
                String BidderName = firstName+" "+lastName;
                String email=rss.getString("email");
                userName= rss.getString("UserName");
                String Phone=rss.getString("phone");

                String Price=rss.getString("price");
                if(Hprice < Integer.parseInt(Price))
                {
                    Hprice = Integer.parseInt(Price);
                    winnerName = BidderName;
                }
                //                String tableData[]={ProductName, BidderName, email, Phone, Price};

                //                tableModel.addRow(tableData);
            }
            
           
            if(sts.getText().equals("Completed"))
            {
                 boolean check = CheckWinnerOrNot(userName);
                if(check)
                {
                    JOptionPane.showMessageDialog(this, "Congratulation for winning the product.  Now you can contact with Seller");
                }
                else
                    JOptionPane.showMessageDialog(this, "Oops! you lost the bid");
            }
            winner.setText(winnerName);
            price.setText(Hprice+"");

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(RemoveProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_pdtTableMouseClicked

    private void GoToSellerDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToSellerDetailsMouseClicked
        if(sts.getText().equals("Completed"))
        {
            if(f){
                String sellerId ="";
                try {
                    String query = "select sellerId from bidding where productId='"+id.getText()+"'";
                    Connection con=DBConnection.connectDB();
                    PreparedStatement st=con.prepareStatement(query);
                    ResultSet rss = (java.sql.ResultSet) st.executeQuery();
                    if(rss.next())
                        sellerId = rss.getString("sellerId");
                } catch (SQLException ex) {
                    Logger.getLogger(SeeWinner.class.getName()).log(Level.SEVERE, null, ex);
                }
                SellerDetailsFromBidderSide sd = new SellerDetailsFromBidderSide();
                sd.sellerId = sellerId;
                sd.BidderId = BidderId;
                sd.type = type;
                sd.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Sorry you are not winner so you can not see the Seller Details");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Bidding is ongoing so wait for complete");
        }
    }//GEN-LAST:event_GoToSellerDetailsMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       ShowDetails();
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
            java.util.logging.Logger.getLogger(SeeWinner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeeWinner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeeWinner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeeWinner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeeWinner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoToSellerDetails;
    private javax.swing.JButton catadd1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pdtTable;
    private javax.swing.JLabel price;
    private javax.swing.JLabel sts;
    private javax.swing.JLabel winner;
    // End of variables declaration//GEN-END:variables
}

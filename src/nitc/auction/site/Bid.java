/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitc.auction.site;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author girik
 */
public class Bid {
    
    public void bid(String pdtId,String SellerId, String bidderId,int bidAmount,int CurrentPrice,Timestamp curDate, String feedback)
    {
        String sql = "insert into bidding (sellerId,bidderId,productId,price,bid_time,feedback) values(?,?,?,?,?,?)";
        
       
       try {
            Connection con=DBConnection.connectDB();
      
            PreparedStatement st=(PreparedStatement)con.prepareStatement(sql);

            
            st.setString(1,SellerId);
            
            st.setString(2, bidderId);
            st.setString(3, pdtId);
            
            try {
                  int Value = bidAmount;
                  if(bidAmount > CurrentPrice)
                      st.setInt(4, bidAmount);
                  else
                     System.out.println("Price Should be greater than current Price");
               } catch (NumberFormatException e) {
                   e.printStackTrace();
                }
            
            
            java.sql.Timestamp curdate = new java.sql.Timestamp(new java.util.Date().getTime());
            st.setTimestamp(5, curdate);

            st.setString(6, feedback);
            st.executeUpdate();

            
           
         
            con.close();
            
         
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}

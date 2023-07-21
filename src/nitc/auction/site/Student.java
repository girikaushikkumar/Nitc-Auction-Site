/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitc.auction.site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author girik
 */
public class Student extends User{
    String userId="";
    
    public boolean loginUser(String uname,String password)
    {
        try {
            
            Connection conn=DBConnection.connectDB();
            st = conn.prepareStatement("select * from userdb where UserName='"+uname+"' and password='"+password+"'");
            rss = (java.sql.ResultSet) st.executeQuery();
            userId = uname;
            if(rss.next())
                return true;
            else
                return false;
        
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet showProduct(String userId)
    {
        try {
            
            con=DBConnection.connectDB();
            st=con.prepareStatement("select * from product where seller_id='"+userId+"'");
//            category, pdt_id, pdt_name, price, time_end, status
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
    public ResultSet BiddingShowProduct()
    {
        try {
            String status="OK";
            con=DBConnection.connectDB();
            
            st=con.prepareStatement("select * from product where status='"+status+"'");
//            category, subcategory, pdt_id, pdt_name, brand, pdt_info, price
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
    public boolean CheckUserName(String userName)
    {
        boolean b = false;
        try{
         Connection con=DBConnection.connectDB();
         PreparedStatement ps = con.prepareStatement("select * from userdb where UserName='"+userName+"'");
         ResultSet  rs = (java.sql.ResultSet) ps.executeQuery();
          
            if(rs.next() == true){
                b= true;
            }
            else
              b= false; 
         
         }
         catch(SQLException ex)
         {
             Logger.getLogger(ManageCategories.class.getName()).log(Level.SEVERE, null, ex);
             
         }
        return b;
    }
    
}

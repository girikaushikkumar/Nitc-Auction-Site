/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitc.auction.site;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;



/**
 *
 * @author girik
 */
public class  Admin extends User{
    
    public boolean loginUser(String uname,String password)
    {
        try {
            Connection conn=DBConnection.connectDB();
            st = conn.prepareStatement("select * from admindb where userName='"+uname+"' and password='"+password+"'");
            rss = (java.sql.ResultSet) st.executeQuery();
          
            if(rss.next())
                return true;
            else
                return false;
        
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet showCategory(){      
        try {
            con=DBConnection.connectDB();
            st=con.prepareStatement("select catId, catName from category");
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
    public ResultSet showSubCategory(){
        try {
            con=DBConnection.connectDB();
            st=con.prepareStatement("select category_type, subcategory_id, subcategory_name from subcategory");
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
    public ResultSet showProduct()
    {
        try {
            
            con=DBConnection.connectDB();
            st=con.prepareStatement("select category, subcategory, pdt_id, pdt_name, brand, price, time_end from product where status='"+"pending"+"'");
            
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
    public ResultSet veiwFeedback()
    {
        try {
            
            con=DBConnection.connectDB();
            st=con.prepareStatement("select productId, bidderId, feedback from bidding");
            
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
    public ResultSet VerifyProduct()
    {
        try {
            
            con=DBConnection.connectDB();
            st=con.prepareStatement("select category, subcategory, pdt_id, pdt_name, brand, price, time_end from product where status='"+"pending"+"'");
            
            rss = (java.sql.ResultSet) st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rss;
    }
    
}

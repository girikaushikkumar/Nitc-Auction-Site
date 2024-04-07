/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitc.auction.site;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author girik
 */
public class DBConnection {
    private static final String user="root";
    private static final String url="jdbc:mysql://localhost:3306/auctiondb";
    private static final String pass="******";
   
    public static Connection connectDB()
    {
        Connection con = null;
        try{
                con = DriverManager.getConnection(url,user,pass);
                
        }catch(Exception e){
            System.out.println("DB Connection error...");
            e.printStackTrace();
            return null;
        } 
        return con;
}
}

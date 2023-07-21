/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitc.auction.site;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author girik
 */
 abstract class User {
    public String Username = "";
    public String password = "";
    
    
    protected Connection con = null;
    protected PreparedStatement st = null;
    protected java.sql.ResultSet rss = null;
    
    public boolean loginUser(String uname,String password)
    {
        return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.utils;

import be.bt.model.dao.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rome10
 */
public class Authenticator {
    
    public static int verifyCredentials(String user, String pass) {
        int retCode = -1;
        try {
            Connection con = DBConnector.getConnection();
            String sql = "select password from users where username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            ResultSet res = st.executeQuery();
           
            
            if(res.next()) {
                String recuppass = res.getString("password");
                if (recuppass.equals(pass)) {
                    retCode = 0;
                } else { retCode = 1; }
            } else {retCode = 2;}
            
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retCode;
    
    }
   
}

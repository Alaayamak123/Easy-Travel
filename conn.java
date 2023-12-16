/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fanan
 */
public class conn {
    public static Connection getConncetion() throws SQLException{
      Connection con = null;
        try {
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##fanan2","0000");
           
            
        } catch (Exception ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
        return con;
       
    }
    
}

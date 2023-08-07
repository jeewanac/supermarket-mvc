/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.DBConnection;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
/**
 *
 * @author HP
 */
public class DBConnection {
    private static DBConnection dBConnection;
   private Connection connection;
    public DBConnection() throws ClassNotFoundException {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "Aish@1991");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public static DBConnection getInstance() throws ClassNotFoundException {
        if(dBConnection == null){
            dBConnection = new DBConnection();
        } else{
            
        }
        return dBConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}


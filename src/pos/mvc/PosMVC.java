/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pos.mvc;

import java.sql.SQLException;
import pos.mvc.view.CustomerView;

/**
 *
 * @author HP
 */
public class PosMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       new CustomerView().setVisible(true);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import pos.mvc.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import pos.mvc.DBConnection.DBConnection;
//import pos.mvc.db.DBConnection;


/**
 *
 * @author HP
 */
public class CustomerController {
    public String saveCustomer(CustomerModel customer) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
    
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,customer.getCustID());
        preparedStatement.setString(2,customer.getTitle());
        preparedStatement.setString(3,customer.getName());
        preparedStatement.setString(4,customer.getDob());
        preparedStatement.setDouble(5,customer.getSalary());
        preparedStatement.setString(6,customer.getAddress());
        preparedStatement.setString(7,customer.getCity());
        preparedStatement.setString(8,customer.getProvince());
        preparedStatement.setString(9,customer.getZip());
        

        if(preparedStatement.executeUpdate()>0){
            return "Success";
        }else{
            return " Fail";
        }
    
        
    } 

    public ArrayList<CustomerModel> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String quary = "SELECT*FROM customer";
        
        PreparedStatement preparedStatement = connection.prepareStatement(quary);
        ResultSet rst = preparedStatement.executeQuery();
        
        ArrayList<CustomerModel> customerModels = new ArrayList<>();
        
        while(rst.next()){
            
            CustomerModel customerModel = new CustomerModel(rst.getString(1), 
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getString(4), 
                    rst.getDouble(5), 
                    rst.getString(6),
                    rst.getString(7), 
                    rst.getString(8), 
                    rst.getString(9));
            
            customerModels.add(customerModel);
            
            
        }
        return customerModels;
    }

    public CustomerModel getCustomer(String custID) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String quary = "SELECT*FROM customer WHERE custID = ?";
        PreparedStatement statement = connection.prepareStatement(quary);
        statement.setString(1, custID);
        ResultSet rst = statement.executeQuery();
        
        while(rst.next()){
            CustomerModel customerModel = new CustomerModel(rst.getString(1), 
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9));
            return customerModel;   
        }
        
        return null;
    }
    
}

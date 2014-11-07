/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joaquin David
 */
public class DataBase {
    public Connection Get_Connection() throws Exception{
        
        try{
            String connectionURL = "jdbc:mysql://localhost:3306/website?zeroDateTimeBehavior=convertToNull";
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL,"root","");
            return connection;
        }catch (SQLException e){
            System.out.println("Error " + e.toString());
            throw e; 
        }catch(Exception e){
        throw e;
        }
  
    }
}

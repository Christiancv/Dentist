/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ccami
 */
public class ConnectionManager {
    
    
    
    private static Connection con;
    private static String url = "jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//Dentist//DentistOfficeACCDB.accdb";
    private static String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    public static Connection MyConnection(){
        
        try{
            Class.forName(driverName);
            System.out.println("Connecting to Database...");
            con = DriverManager.getConnection(url);
            System.out.println("Connection Successful");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ccami
 */
public class Appointment {
    
 // declare variables 
    
    private String Date;
    private String Id;
    private String DentId;
    private String ProcCode;
    
//Constructors
    public Appointment(){
        Date = " ";
        Id = " ";
        DentId = " ";
        ProcCode = " ";
    
    }
    
    
    public Appointment(String date, String id, String dentid, String procode){

        Date = date;
        Id = id;
        DentId = dentid;
        ProcCode = procode;
    }
    
    // setters and getters 
    
    public String getDate(){
        return Date;
    }
    
    public void setDate(String date){
        Date = date;
    }
    
    public String getId(){
        return Id;
    }
    
    public void setId(String id){
        Id = id;
    }
    
    public String getDentId(){
        return DentId;
    }
    
    public void setDentId(String dentid){
        DentId = dentid;
    }
    
    public String getProcCode(){
        return ProcCode;
    }
    
    public void setProcCode(String proccode){
        ProcCode = proccode;
    }
    
    //select from database
    public void selectDB(String id) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "select apptDateTime, patId, dentId, procCode from Appointments" +
                " where patId = " + "'" +id+"'";
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            Date = rs.getString(1);
            Id = rs.getString(2);
            DentId = rs.getString(3);
            ProcCode = rs.getString(4);  
            
            
        }
        con.close();
        
    
    }
    
    
    //insert to database
     public void insertDB(String date, String id, String dentid, String proccode) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "insert into Appointments"
                + " values (" +"'"+date+"'" + ", " + "'"+id+"'" + ", " + "'"+dentid+"'" + ", " 
                + "'"+proccode+"'" + " )";

        int n  = stmt.executeUpdate(sql);
        if(n == 1){
            System.out.println("Appointment successfully inserted");
        
        }
        else{
            System.out.println("Fail to insert new Appointment");
        
        }
    
    }
     
     
     //delete appointments
    public void deleteDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        sql = "delete from Appointments" + 
                " where PatId = " + "'"+getId()+"'";
        
        int n = stmt.executeUpdate(sql);
        if (n == 1){
            System.out.println("Appointment Deleted");
        
        }else{
            System.out.println("Failed to delete Appointment");
        
        }
        
                
    
    }
    
    
    //update appointments
    public void updateDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "update Appointments" + 
                " set apptDateTime = " + "'"+getDate()+"'" + ", dentId = " + "'"+getDentId()+"', procCode = " + "'"+getProcCode()+"'"
                + " where patId = " + "'"+getId()+"'" +";";
                
        
        int n = stmt.executeUpdate(sql);
        
        if(n == 1){
            System.out.println("Failed to Update Appointment");
            
        
        }else{
        
            System.out.println("Update Successful");
        }
    
    }
    
        
   
    
    
    //display records
    public void Display(){
 
        System.out.println("--------------------------------");
        System.out.println("Appointment Information");       
        System.out.println("--------------------------------");
        System.out.println("ID: " + Id);
        System.out.println("Date: " + Date );
        System.out.println("Dentist Id: " + DentId);
        System.out.println("Procedure Code: " + ProcCode);
        
        
    }
    
    //Testing
    public static void main(String[] args) throws SQLException{
        
        Appointment Ap1 = new Appointment();
        //Ap1.insertDB("May1, 2019, 9am", "A911", "D202", "P114");
        Ap1.selectDB("A907");
        //Ap1.deleteDB();
        
       
        
        
        Ap1.setDate("Nov 29th 2018");
        System.out.println(Ap1.getDate());
        Ap1.setDentId("D201");
        System.out.println(Ap1.getDentId());
        Ap1.setProcCode("P790");
        System.out.println(Ap1.getProcCode());
        Ap1.updateDB();
        
        Ap1.Display();
        
    }
    
}

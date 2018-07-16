package Dentist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccami
 */
public class Procedure {
    
    
    //declare procedure fields                                                                                  
    private String Code;
    private String Name;
    private String Desc;
    private double Cost;
    
   //constructors 
    public Procedure(){
        Code = " ";
        Name = " ";
        Desc = " ";
        Cost = 0;  
    }
    
    public Procedure(String code, String name, String desc, double cost){
        Code = code;
        Name = name;
        Desc = desc;
        Cost = cost;  
    }
    
    //setters and getters
    public String getCode(){
        return Code;
    }
    
    public void setCode(String code){
        Code = code;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        Name = name;
    }
    
    public String getDesc(){
        return Desc;
    }
    
    public void setDesc(String desc){
        Desc = desc;
    }
    
    public double getCost(){
        return Cost;
    }
    
    //select procedure form database
    public void selectDB(String code) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "select procCode, procName, procDesc, Cost " +               
                "from Procedures" +
                " where procCode = " + "'" +code+"'";
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            Code = rs.getString(1);
            Name = rs.getString(2);
            Desc = rs.getString(3);
            Cost = rs.getDouble(4);  
        }
        con.close();
        
    
    }
    
    //insert new procedure
    public void insertDB(String code, String name, String desc, double cost) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "insert into Procedures"
                + " values ('"+code+"'" + ", '"+name + "', " + "'"+desc+"'" + ", " 
                + "'"+cost+"')";

        int n  = stmt.executeUpdate(sql);
        if(n == 1){
            System.out.println("Procedure successfully inserted");
        
        }
        else{
            System.out.println("Fail to insert new Procedure");
        
        }
    
    }
    
    //delete from database
    public void deleteDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        sql = "delete from Procedures" + 
                " where procCode = " + "'"+getCode()+"'";
        
        int n = stmt.executeUpdate(sql);
        if (n == 1){
            System.out.println("Procedure Deleted");
        
        }else{
            System.out.println("Failed to delete Procedure");
        
        }
        
                
    
    }
    
    //update procedure
    public void updateDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "update Procedures" + 
                    " set procName = " + "'"+getName()+"', procDesc = " + "'"+getDesc()+"', cost = " +
                "'"+getCost()+"' where proCode = '" + getCode()+"'" ;
        
        int n = stmt.executeUpdate(sql);
        
        if(n == 1){
            System.out.println("Failed to Update Procedure");
            
        
        }else{
        
            System.out.println("Update Successful");
        }
    
    }
    
    //get procedure description
     public String getDescription() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        sql = "select procDesc from Procedures" + 
                " where procCode = " + "'"+getCode()+"'";
        
        rs = stmt.executeQuery(sql);
        rs.next();
        String desc = rs.getString(1);
        
        return desc;
    }
    
    public void Display(){
 
        System.out.println("--------------------------------");
        System.out.println("Procedure Information");       
        System.out.println("--------------------------------");
        System.out.println("Code: " + Code);
        System.out.println("Name: " + Name );
        System.out.println("Description: " + Desc);
        System.out.println("Cost: $" + Cost);
        
    }
    
    
    //Debugging
    public static void main(String[] args) throws SQLException{
    
       Procedure p = new Procedure();
       p.selectDB("P114");
       p.Display();
       p.getDescription();
        
       
    }
    
    
    

    
    
    
}

    


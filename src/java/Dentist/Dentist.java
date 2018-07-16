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
public class Dentist {
    
    //Dentist class declare fields and creates constructors                                                                                  
    private String Id;
    private String Pw;
    private String Fn;
    private String Ln;
    private String Email;
    private String Office;
    public AppointmentList alist = new AppointmentList();
    
    public Dentist(){
        Id = " ";
        Pw = " ";
        Fn = " ";
        Ln = " ";  
        Email = " ";
        Office = " ";
    }
    
    public Dentist(String id, String pw, String fn, String ln, String email, String office){
        Id = id;
        Pw = pw;
        Fn = fn;
        Ln = ln;  
        Email = email;
        Office = office;
    }
    
    
    //setters and getters
    public String getId(){
        return Id;
    }
    
    public void setId(String id){
        Id = id;
    }
    
    public String getPw(){
        return Pw;
    }
    
    public void setPw(String pw){
        Pw = pw;
    }
    
    public String getFn(){
        return Fn;
    }
    
    public void setFn(String fn){
        Fn = fn;
    }
    
    public String getLn(){
        return Ln;
    }
    
    public void setLn(String ln){
        Ln = ln;
        
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String email){
        Email = email;
    }
    
    public String getOffice(){
        return Office;
    }
    
    public void setOffice(String office){
        Office = office;
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
        sql = "select id, passwd, firstName, lastName, email, office " +               
                "from Dentists" +
                " where id = " + "'" +id+"'";
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            Id = rs.getString(1);
            Pw = rs.getString(2);
            Fn = rs.getString(3);
            Ln = rs.getString(4);  
            Email = rs.getString(5);
            Office = rs.getString(6);
        }
        con.close();
        
    
    }
    
    
    //insert to database
    public void insertDB(String id, String pw, String fn, String ln, String email, String office) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "insert into Dentists"
                + " values ('"+id+"'" + ", '"+pw + "', " + "'"+fn+"'" + ", " 
                + "'"+ln+"'" + ", " + "'"+email+"'" + "," + "'"+office+"'" + " )";

        int n  = stmt.executeUpdate(sql);
        if(n == 1){
            System.out.println("Dentist successfully inserted");
        
        }
        else{
            System.out.println("Fail to insert new Destist");
        
        }
    
    }
    
    //delete records 
    public void deleteDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        sql = "delete from Dentists" + 
                " where id = " + "'"+getId()+"'";
        
        int n = stmt.executeUpdate(sql);
        if (n == 1){
            System.out.println("Dentist Deleted");
        
        }else{
            System.out.println("Failed to delete Dentist");
        
        }
        
                
    
    }
    
    //update records
    public void updateDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "update Dentists" + 
                " set passwd = " + getPw() + ", firstName = " + "'"+getFn()+"', lastName = " + "'"+getLn()+"', email = " +
                "'"+getEmail()+"'" + ", office = " + "'"+getOffice()+"' where Id = '" + getId()+"'" ;
        
        int n = stmt.executeUpdate(sql);
        
        if(n == 1){
            System.out.println("Failed to Update Dentist");
            
        
        }else{
        
            System.out.println("Update Successful");
        }
    
    }
    
    //gets appointment list to store appointments for the same doctor
    public void getAppointments(AppointmentList alist2) throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "select patId from Appointments where dentId = '" +
                getId() +"'";
        System.out.println(sql);
        rs = stmt.executeQuery(sql);
        Appointment a1;
        String id;
        
        while(rs.next()){
            id = rs.getString(1);
            System.out.println("Patient id = " + id);
            a1 = new Appointment();
            a1.selectDB(id);
            alist.addAppointment(a1);
            alist = alist2;
        
        }        
    
    }

    //display records 
    public void Display(){
 
        System.out.println("--------------------------------");
        System.out.println("Dentist Information");       
        System.out.println("--------------------------------");
        System.out.println("ID: " + Id);
        System.out.println("Password: " + Pw );
        System.out.println("FirstName: " + Fn);
        System.out.println("LastName: " + Ln);
        System.out.println("Email: " + Email);
        System.out.println("Office: " + Office);
        
    }
    
    
    //Debugging
    public static void main(String[] args) throws SQLException{
    
        Dentist d1 = new Dentist();
        d1.selectDB("D201");
        
        AppointmentList alist2 = new AppointmentList();
        d1.getAppointments(alist2);
        System.out.println(alist2.alist.get(2).getId());
        
       
    }
    
    
    

    
    
    
}

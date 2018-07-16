/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentist;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ccami
 */




public class Patient {
    
    // declare patient information
    private String PatID;
    private String PatPw;
    private String PatFirstName;
    private String PatLastName;
    private String PatAddr;
    private String PatEmail;
    private String PatInsCo;
    
    
    //constructors 
    public Patient(){
        PatID = " ";
        PatPw = " ";
        PatFirstName = " ";
        PatLastName = " ";  
        PatAddr = " ";
        PatEmail = " ";
        PatInsCo = " ";
    
    }
    
    public Patient(String patid, String patpw, String patfirstname, String patlastname, String pataddr, String patemail, String patinsco){
        PatID = patid;
        PatPw = patpw;
        PatFirstName = patfirstname;
        PatLastName = patlastname;  
        PatAddr = pataddr;
        PatEmail = patemail;
        PatInsCo = patinsco;
    }
    
    //setter and getters
    public String getPatID(){
        return PatID;
    }
    
    public void setPatID(String id){
        PatID = id;
    }
    
    public String getPatPw(){
        return PatPw;
    }
    
    public void setPatPw(String pw){
        PatPw = pw;
    }
    
    public String getPatfn(){
        return PatFirstName;
    }
    
    public void setPatfn(String fn){
        PatFirstName = fn;
    }
    
    public String getPatln(){
        return PatLastName;
    }
    
    public void setPatln(String ln){
        PatLastName = ln;
        
    }
    
    public String getPataddr(){
        return PatAddr;
    }
    
    public void setPataddr(String address){
        PatAddr = address;
    }
    
    public String getPatemail(){
        return PatEmail;
    }
    
    public void setPatemail(String email){
        PatEmail = email;
    }
    
    public String getPatinsco(){
        return PatInsCo;
    }
    
    public void setPatinsco(String insurance){
        PatInsCo = insurance;
    }
    
    //select patient information from database
    public void selectDB(String id) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "select patId, passwd, firstName, lastName, addr, email, insCo " +               
                "from Patients" +
                " where patId = " + "'" +id+"'";
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            PatID = rs.getString(1);
            PatPw = rs.getString(2);
            PatFirstName = rs.getString(3);
            PatLastName = rs.getString(4);  
            PatAddr = rs.getString(5);
            PatEmail = rs.getString(6);
            PatInsCo = rs.getString(7);
            
        }
        con.close();
        
    
    }
    
    //insert new patient
    public void insertDB(String id, String pw, String fn, String ln, String add, String email, String insurance) throws SQLException{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "insert into Patients"
                + " values (" +"'"+id+"'" + ", " + "'"+pw+"'" + ", " + "'"+fn+"'" + ", " 
                + "'"+ln+"'" + ", " + "'"+add+"'" + ", " + "'"+email+"'" + "," + "'"+insurance+"'" + " )";

        int n  = stmt.executeUpdate(sql);
        if(n == 1){
            System.out.println("Patient successfully inserted");
        
        }
        else{
            System.out.println("Fail to insert new Patient");
        
        }
    
    }
    
    //delete patient 
    public void deleteDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        sql = "delete from Patients" + 
                " where PatId = " + "'"+getPatID()+"'";
        
        int n = stmt.executeUpdate(sql);
        if (n == 1){
            System.out.println("Patient Deleted");
        
        }else{
            System.out.println("Failed to delete Patient");
        
        }
        
                
    
    }
    
    //update information about patient 
    public void updateDB() throws SQLException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        
        con = ConnectionManager.MyConnection();
        stmt = con.createStatement();
        System.out.println("Accessing Database...");
        sql = "update Patients" + 
                " set passwd = " + getPatPw() + ", addr = " + "'"+getPataddr()+"', email = " + "'"+getPatemail()+"', insCo = " +
                "'"+getPatinsco()+"' where patId = '" + getPatID()+"'" ;
        
        int n = stmt.executeUpdate(sql);
        
        if(n == 1){
            System.out.println("Failed to Update Patient");
            
        
        }else{
        
            System.out.println("Update Successful");
        }
    
    }
    
    
    //display patient information
    public void Display(){
 
        System.out.println("--------------------------------");
        System.out.println("Patient Information");       
        System.out.println("--------------------------------");
        System.out.println("ID: " + PatID);
        System.out.println("Password: " + PatPw );
        System.out.println("FirstName: " + PatFirstName);
        System.out.println("LastName: " + PatLastName);
        System.out.println("Address: " + PatAddr);
        System.out.println("Email: " + PatEmail);
        System.out.println("Insurance: " + PatInsCo);
        
    }
    
    
    //Debugging
    public static void main(String[] args) throws SQLException{
    
        //Patient p = new Patient();
       
        //p.selectDB("A900");
        //System.out.println(p.getPatPw());
        //p.Display();
        
        Patient p2 = new Patient();
        
        //p2.insertDB("A913", "5555","Christian" ,"Virgen", "Acworth","cvirgen@gmail.com", "Humana");
        
        
        p2.selectDB("A900");
        p2.setPatPw("1234");
        p2.setPataddr("Marietta");
        p2.setPatemail("jhawk@yahoo.com");
        p2.setPatinsco("Cigna");
        p2.updateDB();
        p2.Display();
       
    }
    
    
    

    
    
    
}

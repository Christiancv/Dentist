/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ccami
 */
public class AppointmentList {
    //count to keep track of amount
    int count;
    
    //list of appointmetns
    public List<Appointment> alist = new ArrayList<Appointment>(10); 
    
    
    //add appointmenst to the array
    public void addAppointment(Appointment a1){
        alist.add(count, a1);
        count++;
    }
    
    public void display(){
        System.out.println("In AppointmentList display()");
        for(int i = 0; i < count; i++)
        {
            alist.get(i).Display();
            System.out.println("--------------");
       
        }
    }
    
    
    //testing
    public static void main(String[] args){
        AppointmentList a1 = new AppointmentList();
        a1.addAppointment(new Appointment("November 11, 2019", "A912", "A202", "P322"));
        a1.display();
        
    }
}

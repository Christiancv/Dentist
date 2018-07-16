
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dentist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ccami
 */
@WebServlet(name = "DentistEditServlet", urlPatterns = {"/DentistEditServlet"})
public class DentistEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //Get dentist from session
            System.out.println("starting servlet");
            HttpSession session = request.getSession(true);
            Dentist d1 = new Dentist();
            d1 = (Dentist)session.getAttribute("d1");
            d1.Display();
            
            
            // get information from text fields 
            String password = request.getParameter("Password");
            String fname = request.getParameter("fn");
            String lname = request.getParameter("ln");
            String email = request.getParameter("Email");
            String office = request.getParameter("Office");
            
            //checks if text fields are empty and sets properties if they are not
            if(password != null && !password.isEmpty()){d1.setPw(password);}
            if(fname != null && !fname.isEmpty()){d1.setFn(password);}
            if(lname != null && !lname.isEmpty()){d1.setLn(password);}
            if(email != null && !email.isEmpty()){d1.setEmail(email);}
            if(office != null && !office.isEmpty()){d1.setOffice(office);}
            
            
            d1.updateDB();
            d1.Display();
            
            RequestDispatcher rd = request.getRequestDispatcher("/DentistView.jsp");
            rd.forward(request, response);
            
            System.out.println("update successful");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : Appointments
    Created on : Jul 5, 2018, 10:15:16 PM
    Author     : ccami
--%>

<%@page import="Dentist.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dentist.Appointment"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/style.css">
        <title>Hello, world!</title>
    </head>
    
    
    
    <%
        //get patient form session
        System.out.println("Appointment.jsp::getting patient from session");
        Patient p1 = (Patient)session.getAttribute("p1");
        p1.Display();
        System.out.println("patient successfuly acquired");
        
        //instantiate appointment object
        Appointment apt = new Appointment();
        apt.selectDB(p1.getPatID());
        apt.Display();
        
    
    %>
     

    <!-- navigation bar -->
    <body class="navbar navbar2 container-fluid aptt">
        <nav class=" navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Patient</a>
                </div>
                <ul class="nav navbar-nav float">
                    <li class=""><a href="index.jsp">Logout</a></li>
                </ul>
            </div>
        </nav>
        
        <!-- show patient appointment , only one per patient -->
        <div class="container">
            <div class="row" style="padding-top:100px;">
      
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title"><%out.println("Patient ID # " + p1.getPatID());%></h3>
                </div>
                <div class="panel-body">
                  <div class="row">
                    <div class=" col-md-12 col-lg-12 "> 
                      <table class="table table-user-information" >
                        <tbody align="center">
                          <tr>
                            <td>Date:</td>
                            <td><%out.println(apt.getDate());%></td>
                          </tr>  
                          <tr>
                            <td>Dentist ID:</td>
                            <td><%out.println(apt.getDentId());%></td>
                          </tr>
                          <tr>
                            <td>Procedure Code:</td>
                            <td><%out.println(apt.getProcCode());%></td>
                          </tr>
                          
                        </tbody>
                      </table>
                      <div style="padding-left:29%;">
                      <a href="View.jsp" class="btn btn-primary">Profile</a>
                      <a href="EditAppointment.jsp" class="btn btn-primary">Edit Appointment</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
    </div>
                          
    <!-- send appointment to the session-->
     <%
          HttpSession ses = request.getSession(true);
          ses.setAttribute("apt", apt);
          System.out.println("Appointment Added to Session");
    
      
      %> 
       
    </body>
</html>

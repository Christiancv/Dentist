<%-- 
    Document   : Appointments
    Created on : Jul 5, 2018, 10:15:16 PM
    Author     : ccami
--%>

<%@page import="Dentist.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dentist.AppointmentList"%>
<%@page import="Dentist.Procedure"%>
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
    
    
    <!-- get dentist from session and instantiate AppointmentList object and procedure -->
    <%
        Dentist d1 = (Dentist)session.getAttribute("d1");
        AppointmentList alist2 = new AppointmentList();
        d1.getAppointments(alist2);
        
        Procedure p = new Procedure();
    %>
     

<!-- navigation bar -->
    <body class="navbar navbar2 container-fluid aptt">
        <nav class=" navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Dentist</a>
                </div>
                <ul class="nav navbar-nav float">
                    <li class=""><a href="index.jsp">Logout</a></li>
                </ul>
            </div>
        </nav>
        
        
        <div class="container">
            <div class="row" style="padding-top:100px;">
      
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title"><%out.println("Dentist ID # " + d1.getId());%></h3>
                </div>
                <div class="panel-body">
                  <div class="row">
                    <div class=" col-md-12 col-lg-12 "> 
                      <table class="table table-user-information" >
                        <tbody align="center">
                            <!-- with a for loop show a list of appointments for the doctor -->
                        <tr>
                            <th>Date and Time</th>
                            <th>Patient ID</th>
                            <th>Procedure Code</th>
                            <th>Procedure Description</th>
                        </tr>
                          <%for(int i = 0; i < alist2.alist.size();i++){
                              p.selectDB(alist2.alist.get(i).getProcCode());
                          
                          %>
                        <tr>
                            <th><%out.println(alist2.alist.get(i).getDate());%></th>
                            <th><%out.println(alist2.alist.get(i).getId());%></th>
                            <th><%out.println(alist2.alist.get(i).getProcCode());%></th>
                            <th><%out.println(p.getDescription());%></th>
                        </tr>
                
                <%}%>
                        </tbody>
                      </table>
                      <div style="padding-left:29%;">
                      <a href="DentistView.jsp" class="btn btn-primary">Profile</a>
                      <a href="DentistLogin.jsp" class="btn btn-primary">Logout</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
    </div>
    </body>
</html>

<%-- 
    Document   : View
    Created on : Jul 4, 2018, 11:14:26 PM
    Author     : ccami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dentist.Dentist"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Profile</title>
    </head>
    <body class="navbar navbar2 container-fluid profile">
        
        <!-- get dentist from session -->
        <%Dentist d1 = (Dentist)session.getAttribute("d1");
          d1.Display();
        
        %>
        <!-- navigation bar -->
      <nav class=" navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">Dentist</a>
                </div>
                <ul class="nav navbar-nav float">
                  <li class=""><a href="DentistLogin.jsp">Logout</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row" style="padding-top:100px;">
      
            <!-- view dentist information -->
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
                          <tr>
                            <td>Password:</td>
                            <td><%out.println(d1.getPw());%></td>
                          </tr>  
                          <tr>
                            <td>First name:</td>
                            <td><%out.println(d1.getFn());%></td>
                          </tr>
                          <tr>
                            <td>Last name:</td>
                            <td><%out.println(d1.getLn());%></td>
                          </tr>
                          <tr>
                            <td>Email:</td>
                            <td><%out.println(d1.getEmail());%></td>
                          </tr>
                          <tr>
                            <td>Office:</td>
                            <td><%out.println(d1.getOffice());%></td>
                          </tr>
                        </tbody>
                      </table>
                      <div>
                        <form>
                            <a href="DentistAppointments.jsp" class="btn btn-primary">Appointments</button>
                            <a href="DentistEditProfile.jsp" class="btn btn-primary">Edit Profile</a>
                        </form>
                      
                      
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
    </div>
     <%
         HttpSession ses = request.getSession(true);
         ses.setAttribute("d1", d1);
         System.out.println("Dentist Added to Session");
    %>
    </body>
</html>

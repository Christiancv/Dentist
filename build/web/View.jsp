<%-- 
    Document   : View
    Created on : Jul 4, 2018, 11:14:26 PM
    Author     : ccami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dentist.Patient"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body class="navbar navbar2 container-fluid profile">
        
        
        <%Patient p1 = (Patient)session.getAttribute("p1");
          p1.Display();
        
        %>
      <nav class=" navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">Dentist</a>
                </div>
                <ul class="nav navbar-nav float">
                  <li class=""><a href="#">Profile</a></li>
                </ul>
            </div>
        </nav>
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
                            <td>Password:</td>
                            <td><%out.println(p1.getPatPw());%></td>
                          </tr>  
                          <tr>
                            <td>First name</td>
                            <td><%out.println(p1.getPatfn());%></td>
                          </tr>
                          <tr>
                            <td>Last name:</td>
                            <td><%out.println(p1.getPatln());%></td>
                          </tr>
                          <tr>
                            <td>Address:</td>
                            <td><%out.println(p1.getPataddr());%></td>
                          </tr>
                          <tr>
                            <td>Email:</td>
                            <td><%out.println(p1.getPatemail());%></td>
                          </tr>
                          <tr>
                            <td>Insurance</td>
                            <td><%out.println(p1.getPatinsco());%></td>
                          </tr>
                        </tbody>
                      </table>
                      <div style="padding-left:29%;">
                      <a href="#" class="btn btn-primary">Appointments</a>
                      <a href="#" class="btn btn-primary">Edit Profile</a>
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dentist.Dentist"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body class="navbar navbar2 container-fluid profile">
        
        <!-- get dentist from session -->
        <%Dentist d1 = (Dentist)session.getAttribute("d1");
          d1.Display();
        
        %>
      <nav class=" navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">Patient</a>
                </div>
                <ul class="nav navbar-nav float">
                  <li class=""><a href="DentistLogin.jsp">Logout</a></li>
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
                          <!-- enter the fields to be send to the servlet -->
                       <form  autocomplete="off" Action="http://localhost:8084/Dentist/DentistEditServlet" method="post">
                        <tbody align="center" >
                          <tr>
                            <td>Password:</td>
                            <td><input style="border:0px;" type="text" name="Password" placeholder="<%out.println("         Enter new password");%>"></td>
                          </tr>  
                          <tr>
                            <td>FirstName:</td>
                            <td><input style="border:0px;" type="text" name="fn" placeholder="<%out.println("         Enter new Fistname");%>"></td>
                          </tr>  
                          <tr>
                            <td>LastName:</td>
                            <td><input style="border:0px;" type="text" name="ln" placeholder="<%out.println("         Enter new Lastname");%>"></td>
                          </tr>  
                          <tr>
                            <td>Email:</td>
                            <td><input style="border:0px;" type="text" name="Email" placeholder="<%out.println("             Enter new Email ");%>"></td>
                          </tr>
                          <tr>
                            <td>Office:</td>
                            <td><input style="border:0px;" type="text" name="Office" placeholder="<%out.println("          Enter new Office ");%>"></td>
                          </tr>
                        </tbody>
                        <div style="float:right; padding:10px; ">
                        <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                       </form>
                      </table>
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
          System.out.println("Dentist Added to Session from edit page");
    
      
      %>                     
    </body>
</html>
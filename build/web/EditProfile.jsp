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
                  <a class="navbar-brand" href="#">Patient</a>
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
                  <h3 class="panel-title"><%out.println("Patient ID # " + p1.getPatID());%></h3>
                </div>
                <div class="panel-body">
                  <div class="row">
                    <div class=" col-md-12 col-lg-12 "> 
                      <table class="table table-user-information" >
                       <form  autocomplete="off" Action="http://localhost:8084/Dentist/EditProfileServlet" method="post">
                        <tbody align="center" >
                          <tr>
                            <td>Password:</td>
                            <td><input style="border:0px;" type="text" name="Password" placeholder="<%out.println("         Enter new password");%>"></td>
                          </tr>  
                          <tr>
                            <td>First name:</td>
                            <td><%out.println(p1.getPatfn());%></td></td>
                          </tr>
                          <tr>
                            <td>Last name:</td>
                            <td><%out.println(p1.getPatln());%></td></td>
                          </tr>
                          <tr>
                            <td>Address:</td>
                            <td><input  style="border:0px;" type="text" name="Address" placeholder="<%out.println("           Enter new Address ");%>"></td>
                          </tr>
                          <tr>
                            <td>Email:</td>
                            <td><input style="border:0px;" type="text" name="Email" placeholder="<%out.println("             Enter new Email ");%>"></td>
                          </tr>
                          <tr>
                            <td>Insurance:</td>
                            <td><input style="border:0px;" type="text" name="Insurance" placeholder="<%out.println("          Enter new Insurance ");%>"></td>
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
          ses.setAttribute("p1", p1);
          System.out.println("Patient Added to Session");
    
      
      %>                     
    </body>
</html>
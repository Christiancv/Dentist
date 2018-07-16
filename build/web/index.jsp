<%-- 
    Document   : index
    Created on : Jul 4, 2018, 4:43:22 PM
    Author     : ccami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  
  
  <body class="navbar navbar2 container-fluid bg">
        <nav class=" navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">Patient</a>
                </div>
                <ul class="nav navbar-nav float">
                  <li class=""><a href="#">Home</a></li>
                </ul>
            </div>
        </nav>
      
  <div class="container">
    <div class="row">
        <div class="col-md-12">
            
            <div class="wrap">
                <p class="form-title">
                    Sign In</p>
                <form class="login" autocomplete="off" Action="http://localhost:8084/Dentist/LoginServlet" method="post">
                <input type="text" placeholder="Username" name="Username" />
                <input type="password" placeholder="Password" name="Password" />
                <input type="submit" value="Sign In" class="btn btn-primary btn-sm" />  
                <p align="center"><a style="color:green;" href="DentistLogin.jsp">Dentist login here</a></p>
                </form>
            </div>
        </div>
    </div>
</div>
     
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    
  </body>
</html>

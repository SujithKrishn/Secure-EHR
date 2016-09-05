<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    
    <link rel="stylesheet" href="resources/css/reset.css">

    
        <link rel="stylesheet" href="resources/css/style.css">

    
    
    
  </head>

  <body>

    <div class="contain">
   
</div>
<div class="containmain">
  <div class="center">
  <div class="profile">
    
  </div>
  <div align="center">
 <font color="red"><b>${message}</b></font> 
  </div>
  <form class="form" action="validateLogin" autocomplete="on" method="post">
  <input type="text" class="topform" placeholder="Username" name="loginName"><br>
  <input type="password" class="bottomform" placeholder="Password" name="password"><br>
  <input type="submit">
</form>
    </div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="resources/js/index.js"></script>

    
    
    
  </body>
</html>

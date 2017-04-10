<%-- 
    Document   : login
    Created on : 10-04-2017, 09:07:21
    Author     : Joachim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="FrontController" method="POST">
            <p>E-mail</p>
            <input type="email" name="email" value="" placeholder="Type in your email" required/>
            <p>Password</p>
            <input type="password" name="password" value="" placeholder="Type in your password" required/><br>
            <input type="submit" value="login" name="action"/>
        </form>
    </body>
</html>

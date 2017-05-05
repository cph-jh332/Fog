<%-- 
    Document   : singup
    Created on : 10-04-2017, 09:18:45
    Author     : Joachim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
    </head>
    <body>
        <h1>Signup</h1>
        <form action="FrontController" method="post">
            <p>E-mail</p>
            <input type="email" name="email" value="" placeholder="Type in your email" required/>
            <p>First Name</p>
            <input type="text" name="firstName" value="" placeholder="Type in your first name" required/>
            <p>First Name</p>
            <input type="text" name="lastName" value="" placeholder="Type in your last name" required/>
            <p>Phone</p>
            <input type="tel" name="phone" value="" placeholder="Type in your phone number" pattern=".{8,8}" required/>
            <p>Vejnavn</p>
            <input type="text" name="streetName" placeholder="Type in your street name" required/>
            <p>City</p>
            <input type="text" name="city" placeholder="Type in your city name" required/>
            <p>Postnr.</p>
            <input type="number" name="zipCode" placeholder="Type in you zip code" pattern=".{4,4}" required/>
            <p>Password</p>
            <input type="password" name="password" value="" placeholder="Type in your password" required/><br>
            <input tupe="hidden" name="action" value="signup"/>
            <input type="submit" value="signup"/>
        </form>
    </body>
</html>

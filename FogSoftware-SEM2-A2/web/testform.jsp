<%-- 
    Document   : testform
    Created on : 27-03-2017, 11:37:45
    Author     : Mikkel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test this form</h1>
        
        <form action="FrontController" method="post">
            <input name="magictext">
            <button type="submit" name="action" value="hello">Send</button>
        </form>
        
    </body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        <div class="container">
            
            <h1>Login</h1>
            <form action="FrontController" method="POST">
                <div class="form-group"><input type="email" name="email" value="" class="form-control" placeholder="Type in your email" required/></div>
                <div class="form-group"><input type="password" name="password" value="" class="form-control" placeholder="Type in your password" required/></div>
                <div class="form-group text-right"><input type="submit" value="login" name="action" class="btn btn-primary" /></div>
            </form>
            
        </div>
    </body>
</html>

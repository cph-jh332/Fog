<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Frontpage</title>
        <meta charset="UTF-8">
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6"><h1>Fog Carport frontpage</h1></div>
            <div class="col-md-6 text-right"><a href="login.jsp">Login</a></div>
            
        </div>
        
        <div><c:out value="${message}"/></div>
    </body>
</html>

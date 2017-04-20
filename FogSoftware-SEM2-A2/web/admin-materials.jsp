<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materials</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        
        <c:import url="/inc/admin-nav.jsp"/>
        
        <div class="container">
            <div class="row">
                <h1>Materials</h1>
                
                <hr>

                <c:forEach var="entry" items="${list}">

                    <p><c:out value="${entry}"/></p>
                    <hr>

                </c:forEach>
                    
            </div>
        </div>

    </body>
</html>

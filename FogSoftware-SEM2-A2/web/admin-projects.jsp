<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All projects</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>

        <c:import url="/inc/admin-nav.jsp"/>

        <div class="container">
            <div class="row">
                <h1>Projects</h1>

                <hr>
                <c:forEach var="entry" items="${list}">
                    <a href="admin-projectpage.jsp">
                        <p>&rsaquo; 
                            <c:out value="${entry.getOrder_id()}"/> - 
                            <c:out value="${entry.getUser_id()}"/> - 
                            <c:out value="${entry.getOrder_date()}"/> - 
                            <c:out value="${entry.getOrder_title()}"/>
                        </p>
                    </a>
                </c:forEach>

            </div>
        </div>

        <script>
            // Active page nav bold
            document.getElementById("admin-nav-projects").style.fontWeight = "bold";
        </script>
        
    </body>
</html>

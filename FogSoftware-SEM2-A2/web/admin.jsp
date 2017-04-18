<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>

        <c:import url="/inc/admin-nav.jsp"/>

        <div class="container">
            <div class="row">

                <div class="col-md-6">
                    <div class="col-md-12 col-border">
                        <h3>New incoming carport projects</h3>
                        <c:forEach var="entry" items="${list}">
                            <a href="">
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
                <div class="col-md-6">
                    <div class="col-md-12 col-border">
                        <p>Right pane</p>
                    </div>
                </div>
            </div>




        </div>

        <script>
            // Active page nav bold
            document.getElementById("admin-nav-home").style.fontWeight = "bold";
        </script>

    </body>
</html>

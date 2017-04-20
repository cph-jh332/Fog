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
                        <h3>Top 10 new incoming carport projects</h3>
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
                <div class="col-md-6">
                    <div class="col-md-12 col-border">
                        <h3>Add new materials</h3>
                        <hr>
                        <form action="FrontController" method="POST">
                            <div class="form-group"><input type="text" class="form-control" placeholder="Type material name here..."></div>
                            <div class="form-group text-right"><button type="submit" name="action" value="add-material" class="btn btn-primary">Add material</button></div>
                        </form>
                        
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

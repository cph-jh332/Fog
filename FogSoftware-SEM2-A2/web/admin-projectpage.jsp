<%@page import="backend.Material"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport project page</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>

        <c:import url="/inc/admin-nav.jsp"/>

        <div class="container">
            <div class="row">
                <h1>Carport project page</h1>

                <div class="table">
                    <div class="table-title">
                        <p>Stykliste til carport</p>
                    </div>
                    <div class="table-heading">
                        <div class="table-cell">
                            <p>ID</p>
                        </div>
                        <div class="table-cell">
                            <p>Materiale</p>
                        </div>
                        <div class="table-cell">
                            <p>Antal</p>
                        </div>
                        <div class="table-cell">
                            <p>Enhed</p>
                        </div>
                    </div>


                    <c:forEach var="entry" items="${materials}">
                        <div class="table-row">

                            <div class="table-cell"><c:out value="${entry.getID()}"/></div>
                            <div class="table-cell"><c:out value="${entry.getName()}"/></div>
                            <div class="table-cell"><c:out value="${entry.getAmount()}"/></div>
                            <div class="table-cell">Stk.</div>

                        </div>
                    </c:forEach>



                </div>

            </div>
        </div>
        <c:import url="/carport-2d.jsp"/>

    </body>
</html>

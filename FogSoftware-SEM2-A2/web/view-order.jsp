<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport 2D</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        <div class="container text-center">
            <c:import url="/inc/carport-2d.jsp"/>
            <c:if test="${user != null}">
                <div>
                <a href="?action=order&width=<c:out value="${width}"/>&length=<c:out value="${length}"/>">order</a>
                </div>
            </c:if>
            <c:if test="${user == null}">
                <form action="login.jsp">
                    <input type="submit" value="Login to Order">
                </form>
            </c:if>
        </div>

    </body>
</html>
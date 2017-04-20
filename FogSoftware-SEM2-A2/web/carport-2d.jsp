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
            <h1>Carport 2D SVG drawing</h1>
            <p hidden id="carport_length"><c:out value="${length}"/></p>
            <p hidden id="carport_width"><c:out value="${width}"/></p>
            <p hidden id="pillars"><c:out value="${pillars}"/></p>
            <p hidden id="rafters"><c:out value="${rafters}"/></p>

            <h2>Top-view</h2>
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_top"></svg>
            <h2>Side-view</h2>
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_side"></svg>
            <h2>Front-view</h2>
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_front"></svg>

            <script src="js/carport_top.js"></script>
            <script src="js/carport_side.js"></script>
            <script src="js/carport_front.js"></script>
            <c:if test="${user != null}">
                <form action="FrontCrontoller">
                    <input type="hidden" name="width" value="<c:out value="${width}"/>">
                    <input type="hidden" name="length" value="<c:out value="${length}"/>">
                    <input type="submit" value="order" name="action">
                </form>
            </c:if>
            <c:if test="${user == null}">
                <form action="login.jsp">
                    <input type="submit" value="Login to Order">
                </form>
            </c:if>
        </div>

    </body>
</html>

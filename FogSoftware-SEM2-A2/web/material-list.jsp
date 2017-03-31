<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Result</h1>
        <h1>Pillars</h1>
        <p><c:out value="${pillars}"/></p><hr>
        <h1>Rafters</h1>
        <p><c:out value="${rafters}"/></p><hr>
        <h1>Shed Boards</h1>
        <p><c:out value="${shedBoards}"/></p><hr>
        <h1>Understern</h1>
        <c:forEach var="entry" items="${understern}">
            <p><c:out value ="${entry}"/></p>
        </c:forEach>
        <h1>Overstern</h1>
        <c:forEach var="entry" items="${overstern}">
            <p><c:out value ="${entry}"/></p>
        </c:forEach>
        <h1>Roof Tiles</h1>
        <c:forEach var="entry" items="${roofTiles}">
            <p><c:out value ="${entry}"/></p>
        </c:forEach>
        <h1>Water Boards</h1>
        <c:forEach var="entry" items="${waterBoards}">
            <p><c:out value ="${entry}"/></p>
        </c:forEach>
    </body>
</html>
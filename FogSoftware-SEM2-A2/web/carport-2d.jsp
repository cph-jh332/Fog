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
            <p hidden id="carport_length">780</p>
            <p hidden id="carport_width">300</p>

            <h2>Top-view</h2>
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_top"></svg>
            <h2>Side-view</h2>
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_side"></svg>
            <h2>Front-view</h2>
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_front"></svg>

            <script src="js/carport_top.js"></script>
            <script src="js/carport_side.js"></script>
            <script src="js/carport_front.js"></script>
        </div>

    </body>
</html>

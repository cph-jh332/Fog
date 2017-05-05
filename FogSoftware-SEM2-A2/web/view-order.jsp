<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="3D/TemplateData/style.css">
        <link rel="shortcut icon" href="3D/TemplateData/favicon.ico" />
        <script src="3D/TemplateData/UnityProgress.js"></script>
        <title>Carport 2D</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        <div class="container text-center">
            <c:import url="/inc/carport-2d.jsp"/>

            <div class="template-wrap clear">
                <canvas class="emscripten" id="canvas" oncontextmenu="event.preventDefault()" height="600px" width="960px"></canvas>
                <br>
                <div class="logo"></div>
                <div class="fullscreen"><img src="3D/TemplateData/fullscreen.png" width="38" height="38" alt="Fullscreen" title="Fullscreen" onclick="SetFullscreen(1);" /></div>
                <div class="title">Fog 3D</div>
            </div>
            <script type='text/javascript'>
                var Module = {
                    TOTAL_MEMORY: 268435456,
                    errorhandler: null, // arguments: err, url, line. This function must return 'true' if the error is handled, otherwise 'false'
                    compatibilitycheck: null,
                    backgroundColor: "#222C36",
                    splashStyle: "Light",
                    dataUrl: "3D/Development/Desktop.data",
                    codeUrl: "3D/Development/Desktop.js",
                    asmUrl: "3D/Development/Desktop.asm.js",
                    memUrl: "3D/Development/Desktop.mem",
                };
            </script>
            <script src="3D/Development/UnityLoader.js"></script>


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
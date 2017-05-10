<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="TemplateData/style.css">
        <link rel="shortcut icon" href="TemplateData/favicon.ico" />
        <script src="TemplateData/UnityProgress.js"></script>
        <title>Carport 2D</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>

        <div class="toolbar">
            <c:import url="/inc/header.jsp"/>
        </div>

        <div class="container text-center">


            <div class="row">
                <c:import url="/inc/carport-2d.jsp"/>
            </div>

            <div class="row text-center">
                <h3>3D tegning</h3>
                <canvas class="emscripten" id="canvas" oncontextmenu="event.preventDefault()" height="600px" width="1170px"></canvas>
                <br>
                <div class="logo"></div>
                <div class="fullscreen"><img src="TemplateData/fullscreen.png" width="38" height="38" alt="Fullscreen" title="Fullscreen" onclick="SetFullscreen(1);" /></div>
                <div class="title">Fog 3D</div>

                <script type='text/javascript'>
                    var Module = {
                        TOTAL_MEMORY: 268435456,
                        errorhandler: null, // arguments: err, url, line. This function must return 'true' if the error is handled, otherwise 'false'
                        compatibilitycheck: null,
                        backgroundColor: "#222C36",
                        splashStyle: "Light",
                        dataUrl: "Release/3D.data",
                        codeUrl: "Release/3D.js",
                        asmUrl: "Release/3D.asm.js",
                        memUrl: "Release/3D.mem",
                    };
                </script>
                <script src="Release/UnityLoader.js"></script>
            </div>

            <c:if test="${user != null}">
                <div>
                    <a href="?action=order&width=<c:out value="${width}"/>&length=<c:out value="${length}"/>" class="fog-button">Opret carport projekt</a>
                </div>
            </c:if>
            <c:if test="${user == null}">             
                <a href="#" class="login-button fog-button">Login for at bestille</a>
            </c:if>

        </div>

        <c:import url="/inc/footer.jsp"/>
    </body>
</html>
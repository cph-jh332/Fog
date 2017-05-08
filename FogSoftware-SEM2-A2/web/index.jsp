<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Frontpage</title>
        <meta charset="UTF-8">
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>

        <div class="message-container">
            <div><c:out value="${message}"/></div>
        </div>


        <div class="front-page-header">
            <c:import url="/inc/header.jsp"/>
            
            <div class="text-center">
                <h1>Velkommen til Fog Custom Carporte</h1>
                <h3>Byg din carport efter egne m�l</h3>
                <h3>V�lg f�rst typen af tag herunder:</h3>
            </div>
        </div>

        <div class="front-page-colorcolumns">
            
            <img src="img/fog-logo.png" class="logo" id="logo">
            
            <div class="hide-on-site" id="create-carport-fields">
                <c:import url="/inc/create-carport.jsp"/>
            </div>

            <div class="fog-pink-column left text-center" id="left-pane"><a href="#" id="flat-roof-button">Fladt tag</a></div>
            <div class="fog-blue-column right text-center" id="right-pane"><a href="#" id="trapez-roof-button">Trapez tag</a></div>
        </div>
            

        <div class="container front-columns">
            <div class="row">
                <div class="col-md-4">
                    <h3>1. V�lg tag</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <div class="col-md-4">
                    <h3>2. V�lg l�ngde/bredde</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores</p>
                </div>
                <div class="col-md-4">
                    <h3>3. F� godkendelse hos kommunen</h3>
                    <p>Ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis</p>
                </div>
            </div>
        </div>


        <c:import url="/inc/footer.jsp"/>

        <script src="js/frontpage.js"></script>


    </body>
</html>

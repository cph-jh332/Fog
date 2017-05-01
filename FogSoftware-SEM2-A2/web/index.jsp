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

        <div class="row text-center front-page-top ">
            <div class="container toolbar">
                <div class="col-md-12 text-right">
                    <c:if test="${user == null}">
                        <p><a href="login.jsp">Login</a> | <a href="signup.jsp">Signup</a></p>
                    </c:if>
                    <c:if test="${user != null}">
                        <a href="?action=logout">Logout</a>
                    </c:if>

                </div>
            </div>
            
            <h1>Velkommen til Fog Custom Carporte</h1>
            <h3>Byg din carport efter egne mål</h3>
            <h3>Vælg først typen af tag herunder:</h3>
        </div>

        <div class="row front-page-colorcolumns">
            <div class="fog-pink-column left text-center"><a href="create-carport.jsp">Fladt tag</a></div>
            <div class="fog-blue-column right text-center"><a href="#">Trapez tag</a></div>
        </div>
        
        <div class="row">
            <div class="container">
                <div class="col-md-4">
                    <h3>1. Vælg tag</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <div class="col-md-4">
                    <h3>2. Vælg højde/bredde</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores</p>
                </div>
                <div class="col-md-4">
                    <h3>3. Få godkendelse hos kommunen</h3>
                    <p>Ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis</p>
                </div>
            </div>
        </div>

        <c:import url="/inc/footer.jsp"/>


    </body>
</html>

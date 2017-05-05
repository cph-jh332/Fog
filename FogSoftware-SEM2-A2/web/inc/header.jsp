<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container header-page-top">
    
    <a href="index.jsp"><img src="img/fog-logo.png" class="logo"></a>
    
    <div class="row">
        <div class="col-md-12 text-right">
            <c:if test="${user == null}">
                <a href="login.jsp">Login</a> | <a href="signup.jsp">Opret bruger</a>
            </c:if>
            <c:if test="${user != null}">
                <a href="?action=logout">Logout</a>
            </c:if>
        </div>
    </div>
</div>
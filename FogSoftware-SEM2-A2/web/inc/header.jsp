<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container header-page-top">

    <a href="index.jsp"><img src="img/fog-logo.png" class="logo"></a>

    <div class="row">
        <div class="col-md-12 text-right">
            <c:if test="${user == null}">
                <a href="#" class="login-button">Login</a> | <a href="#" id="signup-button">Opret bruger</a>
                <script>
                    function showSignup() {
                        popupSignup.style.display = "block";
                    }
                    
                    let signupButton = document.getElementById("signup-button");
                    signupButton.addEventListener("click", showSignup);
                </script>
            </c:if>
            <c:if test="${user != null}">
                <a href="?action=logout">Logout</a>
            </c:if>
        </div>
    </div>
</div>
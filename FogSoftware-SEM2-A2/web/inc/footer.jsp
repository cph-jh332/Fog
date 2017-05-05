<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer id="footer">
    <div class="row">
        <div class="container">
            <div class="col-md-12 text-center">
                <p>Footer</p>
            </div>
        </div>
    </div>
</footer>

<section class="popup-container hide-on-site" id="login-popup">
    <div class="popup-content">
        <c:import url="/inc/login.jsp"/>
    </div>
</section>
    
<section class="popup-container hide-on-site" id="signup-popup">
    <div class="popup-content">
        <c:import url="/inc/signup.jsp"/>
    </div>
</section>

<script src="js/global.js"></script>
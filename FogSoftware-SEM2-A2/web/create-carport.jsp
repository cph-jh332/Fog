<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create carport</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        <div class="container">
            <h1>Create carport</h1>
            <form action="FrontController" method="post">
                <div class="form-group"><input type="number" name="length" placeholder="Please type length in cm..." class="form-control" min="390" max="1170" required></div>
                <div class="form-group"><input type="number" name="width" placeholder="Please type width in cm..." class="form-control" min="300" max="900" required></div>
                <button type="submit" value="create_carport" name="action" class="btn btn-primary">Create carport</button>
            </form>
        </div>
    </body>
</html>

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
                <div class="form-group"><input type="text" name="width" placeholder="Please type width in cm..." class="form-control"></div>
                <div class="form-group"><input type="text" name="length" placeholder="Please type length in cm..." class="form-control"></div>

                <button type="submit" value="create_carport" name="action" class="btn btn-primary">Create carport</button>
            </form>
        </div>
    </body>
</html>

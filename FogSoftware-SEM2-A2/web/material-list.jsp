<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="/inc/head.jsp"/>
        <link rel="stylesheet" type="text/css" href="css/material_list_stylesheet.css">
    </head>
    <body>
        <p>Højde: </p><c:out value="${length}"/><p id="carport_length"></p>
        <p>Bredde: </p><c:out value="${width}"/><p id="carport_width"></p>

        <div class="Table">
            <div class="Title">
                <p>Stykliste til carport</p>
            </div>
            <div class="Heading">
                <div class="Cell">
                    <p>Materiale</p>
                </div>
                <div class="Cell">
                    <p>Længde</p>
                </div>
                <div class="Cell">
                    <p>Antal</p>
                </div>
                <div class="Cell">
                    <p>Enhed</p>
                </div>
            </div>
            <%
                for (String str : (ArrayList<String>)request.getAttribute("materialList"))
                {
                    String[] materialData = str.split("_");
                    %> <div class="Row"> <%
                    for (String data : materialData)
                    {
                        %>
                        <div class="Cell">
                            <p><%out.println(data);%></p>
                        </div>
                        <%
                    }
                    %> </div> <%
                }
            %>
        </div>
    </body>
</html>
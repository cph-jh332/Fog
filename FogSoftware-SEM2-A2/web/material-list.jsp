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
        <div class="container">
            <h1>Carport output</h1>
            <p>Længde: <span id="carport_length"><c:out value="${length}"/></span> x Bredde: <c:out value="${width}"/><span id="carport_width"></span></p>

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
            
            <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport"></svg> 

            <script src="js/svg.js"></script>
            
        </div>
    </body>
</html>
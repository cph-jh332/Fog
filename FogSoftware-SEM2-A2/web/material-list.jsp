<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        <div class="container">
            <h1>Carport output</h1>
            <p>Længde: <span id="carport_length"><c:out value="${length}"/></span> x Bredde: <c:out value="${width}"/><span id="carport_width"></span></p>

            <div class="table">
                <div class="table-title">
                    <p>Stykliste til carport</p>
                </div>
                <div class="table-heading">
                    <div class="table-cell">
                        <p>Materiale</p>
                    </div>
                    <div class="table-cell">
                        <p>Længde</p>
                    </div>
                    <div class="table-cell">
                        <p>Antal</p>
                    </div>
                    <div class="table-cell">
                        <p>Enhed</p>
                    </div>
                </div>
                <%
                    for (String str : (ArrayList<String>)request.getAttribute("materialList"))
                    {
                        String[] materialData = str.split("_");
                        %> <div class="table-row"> <%
                        for (String data : materialData)
                        {
                            %>
                            <div class="table-cell">
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
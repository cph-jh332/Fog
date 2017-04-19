<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport project page</title>
        <c:import url="/inc/head.jsp"/>
    </head>
    <body>
        
        <c:import url="/inc/admin-nav.jsp"/>
        
        <div class="container">
            <div class="row">
                <h1>Carport project page</h1>
                
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
                
            </div>
        </div>
        
    </body>
</html>

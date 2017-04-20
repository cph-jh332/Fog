<%@page import="backend.Material"%>
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
                            <p>L�ngde</p>
                        </div>
                        <div class="table-cell">
                            <p>Antal</p>
                        </div>
                        <div class="table-cell">
                            <p>Enhed</p>
                        </div>
                    </div>
                                    
                         <c:forEach var="entry" items="${list}">
                             <div>
                                
                                    <c:out value="${entry.getID()}"/> - 
                                    <c:out value="${entry.getName()}"/> - 
                                    <c:out value="${entry.getAmount}"/> 
                                
                            <div/>
                        </c:forEach>
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                    <%
                     
                                
                                
                                
                                
                                
                        for (Material m : (ArrayList<Material>)request.getAttribute("materials"))
                        {
                            
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

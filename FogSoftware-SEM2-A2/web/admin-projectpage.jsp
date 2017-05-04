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
                
                <div class="col-md-12 text-center">
                    <h3 class="text-center">Progress:</h3>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" role="progressbar" baria-valuenow="<c:out value="${orderProgress}"/>" aria-valuemin="0" aria-valuemax="100" style="width: <c:out value="${orderProgress}"/>%;">
                            <c:out value="${orderProgress}"/>%
                        </div>
                    </div>
                    <div class="btn-group" role="group" aria-label="...">
                        <c:if test="${!hasCalled}">
                            <form action="FrontController" method="GET" class="admin-inline-form">
                                <input type="hidden" name="action" value="updateHasCalled">
                                <input type="hidden" name="hasCalled" value="true">
                                <input type="hidden" name="orderID" value="<c:out value="${orderID}"/>">
                                <button class="btn btn-primary" type="submit">Har ringet til kunden</button>
                            </form>
                        </c:if>
                        <c:if test="${hasCalled}">
                            <form action="FrontController" method="GET" class="admin-inline-form">
                                <input type="hidden" name="action" value="updateHasCalled">
                                <input type="hidden" name="hasCalled" value="false">
                                <input type="hidden" name="orderID" value="<c:out value="${orderID}"/>">
                                <button class="btn btn-primary" type="submit">Har ikke ringet til kunden</button>
                            </form>
                        </c:if>
                        <c:if test="${!customerConfirmed}">
                            <form action="FrontController" method="GET" class="admin-inline-form">
                                <input type="hidden" name="action" value="updateCustomerConfirmed">
                                <input type="hidden" name="customerConfirmed" value="true">
                                <input type="hidden" name="orderID" value="<c:out value="${orderID}"/>">
                                <button class="btn btn-primary" type="submit">Kunde har accpeteret tilbuddet</button>
                            </form>
                        </c:if>
                        <c:if test="${customerConfirmed}">
                            <form action="FrontController" method="GET" class="admin-inline-form">
                                <input type="hidden" name="action" value="updateCustomerConfirmed">
                                <input type="hidden" name="customerConfirmed" value="false">
                                <input type="hidden" name="orderID" value="<c:out value="${orderID}"/>">
                                <button class="btn btn-primary" type="submit">Kunde har ikke accpeteret tilbuddet</button>
                            </form>
                        </c:if>
                    </div>
                </div>

            </div>
                        
            <hr>

            <div class="row">
                <div class="col-md-6">
                    <div class="table">
                        <div class="table-title">
                            <h3>Stykliste til carport</h3>
                        </div>
                        <div class="table-heading">
                            <div class="table-cell">
                                <p>ID</p>
                            </div>
                            <div class="table-cell">
                                <p>Materiale</p>
                            </div>
                            <div class="table-cell">
                                <p>Antal</p>
                            </div>
                            <div class="table-cell">
                                <p>Enhed</p>
                            </div>
                        </div>


                        <c:forEach var="entry" items="${materials}">
                            <div class="table-row">

                                <div class="table-cell"><c:out value="${entry.getID()}"/></div>
                                <div class="table-cell"><c:out value="${entry.getName()}"/></div>
                                <div class="table-cell"><c:out value="${entry.getAmount()}"/></div>
                                <div class="table-cell">Stk.</div>

                            </div>
                        </c:forEach>



                    </div>                    
                </div>
                <div class="col-md-6">
                    <h3>Kundedata</h3>
                    <p>Navn: Hansen Jensen</p>
                    <p>Osv: ...</p>
                </div>
            </div>




            <c:import url="/inc/carport-2d.jsp"/>

        </div>

    </body>
</html>


<%-- 
    Document   : welcome
    Created on : Dec 24, 2019, 8:42:38 PM
    Author     : sanhpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRJ321x</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <header class="masthead text-center text-white">
            <div class="masthead-content">
                <div class="container">
                    <%if (account != null) {%>

                    <h1>Welcome back</h1>
                    <%} else {%>
                    <h1>Welcome to the board</h1>
                    <%}%>
                </div>
            </div>
        </header>
    </body>
    <%@include file="footer.jsp" %>
</html>

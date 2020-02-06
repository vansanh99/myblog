<%-- 
    Document   : index
    Created on : Dec 16, 2019, 11:53:22 PM
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
        <% if (account != null) {%>
        <header class="masthead text-center text-white">
            <div class="container">
                <h1><a href="controller?action=profile">profile.jsp</h1>
                <h2> <a href="controller?action=count">userCounter.jsp</h2>
            </div>
        </header>
        <% } else {
                response.sendRedirect("login.jsp");
            }%>
    </body>
    <%@include file="footer.jsp" %>
</html>

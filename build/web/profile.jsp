<%-- 
    Document   : logged-in
    Created on : Dec 17, 2019, 10:32:16 AM
    Author     : sanhpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inform</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <header class="masthead text-center text-white">
            <div class="masthead-content">
                <div class="container">
                    <% if (account != null) {%>
                    <h1 class="masthead-heading mb-0">Hello <%=account.getUsername()%> ,</h1>
                    <h2 class="masthead-content mb-0">Congrats! You have logged in.</h2>
                    <%} else {
                            response.sendRedirect("login.jsp");
                        }%>
                </div>
            </div>
        </header>
    </body>
    <%@include file="footer.jsp" %>
</html>

<%-- 
    Document   : userCounter
    Created on : Dec 23, 2019, 1:16:49 AM
    Author     : sanhpv
--%>

<%@page import="dal.SessionCounter"%>
<%@page import="java.util.Map"%>
<%@page import="dal.validate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Counter</title>
        <%@include file="/header.jsp" %>
    </head>
    <body>
        <div class="container body-p">
            <%if (account != null) {
                    DBContext db = new DBCon
                    SessionCounter counter = (SessionCounter) session.getAttribute(SessionCounter.COUNTER);%>
            Online User: <%= counter.getActiveSessionNumber()%> </br>
            Total account = <%= hm.size()%>
            <div class="col-4">
                <% for (Map.Entry m : hm.entrySet()) {%>
                <div class="col border"><%= m.getKey()%></div>
                <% }%>
            </div>
            <% } else {
                    response.sendRedirect("controller?action=login");
                }%>
        </div>
    </body>
    <%@include file="/footer.jsp" %>
</html>

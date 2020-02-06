<%-- 
    Document   : login
    Created on : Dec 16, 2019, 11:57:37 PM
    Author     : sanhpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="header.jsp" %>
        <meta name="viewport" content="width=device-width, initial-scale=0">
    </head>
    <body>
        <%if (account == null) {%>
        <div class="container login-container">
            <div class="row justify-content-md-center">
                <div class="col-md-6 login-form-2">
                    <h3>Login</h3>
                    <form action="login" method="POST">
                        <input type="hidden" name="action" value="dologin" />
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Your Username *" name="username" value="<%= (request.getAttribute("username") == null) ? "" : request.getAttribute("username")%>" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Your Password *" name="password" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>
                    </form>
                    <% if (request.getAttribute("mess") != null) {%>
                    <div class="alert alert-danger" role="alert">
                        <%= request.getAttribute("mess")%>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
        <%} else {
                response.sendRedirect("controller?action=index");
            }%>
    </body>
    <%@include file="footer.jsp" %>
</html>

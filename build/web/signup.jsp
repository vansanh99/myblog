<%-- 
    Document   : CourseForm.jsp
    Created on : Dec 17, 2019, 10:15:27 PM
    Author     : sanhpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Form</title>
        <%@include file="header.jsp" %>
        <meta name="viewport" content="width=device-width, initial-scale=0">
    </head>
    <body>
        <div class="container login-container">
            <div class="row justify-content-md-center">
                <div class="col-md-6 login-form-1">
                    <h3>Registration</h3>
                    <form action="signup" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Your Userame *" name="username" value="<%= (request.getAttribute("username") == null) ? "" : request.getAttribute("username")%>" />
                            <% if (request.getAttribute("errName") != null) {%>
                            <div class="alert alert-danger" role="alert">
                                <%= request.getAttribute("errName")%>
                            </div>
                            <%}%> 
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Your Password *" name="password" value="" />
                            <% if (request.getAttribute("errPass") != null) {%>
                            <div class="alert alert-danger" role="alert">
                                <%= request.getAttribute("errPass")%>
                            </div>
                            <%}%>
                        </div>
                        <div class="form-row">
                            <input type="submit" class="btnSubmit col-3" value="Register" />
                            <a href="controller?action=home" class="btn btn-secondary rounded-pill col-3">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

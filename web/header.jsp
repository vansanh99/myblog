<%@page import="java.util.HashMap"%>
<%@page import="model.Account"%>
<%
    Account account = (Account) session.getAttribute("account");
%>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="fonts/myCatamaran.css" rel="stylesheet">
<link href="fonts/myLato.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/one-page-wonder.css" rel="stylesheet">

<script src="ajax/libs/jquery/jquery.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
    <div class="container">
        <div class="navbar-brand">Project 2</div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="controller?action=home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?action=index">Index</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=<%= (account == null) ? "\"controller?action=login\">Login" : "\"logout\">Logout"%></a>
                </li>
                <% if (account == null) {%>
                <li class="nav-item">
                    <a class="nav-link" href="controller?action=signup">Sign Up</a>
                </li>
                <%}%>
            </ul>
        </div>
    </div>
</nav>


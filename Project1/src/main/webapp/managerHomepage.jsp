<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Homepage</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ page import="com.revature.pojo.User" %>
<% User user = (User) session.getAttribute("user");
	
	if(user == null){
		response.sendRedirect("error.jsp");
	}
	
	/*
	
	<UL>
	
	<li><a href="ResolvedRequests">View All Resolved Requests</a></li>
	<li><a href="pendingRequests">View All Pending Requests</a></li>
	<li><a href="getEmployees">View All Employees</a></li>
	<li><a href="logout">Log out</a></li>
	</UL>
	
	
	*/
	
	

%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Shaolin Monk Reimbursement System</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="ResolvedRequests">View All Resolved Requests<span class="sr-only">(current)</span></a></li>
        <li><a href="pendingRequests">View All Pending Requests</a></li>
        <li><a href="getEmployees">View All Employees</a></li>
        <li><a href="logout">Log out</a></li>   
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<h1 class="shao_yellow">Manager Homepage</h1>




</body>
</html>
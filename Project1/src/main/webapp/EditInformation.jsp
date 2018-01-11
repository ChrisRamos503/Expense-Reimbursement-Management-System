<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Information</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ page import="com.revature.pojo.User" %>
<% User user = (User) session.getAttribute("user");
	
	if(user == null){
		response.sendRedirect("error.jsp");
	}

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
        <li><a href="viewInformation.jsp">View Information</a></li>
        <li><a href="EditInformation.jsp">Edit Information</a></li>
        <li><a href="pendingRequests">Pending Requests</a></li>
        <li><a href="ResolvedRequests">Resolved Requests</a></li>
        <li><a href="CreateRequest.jsp">CreateRequests</a></li>
        <li><a href="logout">Log out</a></li>   
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<h1 class="shao_yellow">Edit Your Information:</h1>
<!-- form submitted to servlet -->


<div class="shao_gray">
	<form method="POST" action="updateEmployee">
		Username:  <input type="text" name="username" ><BR>
		Password:  &nbsp;<input type="text" name="password" ><BR>
		FirstName: <input type="text" name="firstname" ><BR>
		LastName:  <input type="text" name="lastname" ><BR>
		Email:     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" ><BR>
		<input type="submit" value="submit">
	</form>
</div>


</body>
</html>
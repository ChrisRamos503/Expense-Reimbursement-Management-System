<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.revature.pojo.Reimbursement" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.revature.util.BusinessUtil" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resolved Requests</title>


<script type="text/javascript" src="js/ajax_pic.js">
</script>

</head>
<%@ include file="header.jsp" %>
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

<h1 class="shao_yellow">Resolved Requests</h1>

	<% 
		ArrayList<Reimbursement> list = (ArrayList<Reimbursement>) session.getAttribute("list");
	%>

	<table>
		
		<tr>
			<th>Id</th>
			<th>Amount</th>
			<th>Description</th>
			<th>Submitted</th>
			<th>Resolved</th>
			<th>Author</th>
			<th>Resolver</th>
			<th>Type</th>
			<th>Status</th>
			<th>View Image</th>
		</tr>
		
		
		<tr>
		
		<c:forEach var="item" items="${list}">
	   	<TR>
		    <TD>${item.getId()}</TD>
		    <TD>$${item.getAmount()}</TD>
		    <TD>${item.getDescription()}</TD>
		    <TD>${item.getSubmitted()}</TD>
			<TD>${item.getResolved()}</TD>
		    <TD>${item.getAuthor()}</TD>
		    <TD>${item.getResolver()}</TD>
		    <TD>${bu.returnType(item.getType())}</TD>
	    	<TD>${bu.returnStatus(item.getStatus())}</TD>
		    <TD><input type="button" onclick="getImg(${item.getId()})" value="image" id="${item.getId()}" name="${item.getId()}"> </TD>
		</TR>
	    </c:forEach>
	    
		</tr>
		
	</table>
<div id="receipt">

</div>
</body>
</html>
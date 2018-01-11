<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.revature.pojo.User" %>
<%@ page import="com.revature.pojo.Reimbursement" %>
<%@ page import="com.revature.dao.DAOReimbursement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.revature.util.BusinessUtil" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/ajax_pic.js">

</script>


<title>Viewing one Employee</title>

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
        <li><a href="ResolvedRequests">View All Resolved Requests<span class="sr-only">(current)</span></a></li>
        <li><a href="pendingRequests">View All Pending Requests</a></li>
        <li><a href="getEmployees">View All Employees</a></li>
        <li><a href="logout">Log out</a></li>   
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<h1 class="shao_yellow">Viewing Employees Request's</h1>

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
		<th>Image</th>
	</tr>
	
	
	<!--  item is reimbursement -->
	<c:forEach var="item" items="${emp_req_list}">
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
    
	
</table>

<div id="receipt">

</div>


</body>
</html>
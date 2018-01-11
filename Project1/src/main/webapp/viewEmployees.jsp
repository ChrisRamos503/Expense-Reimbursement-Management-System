<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.revature.pojo.User" %>
<%@ page import="com.revature.pojo.Reimbursement" %>
<%@ page import="com.revature.dao.DAOReimbursement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.Long" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee info</title>

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



<h1 class="shao_yellow">Viewing All Employees</h1>

<% 

	/*
	ArrayList<User> list = (ArrayList<User>) session.getAttribute("emp_list");

	System.out.println(list == null);

	System.out.println(list.size());
	
	System.out.println(list.get(0).getFirstname());
	
	<c:set var="id" value="${new Long(item.getId()).toString()}"/>
	
	value="<c:out value="${param.email}"/>"
	
	*/
%>


<table>
	
	<tr>
		<th>Id</th>
		<th>Username</th>
		<th>Password</th>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>eMail</th>
	</tr>
	
	<c:forEach var="item" items="${emp_list}">
		<tr>
			<td> <form method="POST" action="viewOneEmployee" > 

					<input type="submit" value="${item.getId()}"/>
					<input type="hidden" id="h_id" name="h_id" 
					value="<c:out value='${item.getId()}'/>" >
				 </form>
			 
			</td>
			<td>${item.getUsername()}</td>
			<td>${item.getPassword()}</td>
			<td>${item.getFirstname()}</td>
			<td>${item.getLastname()}</td>
			<td>${item.geteMail()}</td>
		</tr>
	</c:forEach>
	
	


</table>


</body>
</html>
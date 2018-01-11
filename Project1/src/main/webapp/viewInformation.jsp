<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.revature.pojo.User" %>
<%@ page import="com.revature.dao.DAOUser" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View ERS Information</title>

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

<h1 class="shao_yellow">View Your Information:</h1>


	<c:set var="test2" value="whoooooo" />
    <!--  c:out value="${test2}" escapeXml="false" --> 
    
    <% 
    	//session.setAttribute("name", "Chris Ramos"); 
    
    if(session.getAttribute("user") == null){
    
    	/*User user = new User(1,"username","pass","Chris"
    			,"Ramos","Chris_Ramos_34@yahoo.com",2);
    	
    	DAOUser daou = new DAOUser();
    	
    	daou.updateUser(user);
    	
    	
    	//user.setPassword("passwird");
    	session.setAttribute("user", user);*/
    }
    
    
    %>
    
    <c:out value="<br><BR>" escapeXml="false"/>
    
    <div class="shao_gray">
    
    <c:out value="FirstName: &nbsp;${user.getFirstname()} <br>" escapeXml="false"/>
    <c:out value="LastName: &nbsp;${user.getLastname() } <br>" escapeXml="false"/>
    <c:out value="UserName: ${user.getUsername()} <br>" escapeXml="false"/>
    <c:out value="Password: &nbsp;&nbsp;${user.getPassword()} <br>" escapeXml="false"/>
    <c:out value="email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${user.geteMail()} <br>" escapeXml="false"/>
    
    </div>
 <!--  
    
    c:out 
    value="${name} puertorican <BR>" escapeXml="false" 
    c:out 
    value= "${user.getPassword()} <BR>" escapeXml="false" 
 -->
    
    
    
</body>
</html>
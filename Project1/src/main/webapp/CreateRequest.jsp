<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreateRequest</title>

<script type="text/javascript">

	function test(){
		
		var tag = document.getElementById("FileID");
		alert("the value of file is: " + tag.value);
		
	}
	
	
	
</script>

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

<h1 class="shao_yellow">Create Request</h1>


<div class="shao_gray">
	<form enctype="multipart/form-data" action="submitRequest" method="POST">
		Amount: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="amount"/><BR>
		Description:&nbsp;&nbsp;<input type="text" name="description"/><BR>
		Type:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		<select name="type"><BR>
						<option value="1">Travel</option>
						<option value="2">Food</option>
						<option value="3">Lodging</option>
						<option value="4">Misc</option>
					</select><BR>		<br>
					<input type="file" id="fileID" name="fileID" accept="image/*" /><BR><BR>
		<br>
		<input type="submit" onclick="test()"value="submit"/>
	
	</form>
</div>
	
</body>
</html>
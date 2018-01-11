<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- for prettiness -->


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<!-- remember to put single quotes into img src tag -->

<%@ include file="header.jsp" %>
</head>
<body>
	<h1 class="shao_yellow">Login for Shaolin Monk Reimbursements</h1>
	
	<form method="POST" action="login_process">
		<label class="shao_gray" for="username">Username:</label> <input type="text" id="username" name="username"><br>
		<label class="shao_gray" for="password">Password:&nbsp;</label> <input type="text" id="password" name="password"><br>
		<input type="submit" value="submit">
	</form>

</body>
</html>

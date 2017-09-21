<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<form name="myform" method="post" action="RegServlet">
	<input type="hidden" name="pagename" value="register"/>
<center><h1>Registration page</h1></center>
<center><input type="text" name="fname" placeholder="Username"></input><br><br></center>
<center><input type="password" name="password" placeholder="Password"></input><br><br></center>
<center><input type="password" name="confirmpass" placeholder="Confirm password"></input><br><br></center>
<center><input id="in"  type="submit" name="submit" value="Sign up"></input><br><br></center> 
	</form>
</body>
</html>
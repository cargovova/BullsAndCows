<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
</head>
<body>
	<center><h2>Bulls and Cows</h2></center>
	<form method="post" action="RegServlet">
	<center><input type="text" name="LogUser" placeholder="Username"></input><br><br></center>
	<center><input type="password" name = "LogPass" placeholder="Password"></input><br></center><br>
	        <input type="hidden" name="pagename" value="login"/>
	<center><input id="in" type= "submit" name="submit" value="LOGIN"></input><br><br></center>
	</form>
    <center><p>Not registered? <a href="register.jsp">NEW USER</a></p></center>
</body>
</html>
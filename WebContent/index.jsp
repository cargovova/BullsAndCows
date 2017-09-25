<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GameNumber" %>

<%
GameNumber minimum = new GameNumber(1000);
GameNumber maximum = new GameNumber(10000);
GameNumber target = new GameNumber();
target.setRandom(minimum.getValue(), maximum.getValue());
GameNumber guesses = new GameNumber(1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
Введите число больше <%=minimum.getValue()%> и меньше <%= maximum.getValue()%>
</p>
<form name="guessForm" action="guess" method="post">
<label>
Попытка <%= guesses.getValue() %>:
</label>
<input type="text" name="guess" placeholder="Введите число" />
<br>
<input type="submit" name="guessButton" value="Сделать ход"/>

<input type="hidden" name="target" value="<%=target.getValue()%>" />
<input type="hidden" name="guesses" value="<%=guesses.getValue()%>" />
<input type="hidden" name="minimum" value="<%=minimum.getValue()%>" />
<input type="hidden" name="maximum" value="<%=maximum.getValue()%>" />
</form>

</body>
</html>
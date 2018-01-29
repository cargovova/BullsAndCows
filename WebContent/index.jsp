<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GameNumber" %>

<%
GameNumber guesses = new GameNumber(1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<td>
<p>
				Введите число больше
				1000
				и меньше
				10000
				без повторяющихся чисел.
</p>
			<form name="guessForm" action="guess" method="post">
<label>
количество попыток: <%= guesses.getValue() %>
</label>
<input type="text" name="guess" placeholder="Введите число" /><br><br>
<input type="submit" name="guessButton" value="Сделать ход"/>
<input type="hidden" name="guesses" value="<%= guesses.getValue()%>" />
</form>
		</td>
		<td>
			<h1>Быки и коровы</h1>
			<h3>Правила игры: Компьютер задумывает четырехзначное число.
				Цифры в числе не повторяются. Игрок делает ходы, чтобы узнать это
				число. В ответ на каждый ход компьютер показывает число отгаданных
				цифр, стоящих на своих местах (число быков) и число отгаданных цифр,
				стоящих не на своих местах (число коров). Пример Компьютер задумал
				0834. Игрок походил 8134. Компьютер ответил: 2 быка (цифры 3 и 4) и
				1 корова (цифра 8).</h3>
		</td>
	</table>
</body>
</html>
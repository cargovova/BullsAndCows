<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAME</title>
</head>
<body>
	<center>
		<h1>Быки и коровы</h1>
		<h3>
			Правила игры: Компьютер задумывает четырехзначное число. Цифры в
			числе не повторяются. Игрок делает ходы, чтобы узнать это число. В
			ответ на каждый ход компьютер показывает число отгаданных цифр,
			стоящих на своих местах (число быков) и число отгаданных цифр,
			стоящих не на своих местах (число коров). Пример Компьютер задумал
			0834. Игрок походил 8134. Компьютер ответил: 2 быка (цифры 3 и 4) и 1
			корова (цифра 8).<br> Новое число уже задумано компьютером.
			Играем!
		</h3>
	</center>
	<form method="post" action="Game">
		<center>
			<input type="text" name="number" placeholder="Введите число"></input>
			<input type="submit" value="Сделать ход"></input><br>
		</center>
	</form>
	<!--	<c:out value="${sessionScope.beginGame}"/>
			<c:out value="${sessionScope.cowsandbulls}"/>
			<c:out value="${sessionScope.youwin}"/> 
	  -->
</body>
</html>
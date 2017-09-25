package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameNumber;

/**
 * Servlet implementation class GameServlet
 */
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text.html; charset=UTF-8");

		
		GameNumber guess = new GameNumber(Integer.parseInt(request.getParameter("guess")));
		GameNumber minimum = new GameNumber(Integer.parseInt(request.getParameter("minimum")));
		GameNumber maximum = new GameNumber(Integer.parseInt(request.getParameter("maximum")));
		GameNumber target = new GameNumber(Integer.parseInt(request.getParameter("target")));
		GameNumber guesses = new GameNumber(Integer.parseInt(request.getParameter("guesses")));

		String msg = "";
		hasDupes(target.getValue());
		String guessStr = guess.getValue() + "";
		String targetStr = target.getValue() + "";
		Scanner input = new Scanner(System.in);
		msg = "Введите 4-значное число без повторяющихся чисел: ";
			if (guess.getValue() < minimum.getValue() || guess.getValue() > maximum.getValue()) {
				msg = "Некорректное число";
			} else {
				int bulls = 0;
				int cows = 0;
				for (int i = 0; i < 4; i++) {
					if (guessStr.charAt(i) == targetStr.charAt(i)) {
						bulls++;
					} else if (targetStr.contains(guessStr.charAt(i) + "")) {
						cows++;
					}
				}
				if (bulls == 4) {
					msg = "Вы победили после " + guesses.getValue() + " попыток!";
				} else {
					guesses.increment();
					msg = bulls + " Быков и  " + cows + " Коров.";
				}
			}
		input.close();


					PrintWriter out = response.getWriter();

					out.println(
							"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
					out.println("<html>");
					out.println("<head>");
					out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
					out.println("<title>Insert title here</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<p>");
					out.println(msg);
					out.println("<p>");

					if (guess.getValue() == target.getValue()) {
						out.println("<a href='index.jsp'> Play Again! </a>");
					} else {
						out.println("<p>");
						out.println("Пожалуйста, введите число больше " + minimum.getValue() + " и меньше" + maximum.getValue()
								+ ".");
						out.println("</p>");
						out.println("<form name='guessForm' action='guess' method='post'>");
						out.println("<label>");
						out.println("Попытка  " + guesses.getValue() + " : ");
						out.println("</label>");
						out.println("<input type='text' name='guess' placeholder='Введите число' />");
						out.println("<br><input type='submit' name='guessButton' value='Сделать ход' />");

						out.println("<input type='hidden' name='target' value='" + target.getValue() + "' />");
						out.println("<input type='hidden' name='guesses' value='" + guesses.getValue() + "' />");
						out.println("<input type='hidden' name='minimum' value='" + minimum.getValue() + "' />");
						out.println("<input type='hidden' name='maximum' value='" + maximum.getValue() + "' />");
						out.println("</form>");
					}
					out.println("</body>");
					out.println("</html>");
				
	}

	public static boolean hasDupes(int num) {
		boolean[] digs = new boolean[10];
		while (num > 0) {
			if (digs[num % 10])
				return true;
			digs[num % 10] = true;
			num /= 10;
		}
		return false;
	}

}

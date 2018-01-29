package controllers;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
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
		// this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text.html; charset=UTF-8");

		GameNumber guess = new GameNumber(request.getParameter("guess"));
		GameNumber guesses = new GameNumber(Integer.parseInt(request.getParameter("guesses")));
		
		String msg = null;
		String url;		
		String guessedNumber = guess.getVal();
		Scanner sc = new Scanner(System.in);
		produceRandomTarget();
		url = "guess.jsp";
		int bulls = 0;
		int cows = 0;
			bulls = computeBulls(guessedNumber, chosenNum);
			cows = computeCows(guessedNumber, chosenNum);

			if (hasRepeatingDigits(guessedNumber)) {
				msg = "Некорректно. Символы повторяются.";
			} else if (guessedNumber.length() != 4) {
				msg = "Ваше число должно быть 4-значным";
			} else if (containsNonDigits(guessedNumber)) {
				msg = "В запросе содержатся буквы";
			} else if (bulls == 4) {
				msg = "Б = " + bulls + "К = " + cows;
				msg = "Вы победили за " + guesses + " ходов.";
				url = "correct.jsp";
			} else if (!hasRepeatingDigits(guessedNumber) && !containsNonDigits(guessedNumber)) {
				msg = "Б = " + bulls + "К = " + cows;
				guesses.increment();
			}
		sc.close();
		
		request.setAttribute("guess", guessedNumber);
		request.setAttribute("msg", msg);
		request.setAttribute("guesses", guesses);
		request.setAttribute("target", chosenNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
		
	private static String chosenNum = "";
	private static String produceRandomTarget() {
		int randomNumber = 1000 + ((int) (Math.random() * 10000) % 9000);
		chosenNum = Integer.toString(randomNumber);
		while (hasRepeatingDigits(chosenNum)) {
			produceRandomTarget();
		}
		return chosenNum;
	}

	private static boolean hasRepeatingDigits(String num) {
		for (int i = 0; i < num.length() - 1; i++) {
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) == num.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean containsNonDigits(String num) {
		if (!num.matches("^[0-9]+$")) {
			return true;
		}
		return false;
	}

	private static int computeBulls(String num1, String num2) {
		int bullCounter = 0;

		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) == num2.charAt(i)) {
				bullCounter++;
			}
		}
		return bullCounter;
	}

	private static int computeCows(String num1, String num2) {
		int cowsCounter = 0;
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				if (i != j) {
					if (num1.charAt(i) == num2.charAt(j)) {
						cowsCounter++;
					}
				}
			}
		}
		return cowsCounter;
	}
}

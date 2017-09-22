package com.bullsandcows;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
						PrintWriter out = response.getWriter();
						int test = Integer.parseInt(request.getParameter("number"));
						out.print(test);
						
		Random gen = new Random();
		int target = 0;
		while (hasDupes(target = (gen.nextInt(9000) + 1000)));
		String targetStr = target + "";
		boolean guessed = false;
		Scanner input = new Scanner(System.in);
		int guesses = 0;
		do {
			int bulls = 0;
			int cows = 0;
			int guess;
			try {
				guess = Integer.parseInt(request.getParameter("number"));
				if (hasDupes(guess) || guess < 1000)
					continue;
			} catch (InputMismatchException e) {
				continue;
			}
			guesses++;
			String guessStr = guess + "";
			for (int i = 0; i < 4; i++) {
				if (guessStr.charAt(i) == targetStr.charAt(i)) {
					bulls++;
				} else if (targetStr.contains(guessStr.charAt(i) + "")) {
					cows++;
				}
			}
			if (bulls == 4) {
				guessed = true;
			} else {
				String covsandbulls = cows + " Cows and " + bulls + " Bulls.";
				System.out.println(covsandbulls);
				request.setAttribute("covsandbulls", covsandbulls);
			}
		} while (!guessed);
		String youwin = "You won after " + guesses + " guesses!";
		System.out.println(youwin);
		request.setAttribute("youwin", youwin);

		input.close();
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

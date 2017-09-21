package com.bullsandcows;
/*
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

Random gen= new Random();
int target= 0;
while(hasDupes(target = (gen.nextInt(9000) + 1000)));
String targetStr = target +"";
boolean guessed = false;
Scanner input = new Scanner(System.in);
int guesses = 0;
do{
	int bulls = 0;
	int cows = 0;
	System.out.print("Guess a 4-digit number with no duplicate digits: ");
	int guess;
	try{
		guess = input.nextInt();
		if(hasDupes(guess) || guess < 1000) continue;
	}catch(InputMismatchException e){
		continue;
	}
	guesses++;
	String guessStr = guess + "";
	for(int i= 0;i < 4;i++){
		if(guessStr.charAt(i) == targetStr.charAt(i)){
			bulls++;
		}else if(targetStr.contains(guessStr.charAt(i)+"")){
			cows++;
		}
	}
	if(bulls == 4){
		guessed = true;
	}else{
		System.out.println(cows+" Cows and "+bulls+" Bulls.");
	}
while(!guessed);
System.out.println("You won after "+guesses+" guesses!");
public static boolean hasDupes(int num){
boolean[] digs = new boolean[10];
while(num > 0){
	if(digs[num%10]) return true;
	digs[num%10] = true;
	num/= 10;
}
//return false;

public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("At this point will be Game!");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/

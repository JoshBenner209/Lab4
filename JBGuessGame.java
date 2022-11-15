//Josh Benner
//CS 141
// Lab 4
//October 30th
/* This program generates a random number between a range determined by
   the programmer and records the number of guess/games played and returns
   statistics to the player about how they did overall. */ 

import java.util.*;

public class JBGuessGame {
   public static void main(String[] args) {
       final int maxRange =5;
       int randNumber,guess=0,gamesPlayed=0;
       double guessesMade=0,bestGame=100, guessPerGame;
       String answer;
       char play;
       Random rand= new Random();
       Scanner scan = new Scanner(System.in);
       intro(maxRange); 
       System.out.println();				
       do{
	   randNumber = rand.nextInt(maxRange)+1;
	   System.out.println("would you like to play? ");
	   answer = scan.next();
	   play=answer.charAt(0);
	   if(play=='y'||play=='Y') {guessesMade=playGame(guessesMade,randNumber,guess, scan,maxRange);}
	   else {
	       System.out.println();
	       System.out.println("Goodbye");
	       play=('n');
	       System.out.println();
	   }
	   if(guessesMade<bestGame){bestGame=guessesMade;}
	   gamesPlayed++;
       } while(play=='Y' ||play=='y');
       System.out.println();
       results(guessesMade,gamesPlayed,bestGame);
   }
    //introduce game. Pass max value so we can tell the player the range of numbers
    public static void intro(int x) { 
	System.out.println("This guessing game stores a random number"+
			   " between 1 and "+x+".");
	System.out.println(" You will be given a hint if your guess is too high or too low.");
    }
    /* play one game method. pass guesses made, the random number to guess, and the guess made by player and scanner to take in input.
       enter this method and stay in it until the user guesses the random number. record and return the number of guess it took to get
       the correct number */
    public static double playGame( double guessesMade, int randNumber,int guess,Scanner scan,int x ) {
	while (guess!=randNumber) {
	    System.out.println("Please enter number between 1 and "+x);
	    guess = scan.nextInt();
	    if (guess>randNumber) {System.out.println("Too high. Guess again.");}
	    else if(guess<randNumber){System.out.println("Too low. Guess again.");}
	    else {System.out.println("Correct!");}
	    guessesMade++;
	    if(guessesMade == 1){System.out.println("You got it on the first guess!");guessesMade=1;}
	}
	return guessesMade;
    }
    // print out the players statistics. 
    public static void results(double guessesMade,int gamesPlayed,double bestGame){
	gamesPlayed=gamesPlayed-1;
	System.out.println("Overall results:");
	System.out.println("Games Played= "+ gamesPlayed);
	System.out.println("Total Guesses = "+guessesMade);
	double guessPerGame = guessesMade/gamesPlayed;
	System.out.printf("%s%.1f%n","Guesses/Game ",guessPerGame);
	if(bestGame==100){System.out.println("No Game played");}
	else{System.out.println("Best Game = "+bestGame);}		
    }
}
	      
	  
         
      


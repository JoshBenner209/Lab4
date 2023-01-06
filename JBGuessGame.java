//Josh Benner
//CS 141
// Lab 4
//October 30th
/* This program generates a random number between a range determined by
   the programmer and records the number of guess/games played and returns
   statistics to the player about how they did overall. */ 
import java.util.InputMismatchException; // this is the error message. Have to import it in order to use it in the catch statement.
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class JBGuessGame {
    public static void main(String[] args) {
	final int maxRange =5;
	int randNumber,guess=0,gamesPlayed=0,count=0;
	double guessesMade=0,bestGame=100,guesses=0,guessTotal=0;
	String answer;
	char play;
	Random rand= new Random();
	Scanner scan = new Scanner(System.in);
	ArrayList<Double> myGuess = new ArrayList<Double>();
	intro(maxRange); 
	System.out.println();				
	do{
	    randNumber = rand.nextInt(maxRange)+1;
	    System.out.println("would you like to play? ");
	    answer = scan.next();
	    play=answer.charAt(0);
	    if(play=='y'||play=='Y') {
		count++;
		guesses=playGame(guessesMade,randNumber,guess, scan,maxRange);
		myGuess.add(guesses);	    
	    }
	    else {
		System.out.println();
		System.out.println("Goodbye");
		play=('n');
		System.out.println();
	    }
	    if(guesses<bestGame){bestGame=guesses;}
	    gamesPlayed++;
	} while(play=='Y' ||play=='y');
	System.out.println();
	for(int i=1; i<myGuess.size();i++){
	    guessTotal= myGuess.get(i-1)+myGuess.get(i);
	}
	       
	results(guessTotal,gamesPlayed,bestGame);
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
	boolean error = true;
	while (guess!=randNumber || error) {
	    try{ System.out.println("Please enter number between 1 and "+x);
		guess = scan.nextInt();
		error = false;
	    }catch(InputMismatchException e) {  // if invalid entry is detected do this
		System.out.println();
		System.out.println("Error Please enter Integer value");
		scan.next();
	    }
	    if (guess>randNumber&& error==false) {System.out.println("Too high. Guess again.");}
	    else if(guess<randNumber&& error== false){System.out.println("Too low. Guess again.");}
	    else if(guess==randNumber) {System.out.println("Correct!");
	    }
	    else{ continue; }
	    guessesMade++;
	}
	if(guessesMade == 1){System.out.println("You got it on the first guess!");}
	return guessesMade;
    }
    // print out the players statistics. 
    public static void results(double guessesMade,int gamesPlayed,double bestGame){
	int guess=(int)guessesMade;
	int bGame=(int)bestGame;
	gamesPlayed=gamesPlayed-1;
	System.out.println("Overall results:");
	System.out.println("Games Played= "+ gamesPlayed);
	System.out.println("Total Guesses = "+guess);
	double guessPerGame = guessesMade/gamesPlayed;
	System.out.printf("%s%.1f%n","Guesses/Game ",guessPerGame);
	if(bestGame==100){System.out.println("No Game played");}
	else{System.out.println("Best Game = "+bGame);}		
    }
}
	      
	  
         
      


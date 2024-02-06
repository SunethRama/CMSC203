
/*
 * Class: CMSC203-34473-MW-S24
 * Instructor: Dr. Monshi
 * Description: Write a program that tests your ESP (extrasensory perception). 
 * Due: 02/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Suneth Ramawickrama Gamachchige
*/


import java.util.Random;       
import java.util.Scanner;

public class ESPGame {

	public static void main(String[] args) {
		
		final String COLOR_RED = "Red";
		final String COLOR_BLUE = "Blue";
		final String COLOR_GREEN = "Green";
		final String COLOR_YELLOW = "Yellow";   // declaring the 7 colors as final constants
		final String COLOR_PURPLE = "Purple";
		final String COLOR_BLACK = "Black";
		final String COLOR_WHITE = "White";
		
		final int NUM_OF_ROUNDS = 11;   // number of rounds
		
		String userGuess;   // this variable stores the user's guess
		String computerGuess = null;  // this variable stores the computer guess
		int correctGuessCount=0;  // keep the track of total correct guesses
		
		String name, description, dueDate;
		
		Scanner scanner = new Scanner(System.in); // create a scanner object to read the user inputs
		
		Random random = new Random();  // create a random class object to generate random numbers
		
		System.out.print("Enter your name: ");
		name = scanner.nextLine();
		
		System.out.print("Describe yourself: ");
		description = scanner.nextLine();
		
		System.out.print("Due Date: ");
		dueDate = scanner.nextLine();
		
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		for (int i=1 ; i <= NUM_OF_ROUNDS ; i++) {
			
			System.out.print("Round " + i + "\n\n");
			
			
			System.out.println("I am thinking of a color.\n"
					+ "Is it " + COLOR_RED + ", " + COLOR_BLUE + ", " + COLOR_GREEN + ", " + COLOR_YELLOW 
					+ ", " + COLOR_PURPLE + ", " + COLOR_BLACK + ", or " + COLOR_WHITE + "?");
			
			
			System.out.println("Enter your guess: ");
			userGuess = scanner.nextLine();
			
			while(!(userGuess.equalsIgnoreCase(COLOR_WHITE))&& !(userGuess.equalsIgnoreCase(COLOR_BLACK))
					&& !(userGuess.equalsIgnoreCase(COLOR_PURPLE)) && !(userGuess.equalsIgnoreCase(COLOR_YELLOW))
					&& !(userGuess.equalsIgnoreCase(COLOR_GREEN))&& !(userGuess.equalsIgnoreCase(COLOR_BLUE))
				    && !(userGuess.equalsIgnoreCase(COLOR_RED))) // this loop validates user input. 
			{
				System.out.println("You entered incorrect color. " + "Is it " + COLOR_RED + ", " + COLOR_BLUE + ", " + COLOR_GREEN 
						+ ", " + COLOR_YELLOW + ", " + COLOR_PURPLE + ", " + COLOR_BLACK + ", or " + COLOR_WHITE + "?");
				
				System.out.println("Enter your guess again: ");
				userGuess = scanner.nextLine();
			}
			
			int value = random.nextInt(6); // this generates a random number between 0 and 6 in each iteration
			
			switch(value) {
				case 0 : 
					computerGuess = COLOR_RED ; 
					break;
				case 1 : 
					computerGuess = COLOR_BLUE ; 
					break;
				case 2 : 
					computerGuess = COLOR_GREEN ;
					break;
				case 3 : 
					computerGuess = COLOR_YELLOW ;
					break;  // this switch statement maps the random number with a color
				case 4 : 
					computerGuess = COLOR_PURPLE ; 
					break;
				case 5 : 
					computerGuess = COLOR_BLACK ;
					break;
				case 6 : 
					computerGuess = COLOR_WHITE ; 
					break;
			}
			
			if (computerGuess.equalsIgnoreCase(userGuess)){ // if the userGuess is equal to computer guess increment the guess count
				correctGuessCount++;
			}
			
			System.out.println();
			System.out.println("I was thinking of " + computerGuess);
			
			
		}
		
		System.out.println("\nGame Over \n\n" + "You guessed " + correctGuessCount + " out of " + NUM_OF_ROUNDS + " colors correctly.");
		
		System.out.println("Student Name: " + name + "\n" + "User Description: " + description + "\n" + "Due Date: " + dueDate);

		scanner.close();
		
	}

}

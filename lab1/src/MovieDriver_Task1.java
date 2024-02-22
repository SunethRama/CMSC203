/*
 * Class: CMSC203-34473-MW-24
 * Instructor: Prof. Monshi
 * Description: Create a driver class for the movie class
 * Due: 2/21/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Suneth Ramawickrama
*/

import java.util.Scanner;

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);   // create the scanner object
		Movie movie = new Movie();   // create a movie object
		
		String movieName;   // this variable will store the movie name
		String rating;   // this variable will store the rating
		int numOfTicketsSold;   // this variable will store the number of tickets sold
		
		System.out.println("Enter the name of a movie");
		movieName = scanner.nextLine();
		
		movie.setTitle(movieName);   // set the user input as the movie title
		
		System.out.println("Enter the rating of the movie");
		rating = scanner.nextLine();
		
		movie.setRating(rating);   // set the user input as the movie rating
		
		System.out.println("Enter the number of tickets sold for this movie ");
		numOfTicketsSold = scanner.nextInt();
		
		movie.setSoldTickets(numOfTicketsSold); // set the user input as the number of tickets sold
		
		System.out.println(movie.toString());   // Print out the information using the movie’s toString method
		
		System.out.println("\n" + "Goodbye");
		
		scanner.close();
		
	}

}

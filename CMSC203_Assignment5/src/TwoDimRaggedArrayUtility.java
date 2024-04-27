/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: This program calculate the holiday bonus for each company in a sales
 * 				district
 * Due: 4/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Suneth Ramawickrama
*/

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public static double[][] readFile(File file) throws FileNotFoundException{
		
		final int MAX_ROWS = 10;
		final int MAX_COLUMNS = 10;
		
		String temp[][] = new String[MAX_ROWS][MAX_COLUMNS]; // create a temporary array of strings
		
		Scanner inputFile = new Scanner(file); // read the file using a scanner object
		
		int row=0; // store the number of rows that contain data in the file
		
		while (inputFile.hasNextLine()&& row < MAX_ROWS) { // iterate until content is present in the file
			
			String line = inputFile.nextLine(); // store the line that was read from the file
			
			/* get each digit in the line, that are separated by spaces, and store them in the array*/
			String rows[] = line.split(" "); 
			
			for(int col=0 ; col < rows.length && col < MAX_COLUMNS ; col++){
				temp[row][col] = rows[col]; // set each digit to the corresponding column in the current row
			}
			row++; // after finishing a one row, increment it
		}
		
		inputFile.close();
		
		int rowCount = 0; // holds the number of rows that hold values
		
		for (int i=0 ; i < temp.length ; i++) {
			
			/*Any row that begins with null does not have values*/
			if (temp[i][0] != null) { 
				rowCount++; // determine the number of rows needed for the ragget array
			}
		}

		double[][] array = new double[rowCount][]; // create the ragget array 
		
		int colCount;
		
		for (int i=0 ; i < rowCount ; i++) {
			colCount = 0; // holds the number of columns in each row
			
			for (int j=0 ; j < temp[i].length ; j++) {
				
				/*If any column in a row is null, that means it does not hold a value. We can find the
				 * columns that are not null and determine the columns needed for each row*/
				if (temp[i][j] != null) { 
					colCount++;
				}
			}
			
			array[i] = new double[colCount]; // create the number of columns needed for each row
			
			for (int k=0 ; k < colCount ; k++) {
				if (temp[i][k]!= null)
					/*convert each string to a double and store it in the returning array*/
					array[i][k] = Double.parseDouble(temp[i][k]); 
			}
		}
	
		return array;
	}
	
	
	public static void writeToFile(double[][] data,File outputFile)throws FileNotFoundException {

		/*create a PrintWriter object to write data to the file*/
		try (PrintWriter writer = new PrintWriter(outputFile)) {
			for (int i=0 ; i < data.length ; i++) {
				for (int j=0 ; j < data[i].length ; j++) {
					writer.print(data[i][j] + " ");
				}
				
				writer.println();
			}
		}
		
	}
	
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		for (int i=0 ; i < data.length ; i++) {
			for (int j=0 ; j < data[i].length ; j++) {
				total += data[i][j];
			}
		}
		
		return total;
	}
	
	public static double getAverage(double[][] data) {
		
		double total = 0;
		int totalCol = 0;
		
		for (int i=0 ; i < data.length ; i++) {
			for (int j=0 ; j < data[i].length ; j++) {
				total += data[i][j];
				totalCol++; // get the number of elements in the whole array
			}
		}
		
		return total / totalCol; // returns the average
		
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double rowSum = 0;
		for (int i=0 ; i < data[row].length ; i++) {
			rowSum += data[row][i];
		}
		return rowSum;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double colSum = 0;
		for (int i=0 ; i < data.length ; i++) {
			if (col < data[i].length) { // check if the given column exists in the row
				colSum += data[i][col];
			}
		}
		return colSum;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0]; // set the first element in the column as the highest
		for (int i=1 ; i < data[row].length ; i++) {
			if (data[row][i] > highest) { // compare each element
				highest = data[row][i];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int highestIndex = 0;
		for (int i=1 ; i < data[row].length ; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for (int i=1 ; i < data[row].length ; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = data[row][0];
		int lowestIndex = 0;
		for (int i=1 ; i < data[row].length ; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		
		// Find the first row that contains the given column, and assigns that value as the highest 
		
		double highest = 0;
		
		int row = 0;
		
		/*Iterate through each row and find whether the given column exists in that row. Set the highest
		 * to the first row that contains the given column */
		while (row < data.length) { 
			if (col < data[row].length) {
				highest = data[row][col];
				break;
			}
			row++;
		}
		
		/* In this for loop, iteration begins from the index of variable row */
		for (int i=row ; i < data.length ; i++) {
			if (col < data[i].length) {
				if (data[i][col] > highest) {
					highest = data[i][col];
				}
			}
		}
		
		return highest;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		double highest = 0;
		int highestIndex = -1;
		
		/* same logic as the previous method */
		
		int row = 0;
		while (row < data.length) {
			if (col < data[row].length) {
				highest = data[row][col];
				highestIndex = row;
				break;
			}
			row++;
		}
		
		for (int i=row ; i < data.length ; i++) {
			if (col < data[i].length) {
				if (data[i][col] > highest) {
					highest = data[i][col];
					highestIndex = i;
				}
			}
		}
		
		return highestIndex;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		/* follows the same approach in the getHighestInColumn */
	
		double lowest = 0;
		int row = 0;
		while (row < data.length) {
			if (col < data[row].length) {
				lowest = data[row][col];
				break;
			}
			row++;
		}
		
		for (int i=row ; i < data.length ; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
				}
			}
		}
		
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		/* follows the same approach in the getHighestInColumnIndex method */
		
		double lowest = 0;
		int lowestIndex = -1;
		int row = 0;
		while (row < data.length) {
			if (col < data[row].length) {
				lowest = data[row][col];
				lowestIndex = row;
				break;
			}
			row++;
		}
		
		for (int i=row ; i < data.length ; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
					lowestIndex = i;
				}
			}
		}
		
		return lowestIndex;
	}
	
	public static double getHighestInArray(double[][] data) {
		
		/* set the highest to negative infinity, by doing this, we can assign 
		 * the value of first element in the array to the largest because it is 
		 * larger than negative infinity */
		
		double highest = Double.NEGATIVE_INFINITY;
		
		for (int i=0 ; i < data.length ; i++) {
			for (int j=0 ; j < data[i].length ; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		
		return highest;
	}
	
	public static double getLowestInArray(double[][] data) {
		
		/* set the lowest to positive infinity, by doing this, we can assign 
		 * the value of first element in the array to the lowest because it is 
		 * always less than positive infinity */
		
		double lowest = Double.POSITIVE_INFINITY;
		
		for (int i=0 ; i < data.length ; i++) {
			for (int j=0 ; j < data[i].length ; j++) {
				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		
		return lowest;
	}

 }

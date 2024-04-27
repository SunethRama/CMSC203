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

public class HolidayBonus {

	private final static double HIGHEST_BONUS = 5000;
	private final static double LOWEST_BONUS = 1000;
	private final static double OTHER_BONUS = 2000;
	
	public static double[]calculateHolidayBonus (double[][] data){
		
		double returnArr[] = new double[data.length]; // create an array to return the total holiday bonus for each store
		double bonusForEachItem; // holds the holiday bonus for each item sold
		double storeTotal; // holds the total bonus for each store
		
		for (int i=0 ; i < data.length ; i++) {
			
			storeTotal = 0; // set the store total to 0
			
			for (int j=0 ; j < data[i].length ; j++) {
				
				/* If the item is the highest in the column, that gets a bonus of 5000*/
				if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonusForEachItem = HIGHEST_BONUS;
				}
				
				/* If the item is the lowest in the column and not negative, that gets a bonus of 1000*/
				else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)
						&& data[i][j] > 0) {
					bonusForEachItem = LOWEST_BONUS;
				}
				
				/* If the item is the has a negative sales amount or that store has not sold that item,
				 * it does not get any bonus*/
				else if (data[i][j] <= 0) {
					bonusForEachItem = 0;
				}
				
				/* If the item does not belong to any of the categories above, that gets a bonus of 2000*/
				else {
 					bonusForEachItem = OTHER_BONUS;
				}
				
				storeTotal += bonusForEachItem; // add the bonus for every item sold from the company
			}
			
			returnArr[i] = storeTotal; // store the total bonus for the company in the corresponding array element
		}
		
		return returnArr;
	}

	public static double calculateTotalHolidayBonus(double[][] data) {
		double bonusForEach = 0;
		double storeTotal = 0;
		for (int i=0 ; i < data.length ; i++) {
			for (int j=0 ; j < data[i].length ; j++) {
				if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonusForEach = HIGHEST_BONUS;
				}
				else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)
						&& data[i][j] > 0) {
					bonusForEach = LOWEST_BONUS;
				}
				else if (data[i][j] < 0) {
					bonusForEach = 0;
				}
				else {
					bonusForEach = OTHER_BONUS;
				}
				
				storeTotal += bonusForEach; // calculate the total bonus for all the items in the 2D array
			}
			
		}
		
		return storeTotal;
	}
	
}

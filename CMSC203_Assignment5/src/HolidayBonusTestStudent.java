/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: This program test the methods in the HolidayBonus class
 * Due: 4/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Suneth Ramawickrama
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {

	private double [][] data = {{2.5 , 3, 12.3 ,4.5}, {1.3 , 7.8, -3}, {8.7}, {11.5, 9.3}};
	private double [] HolidayBonusForEachStore = {13000,3000,2000,10000};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	
	/* Uses assertArrayEquals method to compare the equality of two arrays */
	public void testCalculateHolidayBonus() {
		assertArrayEquals(HolidayBonusForEachStore, HolidayBonus.calculateHolidayBonus(data),0);
	}

	/* A delta value of 0 is passed as the third parameter to assertEquals method 
	 * to avoid the error "The method assertEquals(double, double) from the type Assert
	 * is deprecated " */
	
	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(28000,HolidayBonus.calculateTotalHolidayBonus(data),0);
	}

}

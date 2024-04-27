/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: This program test the methods in the TwoDimRaggedArrayUtility class
 * Due: 4/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Suneth Ramawickrama
*/

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

	private String filePath = "src/StudentTest1.txt";
    private File file = new File(filePath);
	
	private double [][] data = {{5,7.5,8},{2,9,11,3},{4},{6,7}};
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFile() {
		try {
			
			for (int i=0 ; i < data.length ; i++) {
				for (int j=0 ; j < data[i].length ; j++) {
					assertEquals(data[i][j],TwoDimRaggedArrayUtility.readFile(file)[i][j],0);
				}
			}
			
			assertArrayEquals(data,TwoDimRaggedArrayUtility.readFile(file));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	/* A delta value of 0 is passed as the third parameter to every assertEquals method
       to avoid the error "The method assertEquals(double, double) from the type 
       Assert is deprecated " */
	
	@Test
	public void testGetTotal() {
		assertEquals(62.5,TwoDimRaggedArrayUtility.getTotal(data),0);
	}

	@Test
	public void testGetAverage() {
		assertEquals(6.25,TwoDimRaggedArrayUtility.getAverage(data),0);
	}

	@Test
	public void testGetRowTotal() {
		assertEquals(20.5,TwoDimRaggedArrayUtility.getRowTotal(data, 0),0);
		assertEquals(25,TwoDimRaggedArrayUtility.getRowTotal(data, 1),0);
		assertEquals(4,TwoDimRaggedArrayUtility.getRowTotal(data, 2),0);
		assertEquals(13,TwoDimRaggedArrayUtility.getRowTotal(data, 3),0);
	}

	@Test
	public void testGetColumnTotal() {
		assertEquals(17,TwoDimRaggedArrayUtility.getColumnTotal(data, 0),0);
		assertEquals(23.5,TwoDimRaggedArrayUtility.getColumnTotal(data, 1),0);
		assertEquals(19,TwoDimRaggedArrayUtility.getColumnTotal(data, 2),0);
		assertEquals(3,TwoDimRaggedArrayUtility.getColumnTotal(data, 3),0);
	}

	@Test
	public void testGetHighestInRow() {
		assertEquals(8,TwoDimRaggedArrayUtility.getHighestInRow(data, 0),0);
		assertEquals(11,TwoDimRaggedArrayUtility.getHighestInRow(data, 1),0);
		assertEquals(4,TwoDimRaggedArrayUtility.getHighestInRow(data, 2),0);
		assertEquals(7,TwoDimRaggedArrayUtility.getHighestInRow(data, 3),0);
	}

	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 3));
	}

	@Test
	public void testGetLowestInRow() {
		assertEquals(5,TwoDimRaggedArrayUtility.getLowestInRow(data, 0),0);
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInRow(data, 1),0);
		assertEquals(4,TwoDimRaggedArrayUtility.getLowestInRow(data, 2),0);
		assertEquals(6,TwoDimRaggedArrayUtility.getLowestInRow(data, 3),0);
	}

	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 3));
	}

	@Test
	public void testGetHighestInColumn() {
		assertEquals(6,TwoDimRaggedArrayUtility.getHighestInColumn(data, 0),0);
		assertEquals(9,TwoDimRaggedArrayUtility.getHighestInColumn(data, 1),0);
		assertEquals(11,TwoDimRaggedArrayUtility.getHighestInColumn(data, 2),0);
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInColumn(data, 3),0);
	}

	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 2));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 3));
	}

	@Test
	public void testGetLowestInColumn() {
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInColumn(data, 0),0);
		assertEquals(7,TwoDimRaggedArrayUtility.getLowestInColumn(data, 1),0);
		assertEquals(8,TwoDimRaggedArrayUtility.getLowestInColumn(data, 2),0);
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumn(data, 3),0);
	}

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0));
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 2));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 3));
	}

	@Test
	public void testGetHighestInArray() {
		assertEquals(11,TwoDimRaggedArrayUtility.getHighestInArray(data),0);
		
	}

	@Test
	public void testGetLowestInArray() {
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInArray(data),0);
	}

}

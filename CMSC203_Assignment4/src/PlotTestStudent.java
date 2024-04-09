/*
 * Class: CMSC203 
 * Instructor: Prof. Monshi
 * Description: Property management company
 * Due: 4/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Suneth Ramawickrama
*/

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	private Plot plot,plot1, plot2, plot3, plot4, plot5, plot6, plot7, maxPlot;
	@BeforeEach
	void setUp() throws Exception {
		
		plot = new Plot();
		plot1 = new Plot(0,0,2,2);
		plot2 = new Plot(2,2,2,2);
		plot3 = new Plot(1,1,2,2);
		plot4 = new Plot(1,1,2,2);
		plot5 = new Plot(8,8,2,2);
		plot6 = new Plot(7,3,6,6);
		plot7 = new Plot(plot6);
		maxPlot = new Plot(0,0,10,10);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	public void testNoArgConstructor() {
		
		// test x, y, width, and depth with default values
		assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
	}
	
	@Test 
	public void testParameterizedConstructor() {
		
		// test x, y, width, and depth with the passed values
		assertEquals(7, plot6.getX());
        assertEquals(3, plot6.getY());
        assertEquals(6, plot6.getWidth());
        assertEquals(6, plot6.getDepth());
	}
	
	@Test
	public void testCopyConstructor() {
		
		// test x, y, width, and depth with the values of the passed object
		assertEquals(plot7.getX(), plot6.getX());
        assertEquals(plot7.getY(), plot6.getY());
        assertEquals(plot7.getWidth(), plot6.getWidth());
        assertEquals(plot7.getDepth(), plot6.getDepth());
	}
	
	@Test
	public void testOverlaps() {
		
		assertTrue(plot1.overlaps(plot3)); // plot3 overlaps plot1, should return true
		assertFalse(plot1.overlaps(plot2)); // plot2 does not overlaps plot1, should return false
		assertTrue(plot3.overlaps(plot4)); // plot43 overlaps plot3, both at same coordinates, should return true
	}
	
	@Test 
	public void testEncompass() {
		assertTrue(maxPlot.encompasses(plot2)); // plot 2 is inside the max plot
		assertTrue(maxPlot.encompasses(plot5)); // plot 5 is inside the max plot
		assertFalse(maxPlot.encompasses(plot6)); // plot 6 is outside the max plot
	}
	
	@Test
	public void testToString() {
		assertEquals("0,0,2,2",plot1.toString());	
		assertEquals("2,2,2,2",plot2.toString());	
		assertEquals("1,1,2,2",plot3.toString());	
		assertEquals("1,1,2,2",plot4.toString());	
	}
}

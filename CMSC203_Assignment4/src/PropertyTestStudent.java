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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	private Property property1 , property2, property3;
	
	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property();
		property2 = new Property("My house", "Rockville", 3500, "ABC Company", 3,2,5,5);
		property3 = new Property(property2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testNoArgConstructor() {
		
		// test the values with default values
		assertEquals("", property1.getPropertyName());
        assertEquals("", property1.getCity());
        assertEquals(0.0, property1.getRentAmount());
        assertEquals("", property1.getOwner());
        assertEquals(0, property1.getPlot().getX());
        assertEquals(0, property1.getPlot().getY());
        assertEquals(1, property1.getPlot().getWidth());
        assertEquals(1, property1.getPlot().getDepth());
	}

	@Test
	void testParameterizedConstructor() {
		
		//test values with the passed values
		 assertEquals("My house", property2.getPropertyName());
	     assertEquals("Rockville", property2.getCity());
	     assertEquals(3500.0, property2.getRentAmount());
	     assertEquals("ABC Company", property2.getOwner());
	     assertEquals(3, property2.getPlot().getX());
	     assertEquals(2, property2.getPlot().getY());
	     assertEquals(5, property2.getPlot().getWidth());
	     assertEquals(5, property2.getPlot().getDepth());
	}

	@Test
	void testCopyConstructor() {
		
		// test values with the passed object's values
		 assertEquals(property3.getPropertyName(), property2.getPropertyName());
	     assertEquals(property3.getCity(), property2.getCity());
	     assertEquals(property3.getRentAmount(), property2.getRentAmount());
	     assertEquals(property3.getOwner(), property2.getOwner());
	     assertEquals(property3.getPlot().getX(), property2.getPlot().getX());
	     assertEquals(property3.getPlot().getY(), property2.getPlot().getY());
	     assertEquals(property3.getPlot().getWidth(), property2.getPlot().getWidth());
	     assertEquals(property3.getPlot().getDepth(), property2.getPlot().getDepth());
	}

	@Test
	void testGetPropertyName() {
		 assertEquals("My house", property2.getPropertyName());;
	}

	@Test
	void testGetCity() {
		assertEquals("Rockville", property2.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(3500.0, property2.getRentAmount());
	}

	@Test
	void testGetOwner() {
		 assertEquals("ABC Company", property2.getOwner());
	}

	@Test
	void testGetPlot() {
		assertEquals(3, property3.getPlot().getX());
        assertEquals(2, property3.getPlot().getY());
        assertEquals(5, property3.getPlot().getWidth());
        assertEquals(5, property3.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("My house,Rockville,ABC Company,3500.0", property2.toString());
	}

}

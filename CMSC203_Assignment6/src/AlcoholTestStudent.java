import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {
	
	Alcohol a; 

	@Before
	public void setUp() throws Exception {
		a = new Alcohol("Rum", Size.MEDIUM, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalcPrice() {
		assertEquals(3.6,a.calcPrice(),0);
	}

	@Test
	public void testToString() {
		assertEquals("Rum MEDIUM true", a.toString());
	}

	@Test
	public void testEquals() {
		assertTrue(a.equals(a));
	}

	@Test
	public void testIsWeekend() {
		assertTrue(a.isWeekend());
	}

}

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {
	
	Smoothie s;

	@Before
	public void setUp() throws Exception {
		s = new Smoothie("Banana", Size.SMALL, 5, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalcPrice() {
		assertEquals(6, s.calcPrice(),0);
	}

	@Test
	public void testToString() {
		assertEquals("Banana SMALL 5 true", s.toString());
	}

	@Test
	public void testEquals() {
		assertTrue(s.equals(s));
	}

	@Test
	public void testGetNumOfFruits() {
		assertEquals(5, s.getNumOfFruits());
	}

	@Test
	public void testGetAddProtein() {
		assertTrue(s.getAddProtein());
	}

}

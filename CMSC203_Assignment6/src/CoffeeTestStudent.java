import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

	Coffee c, cf;
	
	@Before
	public void setUp() throws Exception {
		c = new Coffee("Medium Roast", Size.LARGE, false, true);
		cf = new Coffee("Medium Roast", Size.LARGE, false, false);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalcPrice() {
		assertEquals(4.5, c.calcPrice(),0);
	}

	@Test
	public void testToString() {
		assertEquals("Medium Roast LARGE false true", c.toString());
	}

	@Test
	public void testEquals() {
		assertTrue(c.equals(c));
		assertFalse(c.equals(cf));
	}

	@Test
	public void testGetExtraShot() {
		assertFalse(c.getExtraShot());
		assertFalse(cf.getExtraShot());
	}

	@Test
	public void testGetExtraSyrup() {
		assertTrue(c.getExtraSyrup());
		assertFalse(cf.getExtraShot());
	}

}

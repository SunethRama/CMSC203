import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTestStudents {
	
	Customer cus;

	@Before
	public void setUp() throws Exception {
		cus = new Customer("customer1", 25);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		assertEquals("customer1 25", cus.toString());
	}

	@Test
	public void testGetName() {
		assertEquals("customer1", cus.getName());
	}

	@Test
	public void testGetAge() {
		assertEquals(25, cus.getAge());
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	GradeBook gradebook1;
	GradeBook gradebook2;
	
	@BeforeEach
	void setUp() throws Exception {
		gradebook1 = new GradeBook(5);
		gradebook2 = new GradeBook(5);
		
		gradebook1.addScore(85.0);
		gradebook1.addScore(90.0);
		gradebook1.addScore(75.5);
		
		gradebook2.addScore(65.25);
		gradebook2.addScore(95.0);
		gradebook2.addScore(85.75);
		gradebook2.addScore(55.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testAddScore() {

		assertTrue(gradebook1.toString().equals("85.0 90.0 75.5 "));
		assertEquals(3,gradebook1.getScoreSize());
		
		assertTrue(gradebook2.toString().equals("65.25 95.0 85.75 55.0 "));
		assertEquals(4,gradebook2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(250.5, gradebook1.sum());
		
		assertEquals(301.0, gradebook2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(75.5,gradebook1.minimum());
		
		assertEquals (55.0, gradebook2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(175.0,gradebook1.finalScore());
		
		assertEquals(246.0,gradebook2.finalScore());
	}

}

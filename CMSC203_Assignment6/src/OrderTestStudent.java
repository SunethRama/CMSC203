import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

	Customer c1;
	Order o1 , o2;
	ArrayList <Beverage> beverages = new ArrayList<>();
	Coffee co1;
	Smoothie s1;
	Alcohol a1;
	
	@Before
	public void setUp() throws Exception {
		
		c1 = new Customer("Ben", 25);
		
		o1 = new Order(10, Day.SUNDAY, c1);
		o2 = new Order(10, Day.SUNDAY, c1);
		
		co1 = new Coffee("Medium Roast",Size.LARGE , true, false);
		s1 = new Smoothie("Strawberry", Size.MEDIUM, 4, true);
		a1 = new Alcohol("Vodka", Size.SMALL,o1.isWeekend());
		
		o1.addNewBeverage("Vodka", Size.SMALL);
		o1.addNewBeverage("Medium Roast",Size.LARGE , true, false);
		o1.addNewBeverage("Strawberry", Size.MEDIUM, 4, true);
		o1.addNewBeverage("Ice Coffee", Size.SMALL, true, true);	
	}

	@After
	public void tearDown() throws Exception {
		
	}

	
	@Test
	public void testCalcOrderTotal() {
		assertEquals(16.6, o1.calcOrderTotal(),0);
	}
	
	@Test
	public void testIsWeekend() {
		assertTrue(o1.isWeekend());
	}

	@Test
	public void testGetBeverage() {
		assertEquals(a1, o1.getBeverage(0));
	}

	@Test
	public void testAddNewBeverageCoffee() {
		o1.addNewBeverage(co1.getName(), co1.getSize(), co1.getExtraShot(), co1.getExtraSyrup());
		o1.addNewBeverage("Ice Coffee", Size.SMALL, true, true);
		assertEquals(6,o1.getTotalItems());
	}

	@Test
	public void testFindNumOfBeveType() {
		assertEquals(2,o1.findNumOfBeveType(Type.COFFEE));
	}

	@Test
	public void testGetTotalItems() {
		assertEquals(4,o1.getTotalItems());
	}

	@Test
	public void testCompareTo() {
		o2.setOrderNumber(o1.getOrderNumber());
		assertEquals(0,o1.compareTo(o2));
	}

}

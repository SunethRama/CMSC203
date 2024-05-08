import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {
    BevShop bevShop;
 
    
    ArrayList<Order> orders = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        bevShop = new BevShop();
   
    }

    @After
    public void tearDown() throws Exception {
        bevShop = null;
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10)); // Valid time
        assertFalse(bevShop.isValidTime(6)); // Invalid time
        assertFalse(bevShop.isValidTime(24)); // Invalid time
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(6)); // Exceeds max fruit limit
        assertFalse(bevShop.isMaxFruit(3)); // Does not exceed max fruit limit
    }

    @Test
    public void testGetMaxOrderForAlcohol() {
        assertEquals(3, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    public void testIsValidAge() {
        assertTrue(bevShop.isValidAge(25)); // Valid age
        assertFalse(bevShop.isValidAge(20)); // Invalid age
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders()); // One order added
        assertEquals(0, bevShop.getNumOfAlcoholDrink()); // No alcohol drinks in the order
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems()); // One coffee added
    }

    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processAlcoholOrder("Vodka", Size.SMALL);
        assertEquals(1, bevShop.getNumOfAlcoholDrink()); // One alcohol drink added
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processSmoothieOrder("Berry Blast", Size.MEDIUM, 3, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems()); // One smoothie added
    }

    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNumber();
        assertEquals(0, bevShop.findOrder(orderNo)); // Found order at index 0
    }

    @Test
    public void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        assertEquals(2.5, bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNumber()), 0.01); // Assuming coffee price is 2.5
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        assertEquals(2.5, bevShop.totalMonthlySale(), 0.01); // Assuming coffee price is 2.5
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders()); // One order added
    }

    @Test
    public void testGetCurrentOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getCurrentOrder()); // Current order is not null
    }

    @Test
    public void testGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals("John", bevShop.getOrderAtIndex(0).getCust().getName()); // Found order at index 0
    }

}

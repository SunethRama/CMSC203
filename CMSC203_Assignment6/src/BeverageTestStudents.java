import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeverageTestStudents {
	
	@Test
    public void testAddSizePrice() {
        Beverage smallCoffee = new Coffee("Espresso", Size.SMALL, false, false);
        Beverage mediumCoffee = new Coffee("Latte", Size.MEDIUM, false, false);
        Beverage largeCoffee = new Coffee("Cappuccino", Size.LARGE, false, false);

        assertEquals(2.0, smallCoffee.addSizePrice(), 0);
        assertEquals(3.0, mediumCoffee.addSizePrice(), 0);
        assertEquals(4.0, largeCoffee.addSizePrice(), 0);
    }

    @Test
    public void testEquals() {
        Beverage coffee1 = new Coffee("Espresso", Size.SMALL, false, false);
        Beverage coffee2 = new Coffee("Espresso", Size.SMALL, false, false);
        Beverage coffee3 = new Coffee("Green Tea", Size.MEDIUM, false, false);

        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
    }

    @Test
    public void testCalcPrice() {
        Beverage coffee = new Coffee("Espresso", Size.SMALL, false, false);
        Beverage vine = new Alcohol("Green Tea", Size.MEDIUM, true);

        assertEquals(2.0, coffee.calcPrice(), 0);
        assertEquals(3.6, vine.calcPrice(), 0);
    }

}

import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		
		Order orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		Order orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));

		Coffee cf = new Coffee("regular Coffee", Size.SMALL, false, false);
		Alcohol al = new Alcohol("Mohito", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM, 1, false);
		Smoothie sm2 = new Smoothie("Detox", Size.LARGE, 1, false);

		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		System.out.println(cf.calcPrice());
		orderOne.addNewBeverage("Mohito", Size.SMALL);
		System.out.println(al.calcPrice());
		orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);
		System.out.println(sm1.calcPrice());
		
		ArrayList<Beverage> b1 = new ArrayList<>();
		
		b1 = orderOne.getBeverages();
		
		for (Beverage b : b1) {
			System.out.println(b);
		}
		
		System.out.println(orderOne.calcOrderTotal());
		
		System.out.println("---------------------------");
		
		Coffee c2 = new Coffee("regular Coffee", Size.MEDIUM, true, false);
		System.out.println(c2.calcPrice());
		System.out.println ("extra shot " + c2.getExtraShot());
		System.out.println ("extra syrup " + c2.getExtraSyrup());
		orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);
		Alcohol a2 = new Alcohol("Mohito", Size.SMALL, orderTwo.isWeekend());
		System.out.println(a2.calcPrice());
		orderTwo.addNewBeverage("Mohito", Size.SMALL);
		
		Smoothie s1 = new Smoothie("Detox", Size.MEDIUM, 4, true);
		System.out.println(s1.calcPrice());
		orderTwo.addNewBeverage("Detox", Size.MEDIUM, 4, true);

		ArrayList<Beverage> b2 = new ArrayList<>();
		
		b2 = orderTwo.getBeverages();
		
		for (Beverage b : b2) {
			System.out.println(b);
		}
		
		System.out.println(orderTwo.calcOrderTotal());
	}

}

import java.util.Scanner;

public class BevShopDriverApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// create a BevShop
		BevShop bevShop = new BevShop();
		
		System.out.println("The current order in process can have at most "
				+ BevShopInterface.MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
		
		System.out.println("The minimum age to order alcohol drink is " + BevShopInterface.MIN_AGE_FOR_ALCOHOL);
		
		System.out.println("Start please a new order");
		

		System.out.println("Would you please enter your name ");
		String name = sc.nextLine();
		
		System.out.println("Would you please enter your age ");
		int age = sc.nextInt();
		
		bevShop.startNewOrder(15, Day.FRIDAY, name, age);
		
		System.out.println("Your Total Order for now is :" + bevShop.getCurrentOrder().calcOrderTotal());
		
		if (bevShop.getCurrentOrder().getCust().getAge() >= 21) {
			System.out.println("Your age is above 20 and you are eligible to order alcohol");
		}
		
		System.out.println("would you please add an alcohol drink");
		
		bevShop.getCurrentOrder().addNewBeverage("Vine", Size.SMALL);
		
		System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
		
		System.out.println("The Total price on the Order is: " + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Your current alcohol drink order is less than 4");
		
		System.out.println("Would you please add a second alcohol drink");
		
		bevShop.getCurrentOrder().addNewBeverage("Mojito", Size.LARGE);
		
		System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
		
		System.out.println("The Total price on the Order is: " + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Your current alcohol drink order is less than 4");
		
		System.out.println("Add third alcohol drink");
		
		bevShop.getCurrentOrder().addNewBeverage("Gin", Size.SMALL);
		
		System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
		
		System.out.println("The Total price on the Order is: " + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Your current alcohol drink order is less than 4");
		
		System.out.println("You have a maximum alcohol drinks for this order");
		
		System.out.println("Would you please add a COFFEE to your order: ");
		
		bevShop.getCurrentOrder().addNewBeverage("expresso", Size.SMALL, true, true);
		
		System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
		
		System.out.println("The Total price on the Order is: " + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("#------------------------------------#");
		
		System.out.println("Start a new order");
		
		System.out.println("Would you please enter your name ");
		String name1 = sc.nextLine();
		
		sc.nextLine();
		
		System.out.println("Would you please enter your age ");
		int age1 = sc.nextInt();
		
		bevShop.startNewOrder(18, Day.FRIDAY, name1, age1);
		
		System.out.println("Your Total Order for now is :" + bevShop.getCurrentOrder().calcOrderTotal());
		
		if (bevShop.getCurrentOrder().getCust().getAge() >= 21) {
			System.out.println("Your age is above 20 and you are eligible to order alcohol");
		}
		
		System.out.println("Would you please add a SMOOTHIE to order");
		
		bevShop.getCurrentOrder().addNewBeverage("Strawberry", Size.SMALL, 9, false);
		
		System.out.println("Your Total Order for now is :" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Would you please add a SMOOTHIE to order");
		
		bevShop.getCurrentOrder().addNewBeverage("banana", Size.SMALL, 6, true);
		
		System.out.println("Your Total Order for now is :" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Would you please add a COFFEE to order");
		
		bevShop.getCurrentOrder().addNewBeverage("expresso", Size.SMALL, true, true);
		
		System.out.println("Your Total Order for now is :" + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Total price on the second Order: " + bevShop.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
	}
}


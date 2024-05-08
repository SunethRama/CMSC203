import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{

	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderNumber = generateOrder();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.beverages = new ArrayList<>();
	}
	
	public int generateOrder(){
		Random rand = new Random();
		int randNum = rand.nextInt(90001 - 10000) + 10000;
		return randNum;
	}

	@Override
	public boolean isWeekend() {
		return this.orderDay == Day.SATURDAY ||
				this.orderDay == Day.SUNDAY;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		this.beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		
		this.beverages.add(new Alcohol(bevName, size, orderDay == Day.SATURDAY 
				|| orderDay == Day.SUNDAY));
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		this.beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	@Override
	public double calcOrderTotal() {
		double totalOrder = 0;
		for (int i=0 ; i < beverages.size(); i++) {
			totalOrder = totalOrder + beverages.get(i).calcPrice();
		}
		return totalOrder ;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count=0;
		for (Beverage b : beverages){
			if (b.getType()==type) {
				count++;
			}
		}
		return count;
	}

	public int getTotalItems() {
		return beverages.size();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCust() {
		return new Customer(cust);
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	@Override
	public int compareTo(Order anotherOrder) {
		if (this.orderNumber == anotherOrder.orderNumber) {
			return 0;
		} else if (this.orderNumber < anotherOrder.orderNumber) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	
}

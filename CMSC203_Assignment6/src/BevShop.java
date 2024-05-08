import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	private static final int MAX_ORDER_FOR_ALCOHOL = 3;
    private static final int MIN_AGE_FOR_ALCOHOL = 21;
    private static final int MAX_FRUIT = 5;
    private static final int MIN_TIME = 8;
    private static final int MAX_TIME = 23;
	
	private ArrayList<Order> orders;
	private int time;
	private Day orderDay;
	private Customer cust;
	private int numOfAlcOrders = 0;
	private int currentOrderIndex;
	
	public BevShop() { 
		orders = new ArrayList<>();
	}
	
	@Override
	public boolean isValidTime(int time) {
		return time >= MIN_TIME && time <= MAX_TIME;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT ;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		return numOfAlcOrders <= MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return numOfAlcOrders;
	}

	@Override
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		 if (isValidTime(time) && isValidAge(customerAge)) {
	            Customer cust = new Customer(customerName, customerAge);
	            Order newOrder = new Order(time, day, cust);
	            orders.add(newOrder);
	            currentOrderIndex = orders.indexOf(newOrder);
	            numOfAlcOrders = 0;
	        }
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
			orders.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);	
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		  if (!orders.isEmpty() && isEligibleForMore()) {
		        orders.get(currentOrderIndex).addNewBeverage(bevName, size);
		        numOfAlcOrders++;
		  }
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
			orders.get(currentOrderIndex).addNewBeverage(bevName, size, addProtein, addProtein);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return -1;
	}

	@Override
	public double totalMonthlySale() {
		double totalSale = 0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		 return orders.get(currentOrderIndex);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
	}

	@Override
	public void sortOrders() {
		
		for (int i = 0; i< orders.size()-1 ; i++ ) {
			int minIndex = i;
				for (int j = i+1 ; j < orders.size();j++) {
					if (orders.get(j).compareTo(orders.get(minIndex))<0) {
						minIndex = j;
					}
				}
			if (minIndex != i) {
				Order temp = orders.get(minIndex);
				orders.set(minIndex, orders.get(i));
				orders.set(i, temp);
			}
		}
		
	}

}

public class Alcohol extends Beverage{

	private boolean isWeekend;
	private final double WEEKEND_FEE = 0.60;
	
	public Alcohol(String name, Size size, boolean isWeekend) {
		super(name, Type.ALCOHOL , size);
		this.isWeekend = isWeekend;
	}

	@Override
	public double calcPrice() {
		double price = this.addSizePrice();
		if (this.isWeekend()) {
			return price + WEEKEND_FEE;
		}
		
		return price;
	}
	
	public boolean equals(Object anotherBev) {
		Alcohol a = (Alcohol)anotherBev;
		return super.equals(a);
	}
	
	
	public boolean isWeekend() {
		return isWeekend;
	}
	
	public String toString() {
		return super.toString() + " " + isWeekend;
	}

}

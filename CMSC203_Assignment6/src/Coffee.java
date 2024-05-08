public class Coffee extends Beverage{

	private final double extraCoffeeShot = 0.50;
	private final double extraCoffeeSyrup = 0.50;
	
	private boolean extraShot;
	private boolean extraSyrup;
	
	public Coffee (String name, Size size, 
			boolean extraShot, boolean extraSyrup) {
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	@Override
	public double calcPrice() {
		double price = this.addSizePrice();
		if(this.extraShot) {
			price += this.extraCoffeeShot;
		}
		if(this.extraSyrup) {
			price += this.extraCoffeeSyrup;
		}
		return price;
	
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Coffee c = (Coffee)anotherBev;
		return super.equals(c) 
		&& this.extraShot == c.extraShot
		&& this.extraSyrup == c.extraSyrup;	
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public String toString() {
		return super.toString() + " " + extraShot + " " + extraSyrup;
	}

}

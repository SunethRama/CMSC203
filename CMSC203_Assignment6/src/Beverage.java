abstract public class Beverage {

	private String name;
	private Type type;
	private Size size;
	private double BASE_PRICE = 2;
	private double SIZE_PRICE = 1.0; //0.5; 
	
	public Beverage(String name,Type type, Size size ) {
		this.name = name;
		this.type= type;
		this.size = size;
	}
	
	public double addSizePrice() {
		if (getSize() == Size.SMALL) {
			return BASE_PRICE;
		}
		else if (getSize() == Size.MEDIUM) {
			return BASE_PRICE + SIZE_PRICE;
		}
		else {
			return BASE_PRICE + (SIZE_PRICE * 2);
		}
	}

	abstract public double calcPrice();
	
	@Override
	public String toString() {
		return "" + this.name + " " + this.size;
	}
	
	public boolean equals(Object anotherBev) {
		Beverage b = (Beverage)anotherBev;
		return this.name.equals(b.name)&& 
			this.size == b.size && this.type == b.type ;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public Size getSize() {
		return size;
	}
	
}

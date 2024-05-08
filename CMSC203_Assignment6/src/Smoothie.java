public class Smoothie extends Beverage{

	private final double PROTEIN_FEE = 1.50;
	private final double FRUIT_FEE = 0.50;
	private int numOfFruits;
	private boolean addProtein;
	
	public Smoothie(String bevName, Size size, 
			int numOfFruits,boolean addProtein ) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}

	@Override
	public double calcPrice() {
		double price = this.addSizePrice();
		if(this.addProtein) {
			price += this.PROTEIN_FEE;
		}
		price += this.FRUIT_FEE * this.numOfFruits;
		return price;
	}
	
	public boolean equals (Object anotherBev) {
		Smoothie s = (Smoothie)anotherBev;
		return super.equals(s) && this.addProtein == s.addProtein
		&& this.numOfFruits == s.numOfFruits;
	}
	
	public String toString() {
		return super.toString() + " " +
	this.numOfFruits + " " + this.addProtein;
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}
	
}

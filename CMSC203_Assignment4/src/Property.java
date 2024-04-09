/*
 * Class: CMSC203 
 * Instructor: Prof. Monshi
 * Description: Property management company
 * Due: 4/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Suneth Ramawickrama
*/

public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		
		this.plot = new Plot();
		
		this.propertyName = "";
		this.city = "";
		this.rentAmount = 0;
		this.owner = "";	
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		
		this.plot = new Plot();
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	public Property(String propertyName, String city, double rentAmount, String owner, 
			int x, int y, int width, int depth) {
		
		this(propertyName, city, rentAmount, owner);
		this.plot = new Plot(x,y,width,depth);
	}
	
	public Property(Property otherProperty) {
		this(otherProperty.propertyName, otherProperty.city , otherProperty.rentAmount, otherProperty.owner);
		this.plot = new Plot(otherProperty.plot);
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public String toString() {
		return this.propertyName + "," + this.city + "," + this.owner + "," + this.rentAmount;
	}
}

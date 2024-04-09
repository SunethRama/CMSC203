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

public class ManagementCompany {
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	private String name;
	private String taxID;
	private double mgmFeePer;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.numberOfProperties = 0;
		this.plot = new Plot(0,0,MGMT_DEPTH,MGMT_WIDTH );
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.numberOfProperties = 0;
		this.plot = new Plot(0,0,MGMT_DEPTH,MGMT_WIDTH );
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this(name, taxID, mgmFeePer);
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name , otherCompany.taxID, otherCompany.mgmFeePer);
		this.numberOfProperties = otherCompany.numberOfProperties;
		this.plot = new Plot(otherCompany.plot);
		this.properties = new Property[MAX_PROPERTY];
	       
		for (int i = 0; i < otherCompany.numberOfProperties; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
	    }
	}
	
	public int addProperty(String propertyName, String city, double rentAmount, String owner) {
		Property p = new Property(propertyName, city, rentAmount, owner);
		return addProperty(p);
	}
	
	public int addProperty(String propertyName, String city, double rentAmount, String owner
				, int x, int y, int width, int depth) {
		Property p = new Property(propertyName, city, rentAmount, owner,x,y,width,depth);
		return addProperty(p);
	}

	public int addProperty(Property sampleProperty) {
		
		if (numberOfProperties >= MAX_PROPERTY){ 
		/*if the number of properties are greater than max properties, return -1*/
			return -1;
		}
		if (sampleProperty == null){
		/*if the property is null, return -2*/
			return -2;
		}
		if (!plot.encompasses(sampleProperty.getPlot())) {
		/*if the property does not encompasses in the comapny's plot, return -3*/
			return -3;
		}
		
		for (int i=0 ; i < numberOfProperties ; i++) {
			if (properties[i].getPlot().overlaps(sampleProperty.getPlot())) {
				/*if the property overlaps any other property, return -4*/
				return -4;
			}
		}
		
		/*if the property is valid, we add it to the properties array, and increment the properties count*/
		properties[numberOfProperties] = sampleProperty;
		numberOfProperties++;
		
		/*returns the index of the array, where the property is added*/
		return numberOfProperties - 1;
	
	}
	
	public void removeLastProperty() {
		
		if (numberOfProperties > 0) {
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}
	
	public boolean isPropertiesFull() {
		return numberOfProperties >= MAX_PROPERTY;
	}
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public double getTotalRent() {
	    double totalRent = 0;
	    for (int i = 0; i < numberOfProperties; i++) {
	        if (properties[i] != null) {
	            totalRent = totalRent + properties[i].getRentAmount();
	        }
	    }
	    return totalRent;
	}
	
	public Property getHighestRentPropperty() {
		
		double highest = properties[0].getRentAmount();
		Property highestIndex = properties[0];
		
		for (int i=1 ; i < numberOfProperties ; i++) {
			if (properties[i] != null) {
				if(properties[i].getRentAmount() > highest) {
					highest = properties[i].getRentAmount();
					highestIndex = properties[i];
				}
			}
			
		}
		
		return highestIndex;
	}
	
	public boolean isManagementFeeValid() {
		return this.mgmFeePer >= 0 && this.mgmFeePer <= 100;
	}

	public Property[] getProperties() {
		return properties;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}
	
	public String toString() {
		
		String returnStr;

		returnStr = "List of the properties for " + name + ", taxID: " + taxID + "\n";
		returnStr += "______________________________________________________\n";
		
		for(int i = 0; i < numberOfProperties; i++) {
			returnStr += properties[i].toString();
			returnStr += "\n";
		}
		
		returnStr += "______________________________________________________\n" +"\n";
		double totalMNGMFee = (getTotalRent()*mgmFeePer)/100;
		
		returnStr += " total management Fee: " + totalMNGMFee;
		
		return returnStr;
	}

}

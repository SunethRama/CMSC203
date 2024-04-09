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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	private ManagementCompany managementCompany;
	private Property sampleProperty;
	
	@BeforeEach
	void setUp() throws Exception {
		managementCompany = new ManagementCompany("Railey","555555555",6);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddProperty1() {
		
		// successfully adding properties, so the indexes should be returned
		
		sampleProperty = new Property("My House 1","Rockville", 2500, "ABC Company");
		assertEquals(0,managementCompany.addProperty(sampleProperty));
		
		Property sampleProperty2 = new Property("My House 2","Rockville", 2500, "ABCD Company",3,3,2,2);
		assertEquals(1,managementCompany.addProperty(sampleProperty2));
	}

	@Test
	void testAddProperty2() {
		
		// successfully adding properties, so the indexes should be returned
		
		Property sampleProperty1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);
		assertEquals(0, managementCompany.addProperty(sampleProperty1)); 
	}

	@Test
	void testAddProperty3() {
		
		Property p = null;
		// null objects should return -2
		assertEquals(-2,managementCompany.addProperty(p)); 
		
		Property p1 = new Property();
		 // successfully added a one property, so index 0 should be returned
		assertEquals(0,managementCompany.addProperty(p1));

		Property p3 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",8,0,2,2);
		// successfully added another object, so index 1 should be returned
		assertEquals(1,managementCompany.addProperty(p3)); 
		
		Property p4 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",6,5,1,1);
		// successfully added another object, so index 2 should be returned
		assertEquals(2,managementCompany.addProperty(p4)); 
		
		Property p2 = new Property();
		// this property overlaps with the p1, -4 should return
		assertEquals(-4,managementCompany.addProperty(p2)); 
		
		Property p5 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",9,9,2,2);
		// this plot does not encompasses, -3 should be returned
		assertEquals(-3,managementCompany.addProperty(p5)); 

	}

	@Test
	void testRemoveLastProperty() {
		Property p1 = new Property();
		Property p2 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);
		Property p3 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",8,8,2,2);
		
		managementCompany.addProperty(p1);
		managementCompany.addProperty(p2);
		managementCompany.addProperty(p3); // add 3 properties
		
		assertEquals(3,managementCompany.getPropertiesCount()); // property count should be 3
		
		managementCompany.removeLastProperty(); // remove last property
		assertEquals(2,managementCompany.getPropertiesCount()); // property count should be 2
		
		managementCompany.removeLastProperty(); // remove last property
		assertEquals(1,managementCompany.getPropertiesCount()); // property count should be 1
	}

	@Test
	void testIsPropertiesFull() {
		Property p1 = new Property();
		Property p2 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,2,2,2);
		Property p3 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",4,2,2,2);
		Property p4 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",6,2,2,2);
		Property p5 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson",8,8,2,2);
		
		managementCompany.addProperty(p1);
		managementCompany.addProperty(p2);
		managementCompany.addProperty(p3);
		managementCompany.addProperty(p4);
		managementCompany.addProperty(p5); // add 5 properties
		
		assertTrue(managementCompany.isPropertiesFull()); // we have 5 properties now so array is full
		
		managementCompany.removeLastProperty();
		managementCompany.removeLastProperty(); // remove 2 elements
		
		assertFalse(managementCompany.isPropertiesFull()); // now we have 3 elements, so it is not full
	}

	@Test
	void testGetPropertiesCount() {
		
		Property p1 = new Property();
		Property p2 = new Property("my house", "Rockville", 2500,"ABC Comapany",8,8,2,2);
		Property p3 = new Property("my house 2", "Rockville", 2500,"ABC Comapany",4,4,2,2);
		
		assertEquals(0,managementCompany.getPropertiesCount()); // we haven't add any properties yet, should return 0
		
		managementCompany.addProperty(p1);
		managementCompany.addProperty(p2);
		managementCompany.addProperty(p3); // add 3 properties created above
		
		assertEquals(3,managementCompany.getPropertiesCount()); // now the property count should be 3
	}

	@Test
	void testGetTotalRent() {
		
		Property p1 = new Property("my house", "Rockville", 2500,"ABC Comapany",8,8,2,2);
		Property p2 = new Property("my house 2", "Rockville", 2500,"ABC Comapany",4,4,2,2);
		
		managementCompany.addProperty(p1);
		managementCompany.addProperty(p2); // add 2 properties with 2500 rent each

        assertEquals(5000.0, managementCompany.getTotalRent()); // the total should be 5000.0
	}

	@Test
	void testGetHighestRentProperty() {

		Property p1 = new Property("my house", "Rockville", 2500,"ABC Comapany",8,8,2,2);
		Property p2 = new Property("my apartment", "Rockville", 3000,"ABC Comapany",4,4,2,2);
		
		managementCompany.addProperty(p1); // rent is 2500
		managementCompany.addProperty(p2); // rent is 3000

        assertEquals("my apartment", managementCompany.getHighestRentPropperty().getPropertyName());
        // p2 has the highest rent among all the properties, so its name "my apartment should be returned"
	}

	@Test
	void testIsMangementFeeValid() {
		
		managementCompany = new ManagementCompany("Company", "123456789", -10.0);
		// management fee cannot be negative, should return false
        assertFalse(managementCompany.isManagementFeeValid());

        managementCompany = new ManagementCompany("Company2", "123456789", 110.0);
        // management fee cannot be greater than 100, should return false
        assertFalse(managementCompany.isManagementFeeValid());
        
        managementCompany = new ManagementCompany("Company", "123456789", 70.0);
        // management fee is in the range, should return true
        assertTrue(managementCompany.isManagementFeeValid());
	}

	@Test
	void testToString() {
		sampleProperty = new Property ("Apartment", "Rockville", 2613.0, "ABC Company",2,5,2,2);
		assertEquals(managementCompany.addProperty(sampleProperty), 0);	
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Apartment,Rockville,ABC Company,2613.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 156.78";
		
		assertEquals(expectedString, managementCompany.toString());
	}

}

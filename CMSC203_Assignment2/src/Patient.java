/*
 * Class: CMSC203-34473-MW-S24
 * Instructor: Dr. Monshi
 * Description: This class has the attributes and methods of the patient
 * Due: 2/26/2024
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Suneth Ramawickrama
*/

public class Patient {

	private String firstName;
	private String middleName;
	private String lastName;

	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;

	private String phoneNumber;

	private String emergencyContactName;
	private String emergencyPhoneNumber;

	/**
	 * No-arg constructor
	 */
	public Patient() {

	}

	/**
	 * Parameterized constructor that sets the first name, middle name, and last
	 * name
	 * 
	 * @param firstName  first name of the patient
	 * @param middleName middle name of the patient
	 * @param lastName   last name of the patient
	 */
	public Patient(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * Parameterized constructor that sets each field
	 * 
	 * @param firstName            first name of the patient
	 * @param middleName           middle name of the patient
	 * @param lastName             last name of the patient
	 * @param streetAddress        street address of the patient
	 * @param city                 city of the patient
	 * @param state                state of the patient
	 * @param zipCode              zipcode of the patient
	 * @param phoneNumber          phone number of the patient
	 * @param emergencyContactName emergency Contact Name of the patient
	 * @param emergencyPhoneNumber emergency Phone Number of the patient
	 */
	public Patient(String firstName, String middleName, String lastName, String streetAddress, String city,
			String state, String zipCode, String phoneNumber, String emergencyContactName,
			String emergencyPhoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emergencyContactName = emergencyContactName;
		this.emergencyPhoneNumber = emergencyPhoneNumber;
	}

	/**
	 * allows the program to access firstName outside the Patient class
	 * 
	 * @return the first name of the patient
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * allows the program to modify the firstName outside Patient class
	 * 
	 * @param firstName the first name of the patient
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * allows the program to access middleName outside the patient class
	 * 
	 * @return the middle name of the patient
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * allows the program to modify the middleName outside Patient class
	 * 
	 * @param middleName middle name of the patient
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * allows the program to access lastName outside the patient class
	 * 
	 * @return the last Name of the patient
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * allows the program to modify the lastName outside Patient class
	 * 
	 * @param lastName last name of the patient
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * allows the program to access streetAddress outside the patient class
	 * 
	 * @return the street Address of the patient
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * allows the program to modify the streetAddress outside Patient class
	 * 
	 * @param streetAddress street Address of the patient
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * allows the program to access city outside the patient class
	 * 
	 * @return the city of the patient
	 */
	public String getCity() {
		return city;
	}

	/**
	 * allows the program to modify the city outside Patient class
	 * 
	 * @param city city of the patient
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * allows the program to access state outside the patient class
	 * 
	 * @return the state of the patient
	 */
	public String getState() {
		return state;
	}

	/**
	 * allows the program to modify the state outside Patient class
	 * 
	 * @param state state of the patient
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * allows the program to access zipCode outside the patient class
	 * 
	 * @return the zipCode of the patient
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * allows the program to modify the zipCode outside Patient class
	 * 
	 * @param zipCode the zipCode of the patient
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * allows the program to access phoneNumber outside the patient class
	 * 
	 * @return the phoneNumber of the patient
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * allows the program to modify the phoneNumber outside Patient class
	 * 
	 * @param phoneNumber the phone Number of the patient
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * allows the program to access emergencyContactName outside the patient class
	 * 
	 * @return the emergencyContactName of the patient
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	/**
	 * allows the program to modify the emergencyContactName outside Patient class
	 * 
	 * @param emergencyContactName the emergencyContactName of the patient
	 */
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	/**
	 * allows the program to access emergencyPhoneNumber outside the patient class
	 * 
	 * @return the emergency Phone Number of the patient
	 */
	public String getEmergencyPhoneNumber() {
		return emergencyPhoneNumber;
	}

	/**
	 * allows the program to modify the emergencyPhoneNumber outside Patient class
	 * 
	 * @param emergencyPhoneNumber the emergency Phone Number of the patient
	 */
	public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
		this.emergencyPhoneNumber = emergencyPhoneNumber;
	}

	/**
	 * This method builds the full name of the user, concatenating first, middle,
	 * and last names
	 * 
	 * @return the full name of the patient
	 */
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}

	/**
	 * This method builds the full address of the patient, concatenating street
	 * address, city, state, and the zipcode.
	 * 
	 * @return the full address of the patient
	 */
	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}

	/**
	 * This method builds the Emergency Contact of the user, concatenating the
	 * emergency Contact Name, and emergency Phone Number
	 * 
	 * @return the full emergency contact details of the patient
	 */
	public String buildEmergencyContact() {
		return emergencyContactName + " " + emergencyPhoneNumber;
	}

	@Override
	/**
	 * This method returns the content of the object as a string
	 * 
	 * @return the content of a Patient object as a string
	 */
	public String toString() {
		return "  Name: " + this.buildFullName() + "\n" + "  Address: " + this.buildAddress() + "\n"
				+ "  EmergencyContact: " + this.buildEmergencyContact();
	}

}

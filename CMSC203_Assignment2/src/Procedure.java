/*
 * Class: CMSC203-34473-MW-S24
 * Instructor: Dr. Monshi
 * Description: This class has the attributes and methods of the procedures
 * Due: 2/26/2024
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Suneth Ramawickrama
*/

public class Procedure {

	private String procedureName;
	private String procedureDate;
	private String practitioner;
	private double charges;

	/**
	 * no-arg constructor
	 */
	public Procedure() {

	}

	/**
	 * Parameterized constructor that sets the procedure name, and procedure date
	 * 
	 * @param procedureName the name of the procedure
	 * @param procedureDate the date of the procedure
	 */
	public Procedure(String procedureName, String procedureDate) {
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
	}

	/**
	 * Parameterized constructor that sets each field
	 * 
	 * @param procedureName the name of the procedure
	 * @param procedureDate the date of the procedure
	 * @param practitioner  the practitioner for the procedure
	 * @param charges       the charges for the procedure
	 */
	public Procedure(String procedureName, String procedureDate, String practitioner, double charges) {
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.practitioner = practitioner;
		this.charges = charges;
	}

	/**
	 * allows the program to access the procedureName outside Procedure class
	 * 
	 * @return the Name of the procedure
	 */
	public String getProcedureName() {
		return procedureName;
	}

	/**
	 * allows the program to modify the procedureName outside Procedure class
	 * 
	 * @param procedureName the Name of the procedure
	 */
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	/**
	 * allows the program to access the procedureDate outside Procedure class
	 * 
	 * @return the Date of the procedure
	 */
	public String getProcedureDate() {
		return procedureDate;
	}

	/**
	 * allows the program to modify the procedureDate outside Procedure class
	 * 
	 * @param procedureDate the date of the procedure
	 */
	public void setProcedureDate(String procedureDate) {
		this.procedureDate = procedureDate;
	}

	/**
	 * allows the program to access the practitioner outside Procedure class
	 * 
	 * @return the practitioner for the procedure
	 */
	public String getPractitioner() {
		return practitioner;
	}

	/**
	 * allows the program to modify the practitioner outside Procedure class
	 * 
	 * @param practitioner the practitioner for the procedure
	 */
	public void setPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * allows the program to access the charges outside Procedure class
	 * 
	 * @return the charges for the procedure
	 */
	public double getCharges() {
		return charges;
	}

	/**
	 * allows the program to modify the charges outside Procedure class
	 * 
	 * @param charges the charges for the procedure
	 */
	public void setCharges(double charges) {
		this.charges = charges;
	}

	@Override
	/**
	 * This method returns the content of the object as a string
	 * 
	 * @return the content of a Procedure object as a string
	 */
	public String toString() {
		return "\tProcedure: " + this.procedureName + "\n\tProcedureDate=" + this.procedureDate + "\n\tPractitioner="
				+ this.practitioner + "\n\tCharges=" + this.charges;
	}

}

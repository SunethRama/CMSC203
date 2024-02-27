/*
 * Class: CMSC203-34473-MW-S24
 * Instructor: Dr. Monshi
 * Description: This class contains the main method
 * Due: 2/26/2024
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Suneth Ramawickrama
*/

public class PatientDriverApp {

	public static void main(String[] args) {

		final String STUDENT_NAME = "Suneth Ramawickrama";
		final String M_NUMBER = "M21161872";
		final String DUE_DATE = "2/26/2024";

		System.out.println("Patient info:");

		Patient patient = new Patient("Jenny", "Elaine", "Santori", "123 Main Street", "MyTown", "CA", "01234", "",
				"Bill Santori", "777-555-1212");

		Procedure p1 = new Procedure();
		p1.setProcedureName("Physical Exam");
		p1.setProcedureDate("7/20/2019");
		p1.setPractitioner("Dr. Irvine");
		p1.setCharges(3250.0);

		Procedure p2 = new Procedure("X-ray", "7/20/2019");
		p2.setPractitioner("Dr. Jamison");
		p2.setCharges(5500.43);

		Procedure p3 = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 1400.75);

		displayPatient(patient);
		displayProcedure(p1);
		displayProcedure(p2);
		displayProcedure(p3);

		System.out.printf("\nTotal Charges: $%,.2f", calculateTotalCharges(p1, p2, p3));
		System.out.println("\n");

		System.out.println("Student Name: " + STUDENT_NAME);
		System.out.println("MC#: " + M_NUMBER);
		System.out.println("Due Date: " + DUE_DATE);
	}

	/**
	 * This method display the details of the patient
	 * 
	 * @param p a Patient object
	 */
	public static void displayPatient(Patient p) {
		System.out.println(p.toString());
	}

	/**
	 * This method display the details of the procedure
	 * 
	 * @param p a Procedure object
	 */
	public static void displayProcedure(Procedure p) {

		System.out.println("\n" + p.toString());
	}

	/**
	 * This method calculates the total charges for all the procedures
	 * 
	 * @param p1 a Procedure object
	 * @param p2 a Procedure object
	 * @param p3 a Procedure object
	 * @return the total charges for all 3 procedures
	 */
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		return p1.getCharges() + p2.getCharges() + p3.getCharges();

	}

}

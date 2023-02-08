package javaOOP;

public class Topic_02_Variable_Property_Method {
	// Access Modifier
	// Data Type
	// Variable name
	// Variable value
	private String studentName = "Hermione"; // Global variable
	
	// Static variable: reusable and assignable
	public static String studentAddress = "Ho Chi Minh";
	
	// Static variable: in class only/for all instances/objects
	private static String studentPhone = "0433526274";
	
	// Final variable: cannot be overrided
	// Fix data: cannot be changed during running
	final String country = "Viet Nam";
	
	// Static final variable (constant)
	// Cannot be overrided
	// Can be widely accessed for all instances/threads
	static final float PI_NUMBER = 3.14f;
	
	// Accesss Modifier: default
	int studentNumber = 50;
	
	// Method - Static
	public static void main(String[] args) {
		// Local variable: method
		String studentName = "Ron";	
		
		if (studentName.startsWith("Ron")) {
			// Local variable: block code
			int number = 100;
		}
		
		studentAddress = "Ha Noi";
		studentPhone = "0142645747";
	}
	
	// Constructor
	public Topic_02_Variable_Property_Method() {
		// Local variable: constructor
		String studentName = "Ron";	
	}
	
	// Method - Non static
	public void display() {
		// Local variable: method
		String studentName = "Ron";
	}
}

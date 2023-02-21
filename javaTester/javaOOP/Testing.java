package javaOOP;

public class Testing {

	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		
		// Instance variable
		firstStudent.studentID = 13579;
		
		System.out.println(Topic_02_Variable_Property_Method.studentAddress);
		Topic_02_Variable_Property_Method.studentAddress = "Hoi An";
		
		Topic_03_Method.showCarColor();
		
		// Directly accessed from class name
		// Don't need to create instance object
		// Don't use it too much
		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		
		// Declare classes
		Topic_04_Non_Access_Modifier.sendKeyToElement("Hello");
		
		Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
		topic.personName = "Ganyu";
		topic.personAge = 0;
		topic.showPersonInfo();
		
	}
	
	// Nested class
	public static class nestedClass {
		
	}

}

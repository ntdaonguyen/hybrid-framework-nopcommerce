package javaOOP;

public class Topic_03_Method {

	// Non-static
	void showCarName() {
		System.out.println("Hyundai");
	}
	
	static void showCarColor() {
		System.out.println("White");
	}
	
	public static void main(String[] args) {
		// Can call into another static method
		showCarColor();
		
		// Call by instance/object
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName();
		
		Topic_03_Method.showCarColor();
	}

}

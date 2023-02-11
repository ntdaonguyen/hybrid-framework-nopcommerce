package javaOOP;

public class Topic_04_Non_Access_Modifier {

	// Static: Variable/Method
	// Used for all instance/object
	// For all system to use
	// Can be overrided
	static String browserName = "Chrome";
	 
	// Non-static
	String serverName = "Testing";
	
	// Prevent overridding
	final String carColor = "BLACK";
	
	final static String REGISTER_BUTTON = "";
	
	public static void main(String[] args) {
		
		// Static variable is directly used in static method
		browserName = "Firefox";
		System.out.println(browserName);
		
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.serverName);
		
		System.out.println(topic.carColor);
		
		topic.clickToElement("Button");
		
		sendKeyToElement("Hello");
	}
	
	// Non-static
	public void clickToElement(String elementName) {
		System.out.println(elementName);
	}
	
	// Static
	public static void sendKeyToElement(String elementName) {
		System.out.println(elementName);
	}

	// Final
	public final void setCarName() {	
	}
}

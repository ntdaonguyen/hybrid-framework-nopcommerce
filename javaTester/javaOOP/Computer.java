package javaOOP;

public abstract class Computer {

	// Normal method
	public void showComputerPerformance() {
		System.out.println("Show computer performance");
	}
	
	// Abstract method
	// A frame for child classes inherit it must be override (implement)
	public abstract void showComputerRam();
}

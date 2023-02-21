package javaOOP.overriding;

public abstract class Person {
	public void eat() {
		System.out.println("Rice 20k");
	}
	
	public abstract void sleep();
	
	public final void walk() {
		System.out.println("Walking");
	}
	
	public static void run() {
		System.out.println("Run");
	}
}

package javaOOP.overriding;

public class Employee extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Rice 25k");
	}
	
	@Override
	public void sleep() {
		System.out.println("Sleep 6 hours");
	}
	
	@Override
	public void workingTime() {
		System.out.println("Work 8 hours a day");
	}
}

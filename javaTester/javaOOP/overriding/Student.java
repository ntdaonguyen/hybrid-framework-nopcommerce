package javaOOP.overriding;

public class Student extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Rice 15k");
	}
	
	@Override
	public void sleep() {
		System.out.println("Sleep 12 hours");
	}
	
	@Override
	public void workingTime() {
		System.out.println("Study 3 hours a day");
	}
}

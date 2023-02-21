package javaOOP.polymorphism;

public class Test {
	
	public static void main(String[] args) {
		Pig pig = new Pig();
		pig.eat();
		
		Animal ani = new Animal();
		ani.eat();
		
		ani = new Pig();
		ani.eat();
		
		ani = new Bird();
		ani.eat();
	}
}

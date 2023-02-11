package javaOOP;

// Abstract class
// Template
public abstract class Animal {

	String animalName = "Dog";
	
	// Method
	// No body
	// public, protected
	// child classes are required to override this method
	protected abstract void setAnimalName();
}

package javaOOP.overriding;

public class Testing {

	public static void main(String[] args) {		
		Student s = new Student();
		s.eat();
		s.sleep();
		s.workingTime();
		
		Employee e = new Employee();
		e.eat();
		e.sleep();
		e.workingTime();
	}

}

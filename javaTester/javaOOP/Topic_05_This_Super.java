package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP {
	private int firstNumber;
	private int secondNumber;
	private WebDriver driver;
	private long shortTimeout = 15;
	private long longTimeout = 45;
	
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);

	}
	
	public void clickToElement() {
		// No super - Call method in child class
		setImplicitWait();
		
		// Call method in parent class
		super.setImplicitWait();
	}
	
	public Topic_05_This_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	public void sumNumber() {
		int sum = this.firstNumber + this.secondNumber;
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super(5, 15);
		topic.sumNumber();
	}
}

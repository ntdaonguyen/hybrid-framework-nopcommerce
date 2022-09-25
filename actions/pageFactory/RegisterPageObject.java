package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	public WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "FirstName")
	public WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	public WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	public WebElement emailTextbox;
	
	@FindBy(id = "Password")
	public WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	public WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	public WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	public WebElement firstNameErrorMessage;
	
	@FindBy(id = "LastName-error")
	public WebElement lastNameErrorMessage;
	
	@FindBy(id = "Email-error")
	public WebElement emailErrorMessage;
	
	@FindBy(id = "Password-error")
	public WebElement passwordErrorMessage;
	
	@FindBy(id = "ConfirmPassword-error")
	public WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	public WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	public WebElement logoutLink;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	public WebElement existingEmailErrorMessage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}
	
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailTextbox);
		return getElementText(driver, emailTextbox);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordTextbox);
		return getElementText(driver, passwordTextbox);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordTextbox);
		return getElementText(driver, confirmPasswordTextbox);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstName);
	}
	
	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastName);		
	}

	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);				
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);				
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}
	
	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
}

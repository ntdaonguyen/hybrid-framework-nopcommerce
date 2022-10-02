package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	String osName = System.getProperty("os.name");
	private WebDriver driver;
	private String firstName, lastName, correctPassword,incorrectPassword, existingEmail, invalidEmail, notFoundEmail;
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject myAccountPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage = new UserHomePageObject(driver);
		
		firstName = "Nguyen";
		lastName = "Nguyen";
		correctPassword = "123456";
		incorrectPassword = "123457";
		existingEmail  = "nguyenntd" + randomNumber() + "@hotmail.net";
		invalidEmail = "nguyenntd@hotmail@net";
		notFoundEmail  = "nguyenntd" + randomNumber() + "@hotmail.com";
		
		System.out.println("Pre-condition - Step 01: Click to Register link");
		
		registerPage = homePage.clickToRegisterLink();
		
		System.out.println("Pre-condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(correctPassword);
		registerPage.inputToConfirmPasswordTextbox(correctPassword);
		
		System.out.println("Pre-condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05: Click to Log out link");
		registerPage.clickToLogoutLink();		
	}
	
	@Test
	public void Login_01_Empty_Data() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
  
	@Test
	public void Login_02_Invalid_Email() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
  
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
  
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
  
	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(correctPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		myAccountPage = homePage.clickToMyAccountLink();
		myAccountPage.clickToNewsletterCheckbox();
	}
  
	public int randomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt();
		return randomNum;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
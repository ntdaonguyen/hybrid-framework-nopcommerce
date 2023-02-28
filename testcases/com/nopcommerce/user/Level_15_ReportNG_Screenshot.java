

package com.nopcommerce.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertFalse;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ReportNG_Screenshot extends BaseTest {
	String osName = System.getProperty("os.name");
	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress;
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage = new UserHomePageObject(driver);
		
		firstName = "Nguyen";
		lastName = "Nguyen";
		validPassword = "123456";
		emailAddress  = "nguyenntd" + randomNumber() + "@hotmail.net";
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
	
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confrm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
	
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		ExtentTestManager.endTest();

		// log.info("Register - Step 09: Click to Logout link");
		//registerPage.clickToLogoutLink();
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login' page");
		loginPage =	homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());	

		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
		customerInfoPage = homePage.clickToMyAccountLink();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Info' page is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
		ExtentTestManager.endTest();
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



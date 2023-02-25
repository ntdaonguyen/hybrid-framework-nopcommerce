

package com.nopcommerce.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
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

public class Level_12_Assert_Verify extends BaseTest {
	String osName = System.getProperty("os.name");
	private WebDriver driver;
	private String firstName, lastName, correctPassword, emailAddress;
	
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
		correctPassword = "123456";
		emailAddress  = "nguyenntd" + randomNumber() + "@hotmail.net";
	}

	@Test
	public void User_01_Register_Login() {		
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(correctPassword);
		registerPage.inputToConfirmPasswordTextbox(correctPassword);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
	
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(correctPassword);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isMyAccountLinkDisplayed());	

		customerInfoPage = homePage.clickToMyAccountLink();
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());
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



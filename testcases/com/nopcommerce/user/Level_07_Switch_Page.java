

package com.nopcommerce.user;

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

public class Level_07_Switch_Page extends BaseTest {
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
	public void User_01_Register() {		
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(correctPassword);
		registerPage.inputToConfirmPasswordTextbox(correctPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
	}
  
	@Test
	public void User_02_Login() {
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(correctPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());	
	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}
  
	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		addressPage = rewardPointPage.openAddressPage(driver);
		rewardPointPage = addressPage.openRewardPointPage(driver);
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		addressPage = myProductReviewPage.openAddressPage(driver);
		customerInfoPage = addressPage.openCustomerInfoPage(driver);
		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);
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



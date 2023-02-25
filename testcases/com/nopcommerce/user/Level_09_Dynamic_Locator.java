

package com.nopcommerce.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class Level_09_Dynamic_Locator extends BaseTest {
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
		AssertJUnit.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
	
		loginPage =	homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(correctPassword);
		homePage = loginPage.clickToLoginButton();
		AssertJUnit.assertTrue(homePage.isMyAccountLinkDisplayed());	

		customerInfoPage = homePage.clickToMyAccountLink();
		AssertJUnit.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}
  
	@Test
	public void User_02_Switch_Page() {
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
	
	@Test
	public void User_03_Dynamic_Page_01() {
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");
		customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Customer info");
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		customerInfoPage.openPageAtMyAccountByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		addressPage.openPageAtMyAccountByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
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



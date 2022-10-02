

package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {
	String osName = System.getProperty("os.name");
	private WebDriver driver;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userEmailAddress  = "nguyenntd2808@hotmail.net";
		userPassword = "111111";
		
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {	
		// Home Page -> Login Page (User)
		userLoginPage =	userHomePage.openLoginPage();
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
				
		// Home Page -> Customer Info
		userCustomerInfoPage = userHomePage.openMyAccountPage();

		// Customer Info -> Click Logout -> Home Page
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);
		
		// User Home Page -> Open Admin page -> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		// Dashboard Page -> Click Logout -> Login Page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}
  
	@Test
	public void Role_02_Admin_To_User() {
		// Login Page (Admin) -> Open User URL -> Home Page (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		// Home Page -> Login Page (User)
		userLoginPage = userHomePage.openLoginPage();
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
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



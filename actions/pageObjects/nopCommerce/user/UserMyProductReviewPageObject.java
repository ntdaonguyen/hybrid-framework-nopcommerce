package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

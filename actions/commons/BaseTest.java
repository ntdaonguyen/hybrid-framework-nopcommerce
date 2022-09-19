package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	
//	protected WebDriver getBrowserName(String browserName) {
//	if (browserName.equals("firefox")) {
//		if (osName.contains("Mac")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//	}
//		else if (browserName.equals("chrome")) {
//			if (osName.contains("Mac")) {
//				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//				driver = new ChromeDriver();
//			}
//			else
//			{
//				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//				driver = new ChromeDriver();
//			}
//		} else {
//			throw new RuntimeException("Browser name invalid");
//		}
//	return driver;
//	}};
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	driver.manage().window().maximize();
//	driver.get("https://demo.nopcommerce.com/");
//}

	protected WebDriver getBrowserName(String browserName) {
		if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();	
		} 
		else 
		{
			throw new RuntimeException("Browser name invalid");
		}
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://demo.nopcommerce.com/");
	return driver;
}
}

package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

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
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equals("h_chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
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

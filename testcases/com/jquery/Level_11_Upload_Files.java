

package com.jquery;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	String osName = System.getProperty("os.name");
	private WebDriver driver;
	private HomePageObject homePage;
	String japanFileName = "japan.jpg";
	String koreaFileName = "korea.jpg";
	String vietnamFileName = "vietnam.jpg";

	String[] multipleFileNames = {japanFileName, koreaFileName, vietnamFileName};
 
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserName(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 01 - Load single file
		homePage.uploadMultipleFiles(driver, vietnamFileName);
		
		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(vietnamFileName));
		
		// Step 03 - Click to Start button
		homePage.clickToStartButton();
		
		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(vietnamFileName));
		
		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(vietnamFileName));

	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		// Step 01 - Load multiple file
		homePage.uploadMultipleFiles(driver, multipleFileNames);
				
		// Step 02 - Verify multiple file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(japanFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(koreaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(vietnamFileName));
				
		// Step 03 - Click to Start button
		homePage.clickToStartButton();
				
		// Step 04 - Verify multiple file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(japanFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(koreaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(vietnamFileName));
				
		// Step 05 - Verify multiple file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(japanFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(koreaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(vietnamFileName));
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}



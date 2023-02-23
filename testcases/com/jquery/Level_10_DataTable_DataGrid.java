

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
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	String osName = System.getProperty("os.name");
	private WebDriver driver;
	private HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserName(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	public void Table_01_Paging() {		
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("5"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
	}
  
	
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Females", "750");
		homePage.enterToHeaderTextboxByLabel("Country", "Aruba");
		homePage.enterToHeaderTextboxByLabel("Males", "756");
		homePage.enterToHeaderTextboxByLabel("Total", "1504");
		homePage.sleepInSecond(1);
		homePage.enterToHeaderTextboxByLabel("Females", "1090");
		homePage.enterToHeaderTextboxByLabel("Country", "Tonga");
		homePage.enterToHeaderTextboxByLabel("Males", "1210");
		homePage.enterToHeaderTextboxByLabel("Total", "2300");
	}
	
	public void Table_03_Get_All_Data() {
		// Read data from file country.txt
		// Save as a List<String> = expectedAllCountryValues
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();	
		// Value - Parameter 1
		// Row number: which row
		// Ex: Enter to textbox at row 2, 5, 7
		// Column name: 
//		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "VNZ");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "2", "Henry");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "3", "10");
//
//		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Hong Kong");
//		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Japan");
//		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "Taiwan");
//		
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
//		
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.clickToIconByRowNumber("3", "Move Down");
		


	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}



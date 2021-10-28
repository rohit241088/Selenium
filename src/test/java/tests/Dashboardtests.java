package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.baseClass;
import utils.WebDriverEvents;

public class Dashboardtests extends baseClass{
	

	
	
	@BeforeMethod
	public void initialize() {
	
		if(!WebDriverEvents.getCurrentURL().equalsIgnoreCase(baseClass.getConfig("URL"))) {
			WebDriverEvents.loadURL(baseClass.getConfig("URL"));
		
		}
		}
	
	
	
	@Test
	public void validSearchTest() {
		Dashboard.checkSearchWithValidValue("Rohit Sharma");
	//	dashboard.validateResultWithSearch("Rohit Sharma");
	}

	
@Test
	public void validSearchTest2() {
	Dashboard.performSearchWithValue("Rohit Sharma");
	Dashboard.validateResultWithSearch("Anjali");
	}
	
	
	
	@AfterMethod
public void closeBrowser() {
WebDriverEvents.closeBrowser();
	}
	
	
}

package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
public class Dashboardtests{
	private Dashboard dashboard=null;
	
	@BeforeMethod
	public void initialize() {
		dashboard=new Dashboard();
	}
	
	
	@Test
	public void validSearchTest() {
		dashboard.checkSearchWithValidValue("Rohit Sharma");
	//	dashboard.validateResultWithSearch("Rohit Sharma");
	}

	
@Test
	public void validSearchTest2() {
	dashboard.checkSearchWithValidValue("Rohit Sharma");
	}
	
	
	
	@AfterMethod
public void closeBrowser() {
		dashboard.closeBrowser();
		dashboard.clearCurrentThreadDriver();
		

	}
	
	
}

package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;

public class DashboardTest1 {
private Dashboard dashboard=null;
	
	@BeforeMethod
	public void initialize() {
		dashboard=new Dashboard();
	}
	
	
	@Test
	public void validSearchTest() {
		dashboard.checkSearchWithValidValue("Virat Kohli");
	//	dashboard.validateResultWithSearch("Rohit Sharma");
	}

	
@Test
	public void validSearchTest2() {
	dashboard.performSearchWithValue("Virat Kohli");
	dashboard.validateResultWithSearch(" ");
	}
	
	
	
	@AfterMethod
public void closeBrowser() {
		dashboard.closeBrowser();
		

	}
}

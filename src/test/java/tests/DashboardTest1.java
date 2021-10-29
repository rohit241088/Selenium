package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;

public class DashboardTest1 extends BaseTest{
private Dashboard dashboard=null;
	
	@BeforeMethod
	public void initialize() {
		dashboard=new Dashboard();
	}
	
	
	@Test
	public void validSearchTest() {
		Dashboard.checkSearchWithValidValue("Virat Kohli");
	//	dashboard.validateResultWithSearch("Rohit Sharma");
	}

	
@Test
	public void validSearchTest2() {
	Dashboard.performSearchWithValue("Virat Kohli");
	Dashboard.validateResultWithSearch(" ");
	}
	
	
	
	@AfterMethod
public void closeBrowser() {
		dashboard=null;
		

	}
}

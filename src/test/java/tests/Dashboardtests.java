package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import src.baseClass2;
import utils.WebDriverEvents2;
public class Dashboardtests extends BaseTest{
	private Dashboard dashboard=null;
	
	@BeforeMethod
	public void initialize() {
		baseClass2.getConfig();
		baseClass2.getPageObjects();
		WebDriverEvents2.setDriver(BaseTest.getDriver());
		WebDriverEvents2.LoadURL(baseClass2.getConfig().getProperty("URL"));
		}
	
	
	@Test
	public void validSearchTest() {
		Dashboard.checkSearchWithValidValue("Rohit Sharma");
	//	dashboard.validateResultWithSearch("Rohit Sharma");
	}

	
@Test
	public void validSearchTest2() {
	Dashboard.performSearchWithValue("Rohit Sharma");
	Dashboard.validateResultWithSearch(" ");
	}
	
	
	
	@AfterMethod
public void closeBrowser() {
	BaseTest.setDriverNull();
	
		

	}
	
	
}

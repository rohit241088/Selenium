package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Dashboard;

public class Dashboardtests {
	
	private Dashboard dashboard=null;
	
	
	@BeforeMethod
	public void initialize() {
		dashboard=new Dashboard();
	}
	
	
	
	@Test
	public void runSearchTest() {
		dashboard.checkSearchWithValidValue("Rohit Sharma");
	}

}

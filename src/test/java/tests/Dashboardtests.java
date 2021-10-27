package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import pageObjects.baseClass;
import utils.WebDriverEvents;

public class Dashboardtests{
	
	private Dashboard dashboard=null;
	
	
	
	
	@BeforeMethod
	public void initialize() {
		dashboard=new Dashboard();
		if(!WebDriverEvents.getCurrentURL().equalsIgnoreCase(baseClass.getConfig("URL"))) {
			WebDriverEvents.loadURL(baseClass.getConfig("URL"));
		}
	}
	
	
	
	@Test
	public void runSearchTest() {
		dashboard.checkSearchWithValidValue("Rohit Sharma");
	}

}

package tests;


import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;


public class DashboardTest2 extends Basetest {
	
	private Dashboard dashboard=null;
	
	
	
	@BeforeMethod
	public void initializePage() {
		dashboard=new Dashboard(super.getWebEvents2(), super.getBase().getPageObjects());
	}
	
	
	@Test
	public void validSearchTest() {
		String searchValue="Viraj Sharma";
		dashboard.typeInSearch(searchValue);
		dashboard.clickSearchButton();	
		Assert.assertTrue(dashboard.verifySearchResults(searchValue));
		
		}
		

	@Test
	public void validSearchTest1() {
		String searchValue="Anushka Sharma";
		dashboard.typeInSearch(searchValue);
		dashboard.clickSearchButton();	
		Assert.assertTrue(dashboard.verifySearchResults(searchValue));
		
		}
		
	

	
	//@Test
	public void validSearchTest2() {
		String searchValue="virat kohli";

	
			
		}
		
	
	}

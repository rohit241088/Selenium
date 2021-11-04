package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;


public class DashboardTest1 extends Basetest {
	
	private Dashboard dashboard=null;
	
	
	
	@BeforeMethod
	public void initializePage() {
		dashboard=new Dashboard(super.getWebEvents2(), super.getBase().getPageObjects());
	}
	
	
	@Test
	public void validSearchTest() {
		String searchValue="Rohit Sharma";
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
		
	

	
	
		
	
	}

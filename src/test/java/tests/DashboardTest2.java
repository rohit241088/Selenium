package tests;


import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import utils.LoggerClass;


public class DashboardTest2 extends Basetest {
	
	private Dashboard dashboard=null;
	private static Logger logger=LoggerClass.getLogger();
	
	
	@BeforeMethod(alwaysRun=true)
	public void initializePage() {
		dashboard=new Dashboard(super.getWebEvents2(), super.getBase().getPageObjects());
	}
	
	
	@Test
	public void validSearchTest() {
		String searchValue="Viraj Sharma";
		boolean match=false;
		String []allSearchValues=searchValue.split(" ");
		dashboard.typeInSearch(searchValue);
		dashboard.clickSearchButton();	
		List<WebElement>allElementsText=dashboard.getSearchResults();
		Iterator<WebElement>elementIterator=allElementsText.iterator();
		while(elementIterator.hasNext()) {
			String elementText=elementIterator.next().getText();
			for(String s:allSearchValues) {
				if(elementText.contains(s));
				match=true;
				break;
			}
			logger.debug("Element text "+elementText+" search value "+searchValue+" matched "+match);

			Assert.assertTrue(match);
		}
		}
		

	@Test
	public void validSearchTest1() {
		String searchValue="Anushka Sharma";
		boolean match=false;
		String []allSearchValues=searchValue.split(" ");
		dashboard.typeInSearch(searchValue);
		dashboard.clickSearchButton();	
		List<WebElement>allElementsText=dashboard.getSearchResults();
		Iterator<WebElement>elementIterator=allElementsText.iterator();
		while(elementIterator.hasNext()) {
			String elementText=elementIterator.next().getText();
			for(String s:allSearchValues) {
				if(elementText.contains(s));
				match=true;
				break;
			}
			logger.debug("Element text "+elementText+" search value "+searchValue+" matched "+match);

			Assert.assertTrue(match);
		}
		}
		
	

	
	//@Test
	public void validSearchTest2() {
		String searchValue="virat kohli";

	
			
		}
		
	
	}

package tests;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import src.baseClass2;
import utils.LoggerClass;
import utils.TestNGListenerClass;
import utils.WebDriverEvents2;

public class Basetest {
 private static Logger logger=null;
 private static baseClass2 base=null;
 private static WebDriverEvents2 webEvents2=null;
 private static TestNGListenerClass listener=null;
 
 @BeforeSuite
 public void initial() {
	 listener=new TestNGListenerClass();
	 logger=LoggerClass.getLogger();
		base=new baseClass2();
		base.setConfig();
		base.setPageObject();
 }
 
 @AfterSuite
 public void cleanUp() {
	 base=null;
	 logger=null;
 }
 
 
	@BeforeTest
	public void setupConfig() {
	
			
	}
	
	public baseClass2 getBase() {
		return base;
	}
	
	public String[] getPageElementMap(String elementkey) {
		String element=base.getPageObjects().getProperty(elementkey);
		logger.debug("location element with pageObject key "+element);
		logger.debug("Element value from object properties file "+element);
		String locatorType=element.split("///")[1];
		String locatorValue=element.split("///")[0];
		String[]keyValues=new String[2];
		keyValues[0]=locatorType;
		keyValues[1]=locatorValue;
		return keyValues;
	}
	
	
	
	
	@BeforeMethod
	public void setUpTest() {
		base.setupDriver();
		loadAppURL();
		webEvents2=new WebDriverEvents2(base.getWebDriver());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		base.getWebDriver().close();
		base.clearCurrentThreadDriver();
		webEvents2=null;
				
	}
	
	public void loadAppURL() {
		String url=base.getConfig().getProperty("URL");
		logger.debug("Loading URL "+url+" in browser" );
		base.getWebDriver().get(url);
		logger.debug("Loaded URL "+url+" in browser" );
	}
	
public WebDriver getDriver() {
	return base.getWebDriver();
}



public WebDriverEvents2 getWebEvents2() {
	return webEvents2;
}


	
}

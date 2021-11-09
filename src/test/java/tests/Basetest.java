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
import utils.WebHandler;

public class Basetest {
 private static Logger logger=null;
 private static baseClass2 base=null;
 private static WebHandler webEvents2=null;
 private static TestNGListenerClass listener=null;
 
 @BeforeSuite(alwaysRun = true)
 public void initial() {
	 listener=new TestNGListenerClass();
	 logger=LoggerClass.getLogger();
		base=new baseClass2();
		base.setConfig();
		base.setPageObject();
		webEvents2=new WebHandler(base);

 }
 
 @AfterSuite(alwaysRun=true)
 public void cleanUp() {
	 base=null;
	 logger=null;
	 webEvents2=null;
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
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public void setUpTest() {
		webEvents2.loadAppURL();
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
	webEvents2.closeBrowser();
	webEvents2.clearThreadedDriver();
	
				
	}
	
		
public WebDriver getDriver() {
	return webEvents2.getThreadSafeDriver();
}



public WebHandler getWebEvents2() {
	return webEvents2;
}


	
}

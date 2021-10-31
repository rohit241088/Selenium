package tests;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import src.baseClass2;
import utils.LoggerClass;
import utils.WebDriverEvents2;

public class Basetest {
 private static Logger logger=LoggerClass.getLogger();
 private baseClass2 base=null;
 private WebDriverEvents2 webEvents2=null;
 private static WebDriver driver=null;
	@BeforeTest
	public void setupConfig() {
		base=new baseClass2();
	base.setConfig();
	base.setPageObject();
			
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
	driver=base.getWebDriver();
		this.loadAppURL();
		webEvents2=new WebDriverEvents2(driver);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		base.getWebDriver().close();
	}
	
	public void loadAppURL() {
		String url=base.getConfig().getProperty("URL");
		logger.debug("Loading URL "+url+" in browser" );
		driver.get(url);
		logger.debug("Loaded URL "+url+" in browser" );
	}
	
public WebDriver getDriver() {
	return driver;
}



public WebDriverEvents2 getWebEvents2() {
	return webEvents2;
}


	
}

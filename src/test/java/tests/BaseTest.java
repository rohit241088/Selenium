package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import src.WebDriverEventListener;
import src.baseClass2;
import utils.LoggerClass;
import utils.WebDriverEvents2;

public class BaseTest {
	private static ThreadLocal<WebDriver>drivers=null;
	private static Logger logger=LoggerClass.getLogger();
	
	
	
	
//		public static void launchApp() {
//		WebDriverEvents2.setDriver(BaseTest.getDriver());
//		WebDriverEvents2.LoadURL(baseClass2.getConfig().getProperty("URL"));
//		
//	}
	
	
	
	
	
	public static void loadAppURL(String url) {
		
		WebDriver driver=null;
		if(drivers.get()==null||drivers==null) {
			driver=getDriver();
		}
		logger.debug("Loading URL "+url+" in browser" );
		driver.get(baseClass2.getConfig().getProperty("URL"));
		logger.debug("Loaded URL "+url+" in browser" );


	}
	
	public static void setDriverNull(){
		drivers.set(null);
	}
	
	public static WebDriver getDriver(){
	
		if(drivers==null) {
			drivers=new ThreadLocal<>();
			WebDriver driver=null;
			
		WebDriverEventListener events=null;
			//this.setConfig();
			String browser=baseClass2.getConfig().getProperty("Driver");
			switch(browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
				events=new WebDriverEventListener();
				driver=new ChromeDriver();
				driver=new EventFiringDecorator(events).decorate(driver);
				driver.manage().window().maximize();
				drivers.set(driver);
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\geckodriver-v0.30.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver=new EventFiringDecorator(events).decorate(driver);
				driver.manage().window().maximize();
				drivers.set(driver);
				break;
		}
		}
		
		if(drivers.get()==null) {
			{			
				WebDriver driver=null;
		WebDriverEventListener events=null;
		//this.setConfig();
		String browser=baseClass2.getConfig().getProperty("Driver");
		switch(browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			events=new WebDriverEventListener();
			driver=new ChromeDriver();
			driver=new EventFiringDecorator(events).decorate(driver);
			driver.manage().window().maximize();
			drivers.set(driver);
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\geckodriver-v0.30.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver=new EventFiringDecorator(events).decorate(driver);
			driver.manage().window().maximize();
			drivers.set(driver);
			break;
			}
		}
		}
		
		return drivers.get();
	}
	
	
	
	
	
}

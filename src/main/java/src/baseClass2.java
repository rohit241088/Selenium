package src;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import src.WebDriverEventListener;
import utils.LoggerClass;
public class baseClass2 {
	
	

	/**
	 * @author rohit
	 *
	 */
private static ThreadLocal<WebDriver>driverThreads=null;
		private FileInputStream in=null;
		private Properties properties=null;
		private Properties config=null;
		private WebDriver driver=null;
		private Logger logger=LoggerClass.getLogger();
		public baseClass2() {
			this.setConfig();
			this.setPageObject();
			this.setupDriver();
			this.loadAppURL(config.getProperty("URL"));
		}
		
		
		

		public void setConfig() {
			if(config==null) {
				
			try {
				logger.debug("Initiailizatoin confirguration properties file");
				String filepath=System.getProperty("user.dir")+"//DataFiles//config.properties";
				in=new FileInputStream(filepath);
				logger.debug("Loaded confirguration properties file with path "+filepath);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			config=new Properties();
			try {
				config.load(in);
				logger.debug("Initiailized confirguration properties file with following attributes");
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
				}
		
		
		public  void setPageObject() {
			if(properties==null) {
				logger.debug("Initiailizatoin page object properties file");

			try {
				String filePath=System.getProperty("user.dir")+"//DataFiles//pageObject.properties";
				logger.debug("Object properties file path is "+filePath);

				in=new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			properties=new Properties();
			try {
				properties.load(in);
				logger.debug("Loaded Object properties file");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
				}
		
		
		public WebDriver getThreadedDriver() {
			
			return driverThreads.get();
		}
		
		public void clearCurrentThreadDriver() {
			driverThreads.set(null);
		}
		
		public void setupDriver() {
			if(driverThreads==null) {
				driverThreads=new ThreadLocal<>();
				WebDriverEventListener events=null;
				//this.setConfig();
				String browser=this.config.getProperty("Driver");
				switch(browser) {
				case "Chrome":
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
					events=new WebDriverEventListener();
					driver=new ChromeDriver();
					driver=new EventFiringDecorator(events).decorate(driver);
					driver.manage().window().maximize();
					driverThreads.set(driver);
			}
			}
			
			if(driverThreads.get()==null) {
				{			
			WebDriverEventListener events=null;
			//this.setConfig();
			String browser=this.config.getProperty("Driver");
			switch(browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
				events=new WebDriverEventListener();
				driver=new ChromeDriver();
				driver=new EventFiringDecorator(events).decorate(driver);
				driver.manage().window().maximize();
				driverThreads.set(driver);
				}
			}
			}
			}
			
		
		public void loadAppURL(String url) {
			WebDriver driver=driverThreads.get();
			if(driverThreads.get()==null||driverThreads==null) {
				this.setupDriver();
			}
			logger.debug("Loading URL "+url+" in browser" );
			driver.get(config.getProperty("URL"));
			logger.debug("Loaded URL "+url+" in browser" );


		}
		
		

		public FileInputStream getIn() {
			return in;
		}






		public Properties getProperties() {
			return properties;
		}






		public Properties getConfig() {
			return config;
		}






		public WebDriver getDriver() {
			return driver;
		}






//		public String getConfig(String key) {
//			if(config==null) {
//				
//			try {
//				LoggerClass.getLogger().debug("Initiailizatoin confirguration properties file");
//				String filepath=System.getProperty("user.dir")+"//DataFiles//config.properties";
//				in=new FileInputStream(filepath);
//				LoggerClass.getLogger().debug("Loaded confirguration properties file with path "+filepath);
//
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			config=new Properties();
//			try {
//				config.load(in);
//				LoggerClass.getLogger().debug("Initiailized confirguration properties file with following attributes");
//				} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			}
//			LoggerClass.getLogger().debug("Returning element "+config.getProperty(key));
//
//				return config.getProperty(key);
//				}
//		
//		
//		public  String getPageObjectValue(String key) {
//			if(properties==null) {
//				LoggerClass.getLogger().debug("Initiailizatoin page object properties file");
//
//			try {
//				String filePath=System.getProperty("user.dir")+"//DataFiles//pageObject.properties";
//				LoggerClass.getLogger().debug("Object properties file path is "+filePath);
//
//				in=new FileInputStream(filePath);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			properties=new Properties();
//			try {
//				properties.load(in);
//				LoggerClass.getLogger().debug("Loaded Object properties file");
//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			}
//				return properties.getProperty(key);
//				}
//		
//		public WebDriver returnDriver() {
//			
//			WebDriverEventListener events=null;
//			WebDriver driver2=null;
//
//			if(driver2==null) {
//				WebDriver driver=null;
//				String browser=this.getConfig("Driver");
//			switch(browser) {
//			case "Chrome":
//				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
//				events=new WebDriverEventListener();
//				driver=new ChromeDriver();
//				driver2=new EventFiringDecorator(events).decorate(driver);
//				driver2.manage().window().maximize();
//				
//			}
//			}
//			return driver2;
//		}
//		
//		public void loadURL(String URL) {
//			logger.debug("Loading URL "+URL+" in browser" );
//			driver.get(URL);
//			logger.debug("Loaded URL "+URL+" in browser" );
//
//
//		}
//	 
//	
	

	

}



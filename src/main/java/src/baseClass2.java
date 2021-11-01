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
		private static FileInputStream in=null;
		private static Properties properties=null;
		private static Properties config=null;

		public void setConfig() {
			if(config==null) {
				
			try {
				LoggerClass.getLogger().debug("Initiailizatoin confirguration properties file");
				String filepath=System.getProperty("user.dir")+"//DataFiles//config.properties";
				in=new FileInputStream(filepath);
				LoggerClass.getLogger().debug("Loaded confirguration properties file with path "+filepath);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			config=new Properties();
			try {
				config.load(in);
				LoggerClass.getLogger().debug("Initiailized confirguration properties file with following attributes");
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
				}
		
		
		public void setPageObject() {
			if(properties==null) {
				LoggerClass.getLogger().debug("Initiailizatoin page object properties file");

			try {
				String filePath=System.getProperty("user.dir")+"//DataFiles//pageObject.properties";
				LoggerClass.getLogger().debug("Object properties file path is "+filePath);

				in=new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			properties=new Properties();
			try {
				properties.load(in);
				LoggerClass.getLogger().debug("Loaded Object properties file");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
				}
		
		
		public WebDriver getWebDriver() {
			
			return driverThreads.get();
		}
		
		public void clearCurrentThreadDriver() {
			driverThreads.set(null);
		}
		
		public void setupDriver() {
			WebDriverEventListener events=null;
			driverThreads=new ThreadLocal<>();
			WebDriver driver=null;
			//this.setConfig();
			String browser=config.getProperty("Driver");
			switch(browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
				events=new WebDriverEventListener();
				driver=new ChromeDriver();
				WebDriver driver2=new EventFiringDecorator(events).decorate(driver);
					driver2.manage().window().maximize();
				driverThreads.set(driver2);
				}
			}
			
		
			

		public FileInputStream getIn() {
			return in;
		}






		public Properties getPageObjects() {
			return properties;
		}






		public Properties getConfig() {
			return config;
		}









	

	

}



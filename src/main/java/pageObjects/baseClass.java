package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import src.WebDriverEventListener;
import utils.LoggerClass;

public class baseClass {
	private static FileInputStream in=null;
	private static Properties properties=null;
	private static Properties config=null;
	private static WebDriver driver=null;
	public baseClass() {
		
	}
	
	
	public static String getConfig(String key) {
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
		LoggerClass.getLogger().debug("Returning element "+config.getProperty(key));

			return config.getProperty(key);
			}
	public static String getPageObjectValue(String key) {
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
			return properties.getProperty(key);
			}
	
	public static WebDriver returnDriver() {
		
		WebDriverEventListener events=null;
		WebDriver driver2=null;

		if(driver2==null) {
			WebDriver driver=null;
			String browser=baseClass.getConfig("Driver");
		switch(browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			events=new WebDriverEventListener();
			driver=new ChromeDriver();
			driver2=new EventFiringDecorator(events).decorate(driver);
			driver2.manage().window().maximize();
			
		}
		}
		return driver2;
	}
	

 
}

package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
	private static FileInputStream in=null;
	private static Properties properties=null;
	private static Properties config=null;
	private static WebDriver driver=null;
	public baseClass() {
		
	}
	private static String getConfig(String key) {
		if(config==null) {
		try {
			in=new FileInputStream(System.getProperty("user.dir")+"//DataFiles//config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config=new Properties();
		try {
			config.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			return config.getProperty(key);
			}
	private static String getPageObjectValue(String key) {
		if(properties==null) {
		try {
			in=new FileInputStream(System.getProperty("user.dir")+"//DataFiles//pageObject.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties=new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			return properties.getProperty(key);
			}
	
	public static WebDriver returnDriver() {
		String browser=baseClass.getConfig("Driver");
		if(driver==null) {
		switch(browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(baseClass.getConfig("URL"));
			driver.manage().window().maximize();
		}
		}
		return driver;
	}
	
	private static By returnBy(String key) {
		By element=null;
		String locator=baseClass.getPageObjectValue(key).split("///")[1];
		switch(locator) {
		case "xpath":
			element= By.xpath(baseClass.getPageObjectValue(key).split("///")[0]);
		}
		return element;
	}
  public static WebElement returnElement(String key) {
	 return returnDriver().findElement(baseClass.returnBy(key));
  }
}

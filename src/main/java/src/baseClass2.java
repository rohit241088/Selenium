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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import src.WebDriverEventListener;
import utils.LoggerClass;
public class baseClass2 {
	
	

	/**
	 * @author rohit
	 *
	 */
		private static FileInputStream in=null;
		private static Properties properties=null;
		private static Properties config=null;
		private static Logger logger=LoggerClass.getLogger();
			
		

		public static Properties getConfig() {
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
			return config;
			
				}
		
		
		public static Properties getPageObjects() {
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
			return properties;
				}
		
		
	
		public static FileInputStream getIn() {
			return in;
		}






		public static Properties getProperties() {
			return properties;
		}



	

	

}



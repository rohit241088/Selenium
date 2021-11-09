package src;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import utils.LoggerClass;
public class baseClass2 {
	
	

	/**
	 * @author rohit
	 *
	 */

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



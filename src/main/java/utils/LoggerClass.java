
package utils;
import java.io.File;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class LoggerClass {

	private static Logger logger=null;
	
	public static Logger getLogger() {
		if(logger==null) {
			logger=LogManager.getLogger(LoggerClass.class);
		RollingFileAppender fileAppender=new RollingFileAppender();
		ConsoleAppender consoleAppender=new ConsoleAppender();
		PatternLayout layout=new PatternLayout();
		layout.setConversionPattern("%-5p [%t]: %m%n");
		fileAppender.setLayout(layout);
		String filePath=System.getProperty("user.dir")+"\\DataFiles\\Logger.log";
		fileAppender.setFile(filePath);
		System.out.println("Filepath is "+filePath);
		fileAppender.setAppend(false);
		fileAppender.activateOptions();
		logger.setLevel(Level.DEBUG);
		logger.addAppender(fileAppender);
		logger.addAppender(consoleAppender);
		logger.setAdditivity(true);
		
		}
		return logger;
}
	
	
	
}

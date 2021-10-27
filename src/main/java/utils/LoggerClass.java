
package utils;
import java.io.File;

import org.apache.log4j.Appender;
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

	private static Logger logger=LogManager.getRootLogger();
	
	public static Logger getLogger() {
		if(logger==null) {
		RollingFileAppender fileAppender=new RollingFileAppender();
		ConsoleAppender consoleAppender=new ConsoleAppender();
		PatternLayout layout=new PatternLayout();
		fileAppender.setLayout(layout);
		fileAppender.setFile(System.getProperty("user.dir")+"/youtube/DataFiles/Logger.log");
		fileAppender.setAppend(true);
		fileAppender.activateOptions();
		logger.setLevel(Level.DEBUG);
		logger.addAppender(fileAppender);
		logger.addAppender(consoleAppender);
		logger.setAdditivity(true);
		
		}
		return logger;
}
	
	
	
}

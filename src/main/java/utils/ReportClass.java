package utils;

import java.util.Iterator;
import java.util.List;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportClass {
	private static ExtentReports report=null;

	public static ExtentReports getReporter() {
		if(report==null) {
			report=new ExtentReports();
	
		List<String> s=Reporter.getOutput();
			Iterator<String>testNGReporterIterator=s.iterator();
				while(testNGReporterIterator.hasNext()) {
				report.addTestRunnerOutput(testNGReporterIterator.next());
			}
							
			}
		
		return report;
	}
	
	

}

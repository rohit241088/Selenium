package utils;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenerClass implements ITestListener {
	
	 @Override
	public void onTestStart(ITestResult result) {
	    // not implemented
		
		
		LoggerClass.getLogger().debug("Starting test case "+result.getTestName());
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	 @Override
	  public void onTestSuccess(ITestResult result) {
	    // not implemented
			LoggerClass.getLogger().debug("Test case "+ result.getTestName()+" successful");

	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	 @Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
			LoggerClass.getLogger().debug("Test "+result.getTestName()+" failed");

	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	 @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
			LoggerClass.getLogger().debug("Test "+result.getTestName()+" skipped");

	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	 @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	 @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	 @Override
	  public void onStart(ITestContext context) {
	    // not implemented
			LoggerClass.getLogger().debug("Method called before all test cases in class "+context.getName());

	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	 @Override
	  public void onFinish(ITestContext context) {
	    // not implemented
			LoggerClass.getLogger().debug("Method called after all test cases in class "+context.getName());

	  }
	
	
}

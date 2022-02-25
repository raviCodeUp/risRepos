package CommonPack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
    Reporter.log("Test started: "+result.getName());
	}
	public void onTestSuccess(ITestResult result) {
	    Reporter.log("Passed: "+result.getName());
		}
	public void onTestFailure(ITestResult result) {
		Reporter.log("Failed: "+result.getName());
		}
	public void onTestSkipped(ITestResult result) {
	    Reporter.log("Skipped Test Name: "+result.getName());
		}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    Reporter.log("Failed: ButWithinSuccessPercentage Method Name: "+result.getName());
		}
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
		}
	public void onStart(ITestContext context) {
	   
		}
	public void onFinish(ITestContext context) {
	    
		}
}

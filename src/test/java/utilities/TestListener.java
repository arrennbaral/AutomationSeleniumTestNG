package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import utilities.TakeScreenShot;
import base.BaseTest; 

public class TestListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		
		String testName = result.getName();
		TakeScreenShot.captureScreenshot(driver, testName);
	}

}

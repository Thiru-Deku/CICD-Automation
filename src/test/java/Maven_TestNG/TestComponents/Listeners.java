package Maven_TestNG.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testng.source.extentReportNG;

public class Listeners extends Base_Test implements ITestListener {

//	ExtentTest test;
//	ExtentReports report = extentReportNG.getReportObj();
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
//    
//	@Override
//	public void onTestStart(ITestResult result) {
//		
//		test = report.createTest(result.getMethod().getMethodName());
//	    extentTest.set(test);// unique thread id(ErrorValidationTest)->test
//		
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, "test is passed");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		test.fail(result.getThrowable());
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstanceName());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}	
//		String filePath = null;
//		try {
//		 filePath = getScreenshot(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
//		
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		
//		
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		
//		
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		report.flush();		
//	}
//	

	ExtentTest test;
	ExtentReports extent = extentReportNG.getReportObj();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());//

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = null;
		try {

			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		// Screenshot, Attach to report
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { // TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}

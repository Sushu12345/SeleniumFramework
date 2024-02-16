package SushuPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import SushuPractice.Basetest;
import SushuPractice.resources.ExtentReportNG;


public class Listeners extends Basetest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
	  test = extent.createTest(result.getMethod().getMethodName());
	  extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Succcess");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String filepath = null;
		try {
		driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		}catch (IOException e){
			e.printStackTrace();
		}
		((ExtentTest) test).addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

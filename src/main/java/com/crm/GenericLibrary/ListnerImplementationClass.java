package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnerImplementationClass implements ITestListener

{
   ExtentReports report;
   ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		String testscriptName= result.getMethod().getMethodName();
		test=report.createTest(testscriptName);
		
	}

	public void onTestSuccess(ITestResult result) {
		String testscriptName = result.getMethod().getMethodName();
		//Reporter.log(testscriptName+" The Test Script Executed Successfully");
		test.log(Status.PASS, testscriptName+"-----> Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String path = null;
		
		String testscriptName = result.getMethod().getMethodName();
		
		Reporter.log(testscriptName+" The Test Script execution failed");
		String date = new JavaUtility().getSystemDateFormat();
		String screenhotName = testscriptName+"-"+date;
		try {
			//new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenhotName);
			
			TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			path = "./Screenshot/"+screenhotName+".png";
			File dst= new File(path);
			Files.copy(src, dst);
			}
			 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL,testscriptName+"------> failed" );
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path)	;	
	}

	public void onTestSkipped(ITestResult result) {
		
		String testscriptName = result.getMethod().getMethodName();
		Reporter.log(testscriptName+" The Test Script Execution Skipped");
		test.log(Status.SKIP, testscriptName+ "-----> skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context)
	{
		/*Execution will start from here*/
		/*configure the report*/
		 ExtentSparkReporter htmlReporter= new ExtentSparkReporter("./ExtendReports/report"+new JavaUtility().getSystemDateFormat()+".html");
		 htmlReporter.config().setDocumentTitle("SDET-30 Executable Report");
		 htmlReporter.config().setTheme(Theme.DARK);
		 htmlReporter.config().setReportName("Selenium Execution Report");
		 
		 report= new ExtentReports();
		 report.attachReporter(htmlReporter);
		 report.setSystemInfo("Base-Browser", "Chrome");
		 report.setSystemInfo("OS", "Windows");
		 report.setSystemInfo("Base-URl", "http://localhost:8888");
		 report.setSystemInfo("Reporter Name", "Sreejith KV");
		 
		 
	
		
	}

	public void onFinish(ITestContext context) {
		//consolidate all the parameters and generate the report
		report.flush();
		
	}

	
}

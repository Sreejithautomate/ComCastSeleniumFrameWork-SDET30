package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{
     int count =0;
     int retyCount=3;
	
	public boolean retry(ITestResult result) {
		while (count<retyCount)
		{
			count++;
			return true;
			
		}
		return false;
	}

}

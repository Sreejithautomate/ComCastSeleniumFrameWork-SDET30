package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
   public void practiceRetryAnalyser()
   {
	   System.out.println(" tc failed");
	   Assert.fail();
	   System.out.println(" tc Passed");
   }
   
}

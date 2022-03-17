package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest
 {
	
	@Test
	public void readDataFromCmdLineTest()
	{
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME= System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		
		System.out.println("Browser name is ===>"+ BROWSER);
		System.out.println("URL :===>"+URL);
		System.out.println("USERNAME :===>"+USERNAME);
		System.out.println("PASSWORD :===>"+PASSWORD);
		
		
		
	}

}

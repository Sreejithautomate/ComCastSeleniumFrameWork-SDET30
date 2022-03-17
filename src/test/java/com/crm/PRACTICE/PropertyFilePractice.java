package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	
	@Test
	
	public void propertyFilePractice() throws IOException
	{
		//step1 : read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: create Object of Property file
		 Properties pOBJ = new Properties();
		 
		 //Step 3 : load the property file
		 pOBJ.load(fis);
		 
		 String BROWSER = pOBJ.getProperty("Browser");
		 String URL = pOBJ.getProperty("Url");
		 String USERNAME = pOBJ.getProperty("Username");
		 String PASSWORD = pOBJ.getProperty("Password");
		 
		 System.out.println(BROWSER);
		 
		 
		 
		
		
	}

}

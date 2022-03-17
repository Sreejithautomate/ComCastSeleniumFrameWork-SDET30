package com.crm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuiteXMLFIleTest {
	@Test
	public void readDataFormXML(XmlTest xml)
	{
		String BROWSER = xml.getParameter("Browser");
		String URL = xml.getParameter("Url");
		String USERNAME = xml.getParameter("Username");
		String PASSWORD = xml.getParameter("Password");
		
		
		System.out.println(" BROWSER is ===>"+ BROWSER);
	}

}

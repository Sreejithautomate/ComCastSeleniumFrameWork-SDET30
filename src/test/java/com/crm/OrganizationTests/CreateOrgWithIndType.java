package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInformationPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.mysql.cj.protocol.ResultsetRowsOwner;

public class CreateOrgWithIndType extends BaseClass {
	


	@Test
	public void createOrgWithIndHealthCareTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		int random = jLib.getRandomNum();
		String orgName = eLib.readDataFromExcel("Org", 1, 2)+random;
		String indType = eLib.readDataFromExcel("Org", 1, 3);
        
		
		
		/* Click on Organization link*/
		HomePage hp= new HomePage(driver);
		hp.clickonOrgLNK();
		Reporter.log("== Click On Organization ==",true);
		
		
		/* Click on Create Organization img*/
		OrganizationPage orgp= new OrganizationPage(driver);
		orgp.clickOnCreateOrganzationLnk();
		Reporter.log("== Click On Create Organization ==",true);
		
		/*  Create organization with mandatory fields (orgname and indtype) */ 
		CreateOrganizationPage corgp=new CreateOrganizationPage(driver);
		corgp.createNewOrganiza(orgName, indType);
		Reporter.log("== Create  Organization ==",true);
			
		
	
	/*Validating and confirming the organization creation*/
	
	OrganizationInformationPage orginfp= new OrganizationInformationPage(driver);
	String header = orginfp.verifyorganizationName();
	
	if(header.contains(orgName))
	{
		System.out.println(header + " -->"+ "Organization Created successfully");
	}

	else
	{
		System.out.println(" Failed to create Organization");
	}
	

	}
	@Test
	public void sampletest() 
	{
		System.out.println("Sample test === Regional regression");
	}
	
}

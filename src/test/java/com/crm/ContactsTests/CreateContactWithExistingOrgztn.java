package com.crm.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInformationPage;
import com.crm.ObjectRepository.OrganizationPage;

@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)
public class CreateContactWithExistingOrgztn extends BaseClass {
	
	@Test
	public void createContactWithExisOrg() throws IOException {
		
		//read data from excel sheet
		String OrgName = eLib.readDataFromExcel("Org", 1, 3)+jLib.getRandomNum();
		String lastName = eLib.readDataFromExcel("Contact", 1, 2);
	
		
		HomePage hp= new HomePage(driver);
		hp.clickonOrgLNK();
		
		
		Reporter.log("=== Click On Organization Link ===",true);
		
		// Navigate to Organization link
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrganzationLnk();
		Reporter.log("=== Click create On Organization Link ===",true);
		Assert.fail();
		
		
		
		/* Click on Create Organization img*/
		OrganizationPage orgp= new OrganizationPage(driver);
		orgp.clickOnCreateOrganzationLnk();
		Reporter.log("== Click Create  Org ==",true);
		
		/*  Create organization with mandatory fields (orgname,indtype, type) */ 
		CreateOrganizationPage corgp=new CreateOrganizationPage(driver);
		corgp.createNewOrganiza(OrgName);
		Reporter.log("== Create new Org ==",true);
			
		

	/*Validating and confirming the organization creation*/
	OrganizationInformationPage orginfp= new OrganizationInformationPage(driver);
	String header = orginfp.verifyorganizationName();

	if(header.contains(OrgName))
	{
		System.out.println(header + " -->"+ "Organization Created successfully");
	}

	else
	{
		System.out.println(" Failed to create Organization");
	}

		
	   hp.clickonContactLNK();
	   Reporter.log("== Click On Contacts ==",true);
	   
	   ContactsPage cp = new ContactsPage(driver);
	   cp.clickOncreatContactLookUpIMG();
	   Reporter.log("== Click On Create Contacts ==",true);
	   
	   CreateContactsPage ccp=new CreateContactsPage(driver);
      ccp.CreateContacts(driver, lastName, OrgName);
        Reporter.log("== Create Contacts ==",true);
     
     ContactInfoPage cinp=new ContactInfoPage(driver);
     String hder = cinp.ValidateContactCtreation();
     if(hder.contains(lastName))
     {
  	   System.out.println(hder +"-->"+ "Contact is created successfully");
     }
     else 
     {System.out.println( "Contact not created");
  	   
     }
		
	}

}

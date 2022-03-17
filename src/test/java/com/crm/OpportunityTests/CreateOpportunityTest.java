package com.crm.OpportunityTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreatingNewOpportunityPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.OpportunityInfoPage;

@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)
public class CreateOpportunityTest extends BaseClass {
	
	@Test
	public void createOpportunityTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
	
     String optyNameRan = eLib.readDataFromExcel("Opportunity", 1, 2);
     String expClosDate = eLib.readDataFromExcel("Opportunity", 1, 5);
     String relatedTo = eLib.readDataFromExcel("Opportunity", 1, 3);
     String lastName = eLib.readDataFromExcel("Contact", 1, 2);
     String leadsource = eLib.readDataFromExcel("Contact", 1, 3);
     String saleStage = eLib.readDataFromExcel("Opportunity", 1, 6);
     
	 
	 /*  click on contact link*/
	 HomePage hp= new HomePage(driver);
	 hp.clickonContactLNK();
	
	 
	 /*  click on create contact lookup image*/
	 ContactsPage cp= new ContactsPage(driver);
	 cp.clickOncreatContactLookUpIMG();
	 
	 /* creating a contact*/
	 CreateContactsPage ccp= new CreateContactsPage(driver);
	 ccp.CreateContacts(lastName, leadsource);
	 
	 
     /* click on Opportunity link*/
	 hp.clickOnOpprtLink();
	 Assert.fail();
	 
	 /*  click on create new opportunity img */
	 OpportunitiesPage opp= new OpportunitiesPage(driver);
	 opp.createnewOpprtIMG();
	 
	 /*  creating new opportunity*/
	 CreatingNewOpportunityPage copp= new CreatingNewOpportunityPage(driver);
	 
	 copp.createNewOpportnty(optyNameRan, relatedTo, lastName, driver, expClosDate, saleStage);
	  
	 /*   validating the created opportunity*/
	 OpportunityInfoPage opinp=new OpportunityInfoPage(driver);
			String hdr = opinp.getOpprtHdr();
	      if(hdr.contains(optyNameRan))
	      {
		
		System.out.println("Opportunity is created successfully  ---->"+hdr );
		
	}
	      else
	      {
	    	  System.out.println("Opportninity not created");
	    	  }
	      }
}

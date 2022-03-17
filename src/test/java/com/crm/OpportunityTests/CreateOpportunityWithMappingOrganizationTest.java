package com.crm.OpportunityTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.CreatingNewOpportunityPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.OpportunityInfoPage;
import com.crm.ObjectRepository.OrganizationInformationPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOpportunityWithMappingOrganizationTest extends BaseClass{
	
	@Test
	public void createOpportunityWithMappingOrganizationTest() throws IOException, InterruptedException
	{
		;
	      
	    
	     
	       int random = jLib.getRandomNum();
	     
	     String optyNameRan = eLib.readDataFromExcel("Opportunity", 1, 2);
	     String expClosDate = eLib.readDataFromExcel("Opportunity", 1, 5);
	     String relatedTo = eLib.readDataFromExcel("Opportunity", 1, 3);
	     String lastName = eLib.readDataFromExcel("Contact", 1, 2);
	     String orgName = eLib.readDataFromExcel("Org", 1, 2)+random;
	     String saleStage = eLib.readDataFromExcel("Opportunity", 1, 6);
	     
	     
		 
		 
		 /* step 6 : click on contact link*/
		 HomePage hp= new HomePage(driver);
		 hp.clickonContactLNK();
		 
		 /* step 7 : click on create contact lookup image*/
		 ContactsPage cp= new ContactsPage(driver);
		 cp.clickOncreatContactLookUpIMG();
		 
		 /* step 8 : creating a contact*/
		 CreateContactsPage ccp= new CreateContactsPage(driver);
		 ccp.CreateContacts(lastName);
		 
		 /* Step 9: Click On Organization link*/
		 hp.clickonOrgLNK();
		 
		 /* Step 10:click on create Organization  */
		 OrganizationPage orp= new OrganizationPage(driver);
		 orp.clickOnCreateOrganzationLnk();
		 
		 /* step 11 : creating organization*/
		 CreateOrganizationPage corp=new CreateOrganizationPage(driver);
		 corp.createNewOrganiza(orgName);
	     
		 /* step 12 : verfying the organization header*/
		 OrganizationInformationPage orinp= new OrganizationInformationPage(driver);
		 String hdr = orinp.verifyorganizationName();
		 if(hdr.contains(orgName))
		 {
			 System.out.println("Organization is created --->"+ hdr);
		 }
		 else
		 {
			 System.out.println("Organization is not created");
		 }
	     
	     
		 /*step 13 : click on Opportunity link*/
		 hp.clickOnOpprtLink();
		 
		 /* step 14 : click on create new opportunity img */
		 OpportunitiesPage opp= new OpportunitiesPage(driver);
		 opp.createnewOpprtIMG();
		 
		 /* step 15: creating new opportunity*/
		 CreatingNewOpportunityPage copp= new CreatingNewOpportunityPage(driver);
		 
		 copp.createNewOpportnty(optyNameRan, relatedTo, lastName, driver, expClosDate, saleStage);
		  
		 /* Step 16:  validating the created opportunity*/
		 OpportunityInfoPage opinp=new OpportunityInfoPage(driver);
				String opphdr = opinp.getOpprtHdr();
		      if(opphdr.contains(optyNameRan))
		      {
			
			System.out.println("Opportunity is created successfully  ---->"+hdr );
			
		}
		      else
		      {
		    	  System.out.println("Opportninity not created");
		    	  
		      }

		 
	     
	
}
}
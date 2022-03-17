package com.crm.OpportunityTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateOppertunityWithMappingOFExcistingContactPOMTest extends BaseClass
{

@Test
public void createOppertunityWithMappingOFExcistingContactPOMTest() throws EncryptedDocumentException, IOException
{
	String optyNameRan = eLib.readDataFromExcel("Opportunity", 1, 2);
	String expClosDate = eLib.readDataFromExcel("Opportunity", 1, 5);
	String relatedTo = eLib.readDataFromExcel("Opportunity", 1, 3);
	String lastName = eLib.readDataFromExcel("Contact", 1, 2);
	String leadsource = eLib.readDataFromExcel("Contact", 1, 3);
	String saleStage = eLib.readDataFromExcel("Opportunity", 1, 6);



	
	HomePage hp= new HomePage(driver);
	hp.clickonContactLNK();

	/* step 7 : click on create contact lookup image*/
	ContactsPage cp= new ContactsPage(driver);
	cp.clickOncreatContactLookUpIMG();

	/* step 8 : creating a contact*/
	CreateContactsPage ccp= new CreateContactsPage(driver);
	ccp.CreateContacts(lastName, leadsource);

	/*step9 : click on Opportunity link*/
	hp.clickOnOpprtLink();

	/* step 10 : click on create new opportunity img */
	OpportunitiesPage opp= new OpportunitiesPage(driver);
	opp.createnewOpprtIMG();

	/* step 10: creating new opportunity*/
	CreatingNewOpportunityPage copp= new CreatingNewOpportunityPage(driver);

	copp.createNewOpportnty(optyNameRan, relatedTo, lastName, driver, expClosDate, saleStage);

	/* Step 11:  validating the created opportunity*/
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



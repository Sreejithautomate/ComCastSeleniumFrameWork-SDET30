package com.crm.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithOrgazAndEmpAsLeadSrc {
	
	@Test
	public void createContactWithOrgazAndEmpAsLeadSrc() throws IOException, InterruptedException
	{
		PropertyFileUtility pLib= new PropertyFileUtility();
		ExcelFileUtility eLib=new ExcelFileUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		JavaUtility jLib= new JavaUtility();
		
		int random = jLib.getRandomNum();
		
	String BROWSER = pLib.readDateFromPropertyFile("Browser");
	String URL = pLib.readDateFromPropertyFile("Url");
	String USERNAME = pLib.readDateFromPropertyFile("Username");
	String PASSWORD = pLib.readDateFromPropertyFile("Password");
		
		String lastName = eLib.readDataFromExcel("Contact", 1, 2);
		String leadSrc = eLib.readDataFromExcel("Contact", 1, 3);
		String orgName = eLib.readDataFromExcel("Org", 1, 2)+random;
		
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    else if (BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver= new FirefoxDriver();
	    }
	    else
	    {
	    	System.out.println("Invalid Broswer");
	    }
	    
	   wLib.maximizeWindow(driver);
	   wLib.waitForPageLoad(driver);
	   driver.get(URL);
	   
	   /* Lopgin to Application*/
	   LoginPage lp= new LoginPage(driver);
	   lp.loginToApp(USERNAME, PASSWORD);
	   
	   /* Click On Organization link*/
	   HomePage hp = new HomePage(driver);
	   hp.clickonOrgLNK();
	   
	   /* Click On create Organization img*/
	   OrganizationPage orgp=new OrganizationPage(driver);
	   orgp.clickOnCreateOrganzationLnk();
	   
	   /* crreate Organization */
	   CreateOrganizationPage corgp=new CreateOrganizationPage(driver);
	   corgp.createNewOrganiza(orgName);
	   
	   /* Click on contacts Link*/
	   Thread.sleep(2000);
	   hp.clickonContactLNK();
	   
	   /* clikc on create new contact image*/
	   ContactsPage conp= new ContactsPage(driver);
	   conp.clickOncreatContactLookUpIMG();
	   
	   /* Create contact with  Organization and Employee as Lead Source */
	   CreateContactsPage crconp= new CreateContactsPage(driver);
	   crconp.CreateContacts(driver,lastName, leadSrc,orgName);
	   
	   
	   
	   
	   
	}

}

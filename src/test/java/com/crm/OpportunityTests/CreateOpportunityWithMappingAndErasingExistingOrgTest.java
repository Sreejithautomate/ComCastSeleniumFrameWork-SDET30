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

public class CreateOpportunityWithMappingAndErasingExistingOrgTest {
	
	@Test
	public void createOpportunityWithMappingAndErasingExistingOrgTest() throws IOException, InterruptedException
	{
		
		/*  step 1 :  created objects of required utility classes*/
	      JavaUtility jLib= new JavaUtility();
	      PropertyFileUtility pLib=new PropertyFileUtility();
	      ExcelFileUtility eLib= new ExcelFileUtility();
	      WebDriverUtility wLib = new WebDriverUtility();
	      
	      /*Step 2: Reading date from property file and excel sheet */
	     String BROWSER = pLib.readDateFromPropertyFile("Browser");
	     String URL = pLib.readDateFromPropertyFile("Url");
	     String USERNAME = pLib.readDateFromPropertyFile("Username");
	     String PASSWORD = pLib.readDateFromPropertyFile("Password");
	    
	     
	   int random = jLib.getRandomNum();
	     
	     String optyNameRan = eLib.readDataFromExcel("Opportunity", 1, 2);
	     String expClosDate = eLib.readDataFromExcel("Opportunity", 1, 5);
	     String relatedTo = eLib.readDataFromExcel("Opportunity", 1, 3);
	     String lastName = eLib.readDataFromExcel("Contact", 1, 2);
	     String orgName = eLib.readDataFromExcel("Org", 1, 2)+random;
	     String saleStage = eLib.readDataFromExcel("Opportunity", 1, 6);
	     
	     
	     /*step 3: Launching the browser*/ 
	     
		  WebDriver driver= null;
		  
		  if(BROWSER.equalsIgnoreCase("chrome"))
		  {
			  driver= new ChromeDriver();
		  }
		  else if (BROWSER.equalsIgnoreCase("firefox"))
		  {
			  driver= new FirefoxDriver();
		  }
		  else
		  {
			  System.out.println("Invalid Broswer");
		  }
		  
			
		  /* step 4: enter the Url*/
			 wLib.maximizeWindow(driver);
			 wLib.waitForPageLoad(driver);
			 driver.get(URL);
			 
			 /* step 5 : Logint to the application */
			 LoginPage lp=new LoginPage(driver);
			 lp.loginToApp(USERNAME, PASSWORD);
			 
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
			 /* Step 7 : Create opportunity */
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Opportunities")).click();
			 driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			 WebElement relatedToDrop = driver.findElement(By.id("related_to_type"));
			  Select sel= new Select(relatedToDrop);
			  List<WebElement> relatedToOptn = sel.getOptions();
			  for(WebElement relat:relatedToOptn)
			  {
				 if( relat.getText().equals("Contacts"))
						 {
					        sel.selectByValue(relat.getText());
						 }
			  }
			  
		   
			  driver.findElement(By.xpath("//img[@alt='Select']")).click();
				 Set<String> win = driver.getWindowHandles();
				 for(String wn:win)
				 {
					 driver.switchTo().window(wn);
				 }
				 
			
				 driver.findElement(By.id("search_txt")).sendKeys(orgName);
				 driver.findElement(By.name("search")).click();
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//a[contains(text(),'"+orgName+"')]")).click();
				 
				 
				 Set<String> win1 = driver.getWindowHandles();
				 for(String wn1:win1)
				 {
					 driver.switchTo().window(wn1);
					 
				 }
				 
				 
				 driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::input[@type='image']")).click();
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 String alerttext = driver.switchTo().alert().getText();
				 if(alerttext.equals("Related To cannot be none"))
				 {
					 System.out.println("Opprotunity not created as Organization details erased before creating opportunity");
				 }
		

}
}
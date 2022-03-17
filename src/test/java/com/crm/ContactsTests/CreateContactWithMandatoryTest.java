package com.crm.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithMandatoryTest {

	//Create Obj for all utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib= new JavaUtility();
	
	@Test(dataProvider = "readData")
	public void createContactWithMandatoryTest(String lastName) throws IOException 
	{
		//read data 
		String BROWSER = pLib.readDateFromPropertyFile("Browser");
		String URL = pLib.readDateFromPropertyFile("Url");
		String USERNAME = pLib.readDateFromPropertyFile("Username");
		String PASSWORD = pLib.readDateFromPropertyFile("Password");
		
		String lastname=lastName;
		
		//launch the application
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
		
		
		HomePage hp =new HomePage(driver);
		hp.clickonContactLNK();
		Reporter.log("click on contact",true);
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOncreatContactLookUpIMG();
		Reporter.log("click on crerate contact lookup image",true);
		
		CreateContactsPage ccp= new CreateContactsPage(driver);
		ccp.CreateContacts(lastname);
		Reporter.log("create contact ",true);
		
		ContactInfoPage cinp=new ContactInfoPage(driver);
		String hdr = cinp.ValidateContactCtreation();
		if (hdr.contains(lastname))
		{
			Reporter.log("Validation successful ",true);
		}
		
		else
		{
			Reporter.log("Validation failed ",true);
		}
		
		
		//logout
		hp.signOut(driver);
		
		driver.quit();
		
		
		}
	
	@DataProvider
	public Object[][] readData() throws EncryptedDocumentException, IOException
	{
		Object [][]data=eLib.readDataFromExcel("Contacts");
		
		return data;
	}
}

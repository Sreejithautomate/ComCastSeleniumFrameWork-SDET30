package com.crm.PRACTICE;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInformationPage;
import com.crm.ObjectRepository.OrganizationPage;

public class PracticeWithMultipleDataTest {

		//Create Obj for all utilities
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib= new JavaUtility();
		
		@Test(dataProvider = "OrgtestData")
		public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
		{
			
			
			//read data 
			String BROWSER = pLib.readDateFromPropertyFile("Browser");
			String URL = pLib.readDateFromPropertyFile("Url");
			String USERNAME = pLib.readDateFromPropertyFile("Username");
			String PASSWORD = pLib.readDateFromPropertyFile("Password");
			
			String orgname = orgName+jLib.getRandomNum();
		
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
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.clickonOrgLNK();
			Reporter.log("navigated to org link",true);
			
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrganzationLnk();
			Reporter.log("click on create org link",true);
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrganiza(orgname, indType);
			Reporter.log("create org with insustry type",true);
			
			//validate
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String actHeader = oip.verifyorganizationName();
			if (actHeader.contains(orgname)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
			
			//logout
			hp.signOut(driver);
			
			driver.quit();
		}
		
		@DataProvider(name = "OrgtestData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readDataFromExcel("OrgMultipleData");
			return data;
		}
}

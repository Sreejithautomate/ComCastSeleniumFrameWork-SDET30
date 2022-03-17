package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
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

public class CreateOrganizationWithMultiplDataTest extends BaseClass {
	
			
			@Test(dataProvider = "OrgtestData")
			public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
			{
				
				
				String orgname = orgName+jLib.getRandomNum();
			
				
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
				
			}
			
			@DataProvider(name = "OrgtestData")
			public Object[][] getData() throws Throwable
			{
				Object[][] data = eLib.readDataFromExcel("OrgMultipleData");
				return data;
			}
}

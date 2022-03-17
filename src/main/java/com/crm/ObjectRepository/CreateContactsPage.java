package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility{

	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name = "leadsource")
	private WebElement leadSrcDropDown;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@alt='Select']")
	private WebElement selectOrgimage;
	
	@FindBy(name="search_text")
	private  WebElement searchOrgTEXT;
	
	@FindBy(name="search")
	private WebElement searchBTN;
		

	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public  CreateContactsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getSearchOrgTEXT() {
		return searchOrgTEXT;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getSelectOrgimage() {
		return selectOrgimage;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getLeadSrcDropDown() {
		return leadSrcDropDown;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	public void CreateContacts(String lastName)
	{
		lastNameEdit.sendKeys(lastName);
		saveBTN.click();
	}
	
	public void CreateContacts(String lastName, String leadSrc)
	{
		lastNameEdit.sendKeys(lastName);
		//selectOrgimage.click();
		//switchToWindow(driver, "Accounts");
		 select(leadSrc, leadSrcDropDown);
		//switchToWindow(driver, "Contacts");
		saveBTN.click();
	}
	
	public void CreateContacts(WebDriver driver,String lastName, String leadSrc, String orgName)
	{
		lastNameEdit.sendKeys(lastName);
		selectOrgimage.click();
		switchToWindow(driver, "Accounts");
		searchOrgTEXT.sendKeys(orgName);
		searchBTN.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		select(leadSrc, leadSrcDropDown);
		saveBTN.click();
		
	}
	public void CreateContacts(WebDriver driver,String lastName,String orgName)
	{
		lastNameEdit.sendKeys(lastName);
		selectOrgimage.click();
		switchToWindow(driver, "Accounts");
		searchOrgTEXT.sendKeys(orgName);
		searchBTN.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBTN.click();
		
	}
}

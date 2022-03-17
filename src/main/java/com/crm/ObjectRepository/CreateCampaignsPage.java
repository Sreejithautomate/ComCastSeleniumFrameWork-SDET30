package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
	@FindBy(name ="campaignname")
	private WebElement CapgnNameTEXT;
	
	@FindBy(name ="closingdate")
	private WebElement ExpectedCloseTXT;
	
	@FindBy(xpath =  "//input[@value='T']")
	private WebElement groupRaidoBTN;
	
	@FindBy(xpath = "//input[@value='U'] ")
	private WebElement userRadioBTN;
	
	@FindBy(name="assigned_group_id")
	private WebElement campgnTypeDROPDOWN;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	
	public WebElement getGroupRaidoBTN() {
		return groupRaidoBTN;
	}

	public WebElement getUserRadioBTN() {
		return userRadioBTN;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}

	
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCapgnNameTEXT() {
		return CapgnNameTEXT;
	}

	public WebElement getExpectedCloseTXT() {
		return ExpectedCloseTXT;
	}
	
	
	public void createCampaign(String campName)
	{
		CapgnNameTEXT.sendKeys(campName);
		
	}
	
	public void clickOnUserRadioBtn()
	{
		userRadioBTN.click();
	}
	
	public void clickOnGroupRadioBtn()
	{
		groupRaidoBTN.click();
	}
	

}

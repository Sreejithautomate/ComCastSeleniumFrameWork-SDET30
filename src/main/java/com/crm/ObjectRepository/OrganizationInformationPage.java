package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgInfoHeader;

	public  OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public  String verifyorganizationName()
	
	{
		String orgheader = orgInfoHeader.getText();
		return orgheader;
	}
}

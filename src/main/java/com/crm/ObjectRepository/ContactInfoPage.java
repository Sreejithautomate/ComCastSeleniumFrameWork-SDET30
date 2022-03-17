package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderLNK;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderLNK() {
		return contactHeaderLNK;
	}
	
	public String ValidateContactCtreation()
	{
		String contacthdr = contactHeaderLNK.getText();
		return contacthdr;
	}

}

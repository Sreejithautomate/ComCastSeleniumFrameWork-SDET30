package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement creatContactLookUpIMG;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getCreatContactLookUpIMG() {
		return creatContactLookUpIMG;
	}

	public void clickOncreatContactLookUpIMG()
	{
		creatContactLookUpIMG.click();
	}

	
}

package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	/* step 1 : declaration of WebElement*/
	
	@FindBy (name ="user_name")
	private WebElement userNameEdit;
	
	@FindBy (name ="user_password")
	private WebElement passWordEdit;
	
	@FindBy (id ="submitButton")
	private WebElement submitBTN;
	
	
	/* step 2 : create constructor and Inituializ  WebElement*/
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	// Generate getter metgods ( Source--> generate getter and setter --> select getter)
	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}


	public WebElement getPassWordEdit() {
		return passWordEdit;
	}


	public WebElement getSubmitBTN()
	{
		return submitBTN;
	}
	
	
	// Business Library
	
	public void loginToApp(String username,String Password)
	{
		userNameEdit.sendKeys(username);
		passWordEdit.sendKeys(Password);
		submitBTN.click();
	}

	
	
	
}

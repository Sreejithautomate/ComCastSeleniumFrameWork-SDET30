package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

// extend webdriverUtility to the POM classes
public class HomePage extends WebDriverUtility {
	
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLNK;
	
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLNK;
	
	@FindBy(name = "Campaigns")
	private WebElement CampaignLNK;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportLNK;
	
	@FindBy(linkText = "More")
	private WebElement moreLNK;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLNK;
	
	@FindBy(linkText = "More")
	private WebElement moreLINK;
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getOrgLNK() {
		return orgLNK;
	}

	public WebElement getContactLNK() {
		return contactLNK;
	}

	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}



	public WebElement getSignOutLNK() {
		return signOutLNK;
	}



	public WebElement getOpportLNK() {
		return opportLNK;
	}

	public WebElement getMoreLNK() {
		return moreLNK;
	}
	
	public void clickonOrgLNK() 
	{
		orgLNK.click();
	}
	
	public void clickonContactLNK() 
	{
		contactLNK.click();
	}
	
	public WebElement getMoreLINK() {
		return moreLINK;
	}

	public void signOut(WebDriver driver)
	{
		mouseHover(driver, adminstratorIMG);
		signOutLNK.click();
		
	}
	
	/**This Method will perform mouseHover On More element
	  * @param driver
	 */
	public  void mouseHoverToMoreLink(WebDriver driver)
	{
	 mouseHover(driver, moreLINK);
	}
	
	
	/**
	 * 
	 * @param driver
	 */
	public  void clickCampaignLink(WebDriver driver)
	{
		CampaignLNK.click();
	}
	
	public void clickOnOpprtLink()
	{
		opportLNK.click();
	}
	

}

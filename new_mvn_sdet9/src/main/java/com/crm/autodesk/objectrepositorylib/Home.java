package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverCommomLib1;

public class Home extends WebDriverCommomLib1
{

	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productLink;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement OpportunitiesLink;
	
	
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement MoreLink;
	
	@FindBy(xpath="//a[text()='Quotes']")
	private WebElement quotesLink;
	
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getAdminstrationImg() {
		return adminstrationImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}
	
	public void logout()
	{
		getAdminstrationImg().click();
		getSignOutLnk().click();
	}
	
	
	
	
	
}

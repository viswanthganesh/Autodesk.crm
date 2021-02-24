package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.autodesk.genericlib.WebDriverCommomLib1;

public class CreateNewOrganization extends WebDriverCommomLib1
{
	
	public CreateNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement orgName;
	
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	  
	@FindBy(name="accounttype")
	private WebElement typeDropeDown;
	
	
	@FindBy(name="rating")
	private WebElement ratingDropeDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropeDown() {
		return typeDropeDown;
	}

	public WebElement getRatingDropeDown() {
		return ratingDropeDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	
	
	
	public void Createorganization(String orgNam , String industriesOption , String type, String rating) throws Throwable
	{
		waitforelement(orgName);
		getOrgName().sendKeys(orgNam);
		 selectoption(industriesOption,industryDropDown);
		 selectoption(type,typeDropeDown);
		 selectoption(rating,ratingDropeDown);
		 SaveBtn.click();
	}
	
}

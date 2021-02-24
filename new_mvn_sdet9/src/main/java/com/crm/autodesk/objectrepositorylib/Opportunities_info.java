package com.crm.autodesk.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverCommomLib1;

public class Opportunities_info 
{
	public Opportunities_info  (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

     @FindBy(xpath="//span[@class='dvHeaderText']")
      private WebElement successfullmasage;
     
     public WebElement getSuccessfullmasage() {
 		return successfullmasage;
 	}
}

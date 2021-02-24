package com.crm.autodesk.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectrepositorylib.Home;
import com.crm.autodesk.objectrepositorylib.Login;

import javalib.Javalibb;

public class Base_test1 implements IAnnotation
{
public static WebDriver driver;
public PropertyFileUtils pLib = new PropertyFileUtils();


public Excellutills eLib = new Excellutills();
public Javalibb jLib =new Javalibb();


 
@BeforeClass(groups={"smoke","regression"})
public void OpenBrowsr() throws Throwable
{
	PropertyFileUtils provalue = new PropertyFileUtils();
	String Browser = provalue.getPropertykeyValue(PRO_path, "browser");
	if (Browser.equals("firefox"))
	{     
		driver =new FirefoxDriver();
	}else if (Browser.equals("chrome")){
		
		driver = new ChromeDriver();
	}else if(Browser.equals("ie")) {
		driver = new InternetExplorerDriver();
	}
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	 String appurl = provalue.getPropertykeyValue(PRO_path, "url");
	 driver.get(appurl);
		
		
	}

@BeforeMethod(groups={"smoke","regression"})
public void configBM() throws Throwable {
	System.out.println("Enter the credientials and login to the application ");
	 String USERNAME = pLib.getPropertykeyValue(PRO_path, "username");
	 String PASSWORD = pLib.getPropertykeyValue(PRO_path, "password");
	Login loginPage = new Login(driver);
	loginPage.login(USERNAME, PASSWORD);
}
@AfterMethod(groups={"smoke","regression"})
public void configAM() {
	System.out.println("logout from the application");
	//log out 
	
	 Home HomePage = new Home(driver);
	HomePage.logout();
}
@AfterClass(groups={"smoke","regression"})
public void closeBrowser ()
{
	driver.quit();
}
}
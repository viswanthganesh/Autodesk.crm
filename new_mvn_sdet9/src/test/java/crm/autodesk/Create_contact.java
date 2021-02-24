package crm.autodesk;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.crm.autodesk.genericlib.Base_test1;
import com.crm.autodesk.genericlib.WebDriverCommomLib1;
import com.crm.autodesk.objectrepositorylib.Contacts;
import com.crm.autodesk.objectrepositorylib.CreateContacts;
import com.crm.autodesk.objectrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrepositorylib.Home;
import com.crm.autodesk.objectrepositorylib.Organization;
import com.crm.autodesk.objectrepositorylib.OrgnizationInfo;

public class Create_contact extends Base_test1

{
	
	WebDriverCommomLib1 wLib =new WebDriverCommomLib1();
@Test(groups="smoke")
public void Create_contact1() throws Throwable
{
	
	int randomNum = jLib.getRandomNumber();
	
	String  ContactName = eLib.getExcellData(EXCEL_path, "Sheet3", 1, 1)+randomNum;
	
	 wLib.waitForHTMLDOM();
		Home HomePage = new Home(driver);
		HomePage.getContactLink().click();;
		Contacts contct = new Contacts(driver);
		contct.getCreateContacts().click();
		CreateContacts creatCont = new CreateContacts(driver);
		
		creatCont.CreateContact(ContactName);
}
@Test(groups="regression")
public void Create_contact2() throws Throwable
{
	
	int randomNum = jLib.getRandomNumber();
	
	String  ContactName = eLib.getExcellData(EXCEL_path, "Sheet3", 1, 1)+randomNum;

	String  OrgName= eLib.getExcellData(EXCEL_path,"Sheet2","tc_01", "orgName")+ randomNum;
	String orgType = eLib.getExcellData(EXCEL_path,"Sheet1",1, 4);
	String orgIndustry = eLib.getExcellData(EXCEL_path,"Sheet1",1, 3);
	String orgRating = eLib.getExcellData(EXCEL_path,"Sheet1",1, 5);
	
	 wLib.waitForHTMLDOM();
		Home HomePage = new Home(driver);
		HomePage.getOrgLink().click();

		Organization orgPage = new Organization(driver);
		wLib.waitForHTMLDOM();
		
		orgPage.getOrgImage().click();
		
		CreateNewOrganization CreateOrgPage = new CreateNewOrganization(driver);
		
		 CreateOrgPage.Createorganization(OrgName, orgIndustry, orgType, orgRating);
		 
		 //verify org
		OrgnizationInfo orgInfo = new  OrgnizationInfo(driver);
		String actSuccessfullMsg = orgInfo.getSucessFullMasg().getText();
		 Assert.assertTrue(actSuccessfullMsg.contains(OrgName));
		HomePage.getContactLink().click();
		Contacts contct = new Contacts(driver);
		contct.getCreateContacts().click();
		CreateContacts creatCont = new CreateContacts(driver);
		
		creatCont.createContact(ContactName, OrgName);
}

}

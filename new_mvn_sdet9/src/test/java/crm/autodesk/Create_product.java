package crm.autodesk;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.Base_test1;
import com.crm.autodesk.genericlib.WebDriverCommomLib1;
import com.crm.autodesk.objectrepositorylib.Home;
import com.crm.autodesk.objectrepositorylib.ProductInfo;
import com.crm.autodesk.objectrepositorylib.Products;
import com.crm.autodesk.objectrepositorylib.createNewProduct;

public class Create_product extends Base_test1
{
	WebDriverCommomLib1 wLib =new WebDriverCommomLib1();
@Test(groups="smoke")
public void Create_product1() throws Throwable
{
	int randomNum = jLib.getRandomNumber();
	String  ProductName = eLib.getExcellData(EXCEL_path, "Sheet3", 1, 2)+randomNum;
	
	 wLib.waitForHTMLDOM();
		Home HomePage = new Home(driver);
		HomePage.getProductLink().click();
		
	Products pro = new Products(driver);
	pro.getproImage().click();
	createNewProduct crtpro = new createNewProduct(driver);
	crtpro.CreateNewProduct(ProductName);
	ProductInfo proinfo = new ProductInfo(driver);
	String pro_sucessfullmsg = proinfo.getSucessFullMasg().getText();
	Assert.assertTrue(pro_sucessfullmsg.contains(ProductName));
}
@Test(groups="regression")
public void Create_product2() throws Throwable
{
	int randomNum = jLib.getRandomNumber();
	String  ProductName = eLib.getExcellData(EXCEL_path, "Sheet3", 1, 2)+randomNum;
	String  UnitePrice = eLib.getExcellData(EXCEL_path, "Sheet3", 1, 3)+randomNum;
	
	 wLib.waitForHTMLDOM();
		Home HomePage = new Home(driver);
		HomePage.getProductLink().click();
		
	Products pro = new Products(driver);
	pro.getproImage().click();
	createNewProduct crtpro = new createNewProduct(driver);
	crtpro.CreateNewProduct(ProductName,UnitePrice);
	ProductInfo proinfo = new ProductInfo(driver);
	String pro_sucessfullmsg = proinfo.getSucessFullMasg().getText();
	Assert.assertTrue(pro_sucessfullmsg.contains(ProductName));
}

}

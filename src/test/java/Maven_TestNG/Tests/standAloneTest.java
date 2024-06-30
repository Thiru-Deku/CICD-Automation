package Maven_TestNG.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Maven_TestNG.Page_Object.CartPage;
import Maven_TestNG.Page_Object.CheckoutPage;
import Maven_TestNG.Page_Object.ConfirmationPage;
import Maven_TestNG.Page_Object.allProductPage;
import Maven_TestNG.TestComponents.Base_Test;


public class standAloneTest extends Base_Test{

	@Test(dataProvider= "getData")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		
		// TODO Auto-generated method stub

		//new comment
        //loginTest login = launchapp();
		allProductPage allProd = login.loginPageTest(input.get("email"), input.get("password"));
		String ProductName = "ADIDAS ORIGINAL";

		@SuppressWarnings("unused")
		List<WebElement> products = allProd.getProductList();
		allProd.addProdtoCart(ProductName);
		CartPage cart = allProd.gotoCart();

		String Productcart = cart.CartPageAdd();
		Assert.assertEquals(Productcart, "ADIDAS ORIGINAL");
		CheckoutPage chkout = cart.checkout();

		ConfirmationPage cnfrmpg = chkout.selectCountry("India");

		String msg = cnfrmpg.confirmMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		/*HashMap<String,String> map = new HashMap<String,String>();
		map.put("email","mail7@mail7.io");
		map.put("password","Acc1234$$");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email","mail6@mail7.io");
		map1.put("password","pwd1234$$");*/
		
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testng//data//purchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
		

}


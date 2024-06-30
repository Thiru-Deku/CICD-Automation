package Maven_TestNG.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Maven_TestNG.Page_Object.CartPage;
import Maven_TestNG.Page_Object.CheckoutPage;
import Maven_TestNG.Page_Object.ConfirmationPage;
import Maven_TestNG.Page_Object.allProductPage;
import Maven_TestNG.TestComponents.Base_Test;
import Maven_TestNG.TestComponents.Retry;

public class ErrorValidation extends Base_Test {

	@SuppressWarnings("unused")
	@Test(priority='0',retryAnalyzer=Retry.class)
	public void errorMessage() throws InterruptedException, IOException {

		// TODO Auto-generated method stub

		// loginTest login = launchapp();
		String ProductName = "ADIDAS ORIGINAL";
		allProductPage allProd = login.loginPageTest("mail7@mail7.io", "Acc1234");
		System.out.println(login.ErrorMsg());
		Assert.assertEquals("Incorrect email or password.", login.ErrorMsg());
		driver.close();

	}
@Test(priority='1')
public void errMsg2() throws InterruptedException {
	allProductPage allProd = login.loginPageTest("mail7@mail7.io", "Acc1234$$");
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
}

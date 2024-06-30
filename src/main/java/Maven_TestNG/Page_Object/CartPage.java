package Maven_TestNG.Page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_main.Com_component.CommonComponent;

public class CartPage extends CommonComponent{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
	    this.driver=driver;
	    PageFactory.initElements(driver,this);
	    
	}
	
	@FindBy(css=".cartSection h3")
	private WebElement cartHeader;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	
	public String CartPageAdd() {
	return cartHeader.getText();
}
	public CheckoutPage checkout() {
		checkoutele.click();
		 CheckoutPage chkout = new CheckoutPage(driver);
		    return chkout;
	}

}

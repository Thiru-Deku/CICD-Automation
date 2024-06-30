package Maven_TestNG.Page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_main.Com_component.CommonComponent;

public class CheckoutPage extends CommonComponent{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement selectcntry;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	public ConfirmationPage selectCountry(String countryName) {
	Actions act = new Actions(driver);
	act.sendKeys(country,countryName).build()
			.perform();

	selectcntry.click();
    submit.click();
    ConfirmationPage cnfrmpg = new ConfirmationPage(driver);
    return cnfrmpg;

}
}
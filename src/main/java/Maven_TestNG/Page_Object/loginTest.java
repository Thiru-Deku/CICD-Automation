package Maven_TestNG.Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_main.Com_component.CommonComponent;

public class loginTest extends CommonComponent {
	
	WebDriver driver;
	
	public loginTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="#userEmail")
	WebElement userEmail;
	
	@FindBy(css="#userPassword")
	WebElement userpass;
	
	@FindBy(css=".login-btn")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errMessage;
	
	public allProductPage loginPageTest(String umail,String password) {
		userEmail.sendKeys(umail);
		userpass.sendKeys(password);
		submit.click();
		allProductPage allProd = new allProductPage(driver);
		return allProd;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String ErrorMsg() {
		WebElementToBeAppear(errMessage);
		return errMessage.getText();
		
	}

}

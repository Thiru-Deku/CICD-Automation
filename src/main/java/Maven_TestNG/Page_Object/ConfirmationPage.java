package Maven_TestNG.Page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_main.Com_component.CommonComponent;

public class ConfirmationPage extends CommonComponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String confirmMsg() {
		return message.getText();
		
	}

}

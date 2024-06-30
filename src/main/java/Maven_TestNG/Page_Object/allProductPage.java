package Maven_TestNG.Page_Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_main.Com_component.CommonComponent;

public class allProductPage extends CommonComponent {

	WebDriver driver;

	public allProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> prods;
	
	@FindBy(css=".ng-animating")
	WebElement animation;

	By newProducts = By.cssSelector(".mb-3");
	By addProtoCart = By.cssSelector(".card-body button:last-of-type");
	By elenew = By.cssSelector("#toast-container");
	

	public List<WebElement> getProductList() {
		ElementToBeAppear(newProducts);
		return prods;

	}

	public WebElement getProdByName(String ProductName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProdtoCart(String ProductName) throws InterruptedException {

		WebElement ductPro = getProdByName(ProductName);
		ductPro.findElement(addProtoCart).click();
		ElementToBeAppear(elenew);
		ElementToBeDisappear(animation);
		
	}

}

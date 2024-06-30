package Maven_TestNG.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Maven_TestNG.Page_Object.loginTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Test {
	public WebDriver driver;
	public loginTest login;

	public WebDriver initializeDriver() throws IOException {

		// creating properities
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "/src/main/java/testng/source/GlobalFile.properties";

		FileInputStream jis = new FileInputStream(path);
		prop.load(jis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");

//		if (browserName.contains("chrome")) {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//			if(browserName.contains("headless")) {
//			options.addArguments("--headless");
//			driver = new ChromeDriver(options);
//		       
//			}
//		driver = new ChromeDriver();
//		//driver.manage().window().setSize(new Dimension(1440,900));
//
//	}
		if (browserName.contains("headless")) {	
			WebDriverManager.chromedriver().setup();		
	                ChromeOptions options = new ChromeOptions();	
			options.addArguments("headless");	
			driver = new ChromeDriver(options);
	//driver.manage().window().setSize(new Dimension(1440,990));      
	  driver.manage().window().setSize(new org.openqa.selenium.Dimension(1440, 990));		
	}
	 
	else if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();		
	}
		
if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.gecko.driver","C://Users//thiru//eclipse-workspace//mavenNG//src//test//java//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String, String>> getJsonData(String filepath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
	
	//converting string to hashmap using jackson databinding 
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
});
	return data;
	
	
	
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	   

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	    FileUtils.copyFile(source, dest);
	    return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

    @BeforeMethod(alwaysRun=true)
	public loginTest launchapp() throws IOException{
		driver = initializeDriver();
	    login = new loginTest(driver);
		login.goTo();
		return login;
		
	}
	
	@AfterMethod(alwaysRun=true)
	 public void DriverClose() {
        if (driver != null) {
            try {
                driver.quit(); // Use quit() instead of close() to ensure all windows are closed
            } catch (Exception e) {
                // Handle exceptions as needed
                e.printStackTrace();
            }
        }
    }
}

package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassSalesForce extends AbstractTestNGCucumberTests {
	
public static ChromeDriver driver;
	
	@BeforeMethod
	public void preConditions() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
//	@AfterMethod
//	public void postConditions() {
//		driver.close();
//	}

}

package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	
	public ChromeDriver driver;
	@Parameters({"url", "user_name", "user_password"})
	@BeforeMethod
    public void preConditions(String url,String uname,String pass) {
    	
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver = new ChromeDriver(options);
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//1.Create new incident
	//1. Launch ServiceNow application
	//2. Login with valid credentials (refer the document to create the instance)
	
	driver.findElement(By.id("user_name")).sendKeys(uname);
	driver.findElement(By.id("user_password")).sendKeys(pass);
	driver.findElement(By.id("sysverb_login")).click();
}
	@AfterMethod
	public void postConditions() {
		driver.close();
	}

}
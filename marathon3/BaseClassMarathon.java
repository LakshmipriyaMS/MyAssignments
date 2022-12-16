package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassMarathon {

	public ChromeDriver driver;
	public String fileName;
	public int sheetindex;
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void preConditions(String url,String uname,String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);

}
	
	@DataProvider
	public String[][] fetch() throws IOException{
		return ReadExcel.readdata(sheetindex);
	}
	
	

//	@AfterMethod
//	public void postConditions() {
//		driver.close();
//	}
//	
}



package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	public static void main(String[] args) throws InterruptedException {	 
		WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text() ='View All']")).click();
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].click();",sales);
		WebElement sales1 = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", sales1);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Lakshmi");
		driver.findElement(By.xpath("//div[@class='slds-dropdown-trigger slds-dropdown-trigger_click slds-size_1-of-1']")).click();
        WebElement cal = driver.findElement(By.xpath("//span[text()='16']"));
        driver.executeScript("arguments[0].click();", cal);
        Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")).click();
	    driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getText();
		System.out.println(text);
		if(text.contains("Lakshmi")) {
			System.out.println("opportunity created");
		}
		else {
			System.out.println("opportunity not created");
		}
}
}
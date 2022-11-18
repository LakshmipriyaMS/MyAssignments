package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounts {

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
		WebElement sales1 = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", sales1);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Lakshmipriya");
		WebElement elem = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']/span)[3]"));
		driver.executeScript("arguments[0].click();", elem);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		String checkmsg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getText();
		System.out.println(checkmsg);
		if(checkmsg.contains("Lakshmipriya")) {
			System.out.println("Account created");
		}
		else {
			System.out.println("Account not created");
		}
	}

}

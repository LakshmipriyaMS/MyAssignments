package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

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
		driver.findElement(By.xpath("//div[@class='headerTrigger  tooltip-trigger uiTooltip']/lightning-icon[@class='slds-icon-utility-add slds-button slds-button--icon slds-button--icon-small slds-button--icon-container slds-button--icon-x-small slds-global-header__button--icon-actions globalCreateButton slds-icon_container']")).click();
		driver.findElement(By.xpath("//span[text()='New Task']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		Thread.sleep(2000);
		WebElement elem2 = driver.findElement(By.xpath("//span[text()='Save']/parent::button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']"));
		driver.executeScript("arguments[0].click();", elem2);
		Thread.sleep(5000);
		String s = driver.findElement(By.xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']")).getText();
		System.out.println(s);
		Thread.sleep(2000);
		if (s.contains("Task Bootcamp")) {
			System.out.println("Task created");
		}
		else {
			System.out.println("Task not created");
		}

	}

}

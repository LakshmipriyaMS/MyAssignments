package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        WebElement el = driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a"));
        driver.executeScript("arguments[0].click();", el);
        el.click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		//driver.close();
		driver.switchTo().window(windows.get(0));
		WebElement el2 = driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a"));
		driver.executeScript("arguments[0].click();", el2);
        el2.click();
        windowHandles = driver.getWindowHandles();
        windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Title of page is " + driver.getTitle());
		driver.close();

	}

}

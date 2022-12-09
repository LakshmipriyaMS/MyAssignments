package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMouseActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement Mens = driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"));
		WebElement Shirts = driver.findElement(By.xpath("//span[text()='Shirts']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(Mens)
		.pause(Duration.ofSeconds(1))
		.click(Shirts)
		.perform();
		
		Thread.sleep(3000);
		
		WebElement shirt1 = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		builder.moveToElement(shirt1).perform();
	
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();


	}

}

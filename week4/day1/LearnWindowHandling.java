package week4.day1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		// Step 2: Instantaite the ChromeDriver
		//disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//i[@class='fa fa-align-justify']")).click();
		driver.findElement(By.xpath("(//label[text()='FLIGHTS'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}

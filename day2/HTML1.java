package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// 1. Launch the URL https://html.com/tags/table/
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Get the count of number of rows
		List<WebElement> rowcount = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr"));
		int rsize = rowcount.size();
		System.out.println(rsize);
		
		//3. Get the count of number of columns
		List<WebElement> colcount = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr/th"));
        int csize = colcount.size();
        System.out.println(csize);
	}

}

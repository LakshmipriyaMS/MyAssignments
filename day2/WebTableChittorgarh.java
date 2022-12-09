package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableChittorgarh {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//1. Launch https://www.chittorgarh.com/
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//2. Click on stock market
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		
		//3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		//4. Get all the Security names
		List<WebElement> secnames = driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]"));
		
		List<String> snames = new ArrayList<String>();
		for (WebElement names : secnames) {
			snames.add(names.getText());
			System.out.println(names.getText());
		}
	
		
		//5. Ensure whether there are duplicate Security name
        Set<String> hset = new HashSet<String>(snames);
		//System.out.println("After removing duplicates:" +hset);
		if (hset.size()==snames.size()) {
			System.out.println("No duplicates");
		}
		else {
			System.out.println("Duplicates found");
		}
		

	}

}

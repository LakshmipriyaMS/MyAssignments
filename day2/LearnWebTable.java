package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);	
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		Thread.sleep(3000);
		from.sendKeys("MAS" , Keys.ENTER);
		WebElement To = driver.findElement(By.id("txtStationTo"));
		To.clear();
		Thread.sleep(3000);
		To.sendKeys("CBE" , Keys.ENTER);
		List<WebElement> trains = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr/td[2]/a"));
		List<String> trainnames = new ArrayList<String>();
		for (WebElement names : trains) {
			trainnames.add(names.getText());
			System.out.println(names.getText());
		}
	
		Set<String> hset = new HashSet<String>(trainnames);
		
		if (hset.size()==trainnames.size()) {
			System.out.println("No duplicates");
		}
		else {
			System.out.println("Duplicates found");
		}
		}

	}



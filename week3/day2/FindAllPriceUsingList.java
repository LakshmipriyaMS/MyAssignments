package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class FindAllPriceUsingList {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("phones",Keys.ENTER);
			
			List<WebElement> AllPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			
			List<Integer> PriceList = new ArrayList<Integer>();
			
			for (WebElement eachmblprice : AllPrices) {
				
				System.out.println(eachmblprice.getText());
				String text = eachmblprice.getText().replaceAll("\\D","");
				int price = Integer.parseInt(text);
				PriceList.add(price);
			}
			
			Collections.sort(PriceList);
			System.out.println("Least Price is: " + PriceList.get(0));
			
			
	}

}

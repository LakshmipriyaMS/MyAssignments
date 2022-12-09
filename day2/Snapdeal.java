package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//1. Launch https://www.snapdeal.com/
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
		//2. Go to Mens Fashion
		//3. Go to Sports Shoes
		WebElement Mens = driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"));
		WebElement sports = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(Mens)
		.pause(Duration.ofSeconds(1))
		.click(sports)
		.perform();
		
		//4. Get the count of the sports shoes
		WebElement count = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println(count.getText());
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		WebElement clk = driver.findElement(By.xpath("//li[@data-sorttype='plth']"));
		driver.executeScript("arguments[0].click();", clk);

		//7. Check if the items displayed are sorted correctly
	/*	List<WebElement> sortedprice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> price=new ArrayList<String>();
		for (WebElement p : sortedprice) {
			price.add(p.getText());
			
		}
		System.out.println(price);*/
		//Thread.sleep(3000);
		
		//Collections.sort(price);
		//System.out.println("After sorting "+ price);
		
		//8.Select the price range (900-1200)
		WebElement fromval = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromval.clear();
		fromval.sendKeys("900");
		WebElement toval = driver.findElement(By.xpath("//input[@name='toVal']"));
		toval.clear();
		toval.sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		//Thread.sleep(3000);
		
		//9.Filter with color Navy 
		//driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		
		//10 verify the all applied filters 
		WebElement filter = driver.findElement(By.xpath("//a[text()='Rs. 900 - Rs. 1200']"));
		String text = filter.getText();
		System.out.println(text);
		if (text.contains("900")) {
			System.out.println("Filter applied");
		}
		else {
			System.out.println("Filter not applied");
		}
		
		//11. Mouse Hover on first resulting Training shoes
		//12. click QuickView button
		WebElement shoe = driver.findElement(By.xpath("//img[@title='ASIAN Black Training Shoes']"));
		builder.moveToElement(shoe).perform();
		WebElement view = driver.findElement(By.xpath("//div[contains(text(),'Quick')]"));
		driver.executeScript("arguments[0].click();", view);

		//13. Print the cost and the discount percentage
		WebElement cost = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		System.out.println("Cost price is " + cost.getText());
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println("Discount percentage is " + discount.getText());
		Thread.sleep(2000);
		
		//14. Take the snapshot of the shoes.
		WebElement ele = driver.findElement(By.xpath("//img[@class='cloudzoom']"));
		File source = ele.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/shoe.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(2000);
		//15. Close the current window
		//16. Close the main window
		//driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}

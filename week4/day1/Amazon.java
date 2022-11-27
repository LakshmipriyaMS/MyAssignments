package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		//	    1.Load the URL https://www.amazon.in/		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//		2.search as oneplus 9 pro 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);

		//		3.Get the price of the first product
		WebElement price = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String p = price.getText();
		System.out.println("Price of the first product is ₹" + p);

		//		4. Print the number of customer ratings for the first displayed product
		WebElement rating = driver.findElement(By.xpath("//span[@class='a-size-base puis-light-weight-text s-link-centralized-style']"));
		System.out.println("Customer ratings for first displayed product is " + rating.getText());

		//		5. Click the first text link of the first image
		driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));

		//		6. Take a screen shot of the product displayed
		WebElement img = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']"));
		File source = img.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/oneplus9pro.png");
		FileUtils.copyFile(source, dest);

		//			7. Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		Thread.sleep(3000);
		
		//			8. Get the cart subtotal and verify if it is correct.
		WebElement finalprice=driver.findElement(By.id("attach-accessory-cart-subtotal"));
		//WebElement finalprice = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String subtotal = finalprice.getText();
		System.out.println("Cart subtotal is " + subtotal);
		
		if (subtotal.contains(p)) {
			System.out.println("Price verified and its correct");
		}
		else {
			System.out.println("Price is not same and incorrect");
		}
//			9.close the browser
        driver.close();
	}

}

package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//1) Go to https://www.nykaa.com/
			
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
	    //2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		builder.pause(1);
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris",Keys.ENTER);
		
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']/a[contains(text(),'Paris')]")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Title verified");
		}
		else {
			System.out.println("Title not verified");
		}
		
		//5) Click sort By and select customer top rated
		WebElement sort = driver.findElement(By.xpath("//span[@class='sort-name']/parent::button"));
		builder.scrollToElement(sort).click().perform();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		WebElement clk = driver.findElement(By.xpath("//span[text()='Hair']"));
		driver.executeScript("arguments[0].click();", clk);
		Thread.sleep(3000);
		WebElement clk1 = driver.findElement(By.xpath("//span[text()='Hair Care']"));
		driver.executeScript("arguments[0].click();", clk1);
		Thread.sleep(3000);
		WebElement clks = driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']"));
		driver.executeScript("arguments[0].click();", clks);
		
		//7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//8)check whether the Filter is applied with Shampoo
		WebElement filter = driver.findElement(By.xpath("//span[text()='Filters Applied']"));
		String text = filter.getText();
		if (text.contains("Applied")) {
			System.out.println("Filter is applied");
		}
		else {
			System.out.println("Filter not applied");
		}
			
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		WebElement clk2 = driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]"));
		driver.executeScript("arguments[0].click();", clk2);
		//10) GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Select option = new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
		option.selectByIndex(0);
		
		//11) Print the MRP of the product
		WebElement MRP = driver.findElement(By.xpath("//span[contains(text(),'189')]"));
		System.out.println(MRP.getText());
			
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
		//13) Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		
		//14) Print the Grand Total amount
		Thread.sleep(3000);
		WebElement GTot = driver.findElement(By.xpath("//span[text()='Grand Total']/preceding::span[@class='css-n8gwxi e171rb9k3']"));
		String text2 = GTot.getText();
		System.out.println(text2);
		
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		//17) Check if this grand total is the same in step 14
		WebElement GTotCheck = driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']"));
		String text3 = GTotCheck.getText();
		System.out.println(text3);
		if (text2.contains(text3)) {
			System.out.println("GrandTotal is same");
		}
		else {
			System.out.println("GrandTotal is not same");
		}
		//18) Close all windows
		driver.switchTo().window(windows.get(0));
		driver.close();
	}
}
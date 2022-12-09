package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement source = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		Point src = source.getLocation();
		System.out.println(src);
		int x= src.getX();
		int y = src.getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(source, x+50, y+50).perform();
		
		WebElement src2 = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement dest2 = driver.findElement(By.xpath("//div[@id='form:drop_header']"));
		builder.dragAndDrop(src2, dest2).perform();
		WebElement dragcheck = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		String text = dragcheck.getText();
		if (text.contains("Dropped")) {
			System.out.println("The element is dropped to target");
		}
		else {
			System.out.println("The element is not dragged and dropped");
		}
		//Draggable column
		WebElement coldrag = driver.findElement(By.xpath("//span[text()='Quantity']"));
		WebElement coldest = driver.findElement(By.xpath("//span[text()='Category']"));
		builder.dragAndDrop(coldrag, coldest).perform();
		WebElement coldragcheck = driver.findElement(By.xpath("//span[text()='Columns reordered']"));
	    String text2 = coldragcheck.getText();
	    if (text2.contains("reordered")) {
			System.out.println("Column is dragged");
		}
	    else {
			System.out.println("Column is not dragged");
		}
	    Thread.sleep(3000);
	    //Draggable row
	    WebElement rowdrag = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[@data-ri='1']"));
	    builder.scrollToElement(rowdrag).perform();
	    WebElement rowdrop = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[@data-ri='3']"));
	    builder.scrollToElement(rowdrop).perform();
	    builder.dragAndDrop(rowdrag, rowdrop).perform();
	    //Thread.sleep(2000);
	   /* WebElement rowdragcheck = driver.findElement(By.xpath("//span[text()='Row moved']"));
	    driver.executeScript("arguments[0].click();", rowdragcheck);
	    String text3 = rowdragcheck.getText();
	    if (text3.contains("moved")) {
			System.out.println("Row is moved");
		}
	    else {
			System.out.println("Row is not moved");
		}*/
	
	}
	

}

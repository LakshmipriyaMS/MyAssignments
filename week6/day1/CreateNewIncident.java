package week6.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewIncident extends BaseClassServiceNow {

	@Test
	public void create() throws InterruptedException {
	
		//3. Enter Incident in filter navigator and press enter"
		Shadow dom =new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement clk = dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']");
		driver.executeScript("arguments[0].click();", clk);
		dom.setImplicitWait(30);
		WebElement filter = dom.findElementByXPath("//span[text()='Incidents']");
		driver.executeScript("arguments[0].click();", filter);
		//filter.sendKeys("Incident",Keys.ENTER);
		dom.setImplicitWait(30);
		
		//4. Click on Create new option and fill the manadatory fields
	   
		WebElement frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		WebElement clk2 = dom.findElementByXPath("//button[text()='New']");
		driver.executeScript("arguments[0].click();", clk2);
		Thread.sleep(3000);
		WebElement inc_no = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String inc = inc_no.getText();
		System.out.println(inc);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("New incident");
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
		//5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
		//INC0010003
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010011",Keys.ENTER);
		WebElement incrow = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]"));
		String text = incrow.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		if (text.contains(inc)) {
			System.out.println("Incident created");
		}
		else {
			System.out.println("Incident not created");
		}
	}

}

package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteTheIncident extends BaseClassServiceNow{

	@Test
	public void delete() throws InterruptedException {
		
//		3. Enter Incident in filter navigator and press enter"
		Shadow dom =new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement clk = dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']");
		driver.executeScript("arguments[0].click();", clk);
		dom.setImplicitWait(30);
		WebElement filter = dom.findElementByXPath("//span[text()='Incidents']");
		driver.executeScript("arguments[0].click();", filter);
		//filter.sendKeys("Incident",Keys.ENTER);
		dom.setImplicitWait(30);
		
//		4. Search for the existing incident and navigate into the incident
		WebElement frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		WebElement view = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		view.click();
		Select by= new Select(view);
		by.selectByVisibleText("Number");
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys("INC0010010",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(3000);
		
//		5. Delete the incident
		driver.findElement(By.xpath("//button[text()='Delete']")).click();	
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		//driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
//		6. Verify the deleted incident
		WebElement search1 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search1.click();
		search1.sendKeys("INC0010010",Keys.ENTER);
		String del = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
        System.out.println(del);
        if (del.contains("No")) {
			System.out.println("Incident deleted");
		}
        else {
			System.out.println("Incident not deleted");
		}
	}

}

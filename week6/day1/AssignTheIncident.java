package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class AssignTheIncident extends BaseClassServiceNow{

	@Test
	public void assign() throws InterruptedException {		
		
		//3. Enter incident in filter navigator and press enter"
		Shadow dom =new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement clk = dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']");
		driver.executeScript("arguments[0].click();", clk);
		dom.setImplicitWait(30);
		WebElement filter = dom.findElementByXPath("//span[text()='Incidents']");
		driver.executeScript("arguments[0].click();", filter);
		//filter.sendKeys("Incident",Keys.ENTER);
		dom.setImplicitWait(30);
		
//		4. click on open and Search for the existing incident and click on  the incident
		WebElement frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		WebElement view = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		view.click();
		Select by= new Select(view);
		by.selectByVisibleText("Number");
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys("INC0010011",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		
//		5. Assign the incident to  Software group
		WebElement assign = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"));
		assign.clear();
		assign.sendKeys("Software",Keys.ENTER);
		Thread.sleep(3000);
		WebElement assignto = driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']"));
		assignto.clear();
		assignto.sendKeys("Beth",Keys.ENTER);
		Thread.sleep(3000);
		
//		6. Update the incident with Work Notes
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Updated details");
		driver.findElement(By.xpath("//button[text()='Post']")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		Thread.sleep(3000);
		
//		7. Verify the Assignment group and Assigned for the incident
		String assigngrp = driver.findElement(By.xpath("//td[@class='vt']/a[text()='Software']")).getText();
	    System.out.println(assigngrp);
	    String assigned = driver.findElement(By.xpath("//td[@class='vt']/a[text()='Beth Anglin']")).getText();
	    System.out.println(assigned);
	    if (assigngrp.contains("Software") && assigned.contains("Beth")) {
			System.out.println("Assignment group and assigned for the incident is verified");
		}
	    else {
	    	System.out.println("Assignment group and assigned for the incident is not verified");
		}
	}

}

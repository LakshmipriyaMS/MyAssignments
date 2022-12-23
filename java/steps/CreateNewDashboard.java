package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateNewDashboard extends BaseClassSalesForce{
	
	String name;
	
	@Then("Click view All and click Dashboards from App launcher")
	public void clickViewAllAndClickDashboardsFromAppLauncher() {
	  driver.findElement(By.xpath("//button[text() ='View All']")).click();
	  WebElement dash = driver.findElement(By.xpath("//p[text()='Dashboards']"));
	  Actions builder = new Actions(driver);
	  builder.moveToElement(dash).click().perform();
	}
	
	@Then("click New Dashboard")
	public void clickNewDashboard() throws InterruptedException {
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();	
		Thread.sleep(5000);
	}
	
	@Then("enter dashboard name as (.*) and click create$")
	public void enterDashboardNameAndClickCreate(String dname) throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		WebElement oppName =driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		oppName.click();
		Thread.sleep(3000);
		oppName.sendKeys(dname);
		name=oppName.getAttribute("value");
		System.out.println(name);
		WebElement create = driver.findElement(By.xpath("//button[@id='submitBtn']"));
		driver.executeScript("arguments[0].click();",create);
		Thread.sleep(3000);
	}
	
	@Then("click save and verify dashboard name")
	public void clickSaveAndVerifyDashboardName() throws InterruptedException {
		//driver.findElement(By.xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']")).getText();
		WebElement save = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(save);
		WebElement newSave = driver.findElement(By.xpath("//div[@role='group']/button[text()='Save']"));
		driver.executeScript("arguments[0].click();",newSave);
		System.out.println("DashBoard saved");
		Thread.sleep(5000);
	
		WebElement done = driver.findElement(By.xpath("//button[text()='Done']"));
		// Java Script
		driver.executeScript("arguments[0].click();",done);
	WebElement verify = driver.findElement(By.xpath("//div[@class='slds-page-header__name']//span[text()='Priya']"));
	String s=verify.getText();
	System.out.println(s);
	if(s.equals(name))
	{
		System.out.println("Saved and verified");
	}
	else
	{
		System.out.println("Not verified");
	}
	}


}

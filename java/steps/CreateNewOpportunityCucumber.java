package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateNewOpportunityCucumber extends BaseClassSalesForce{
	
	@Given("user is on homepage")
	public void userIsOnHomepage() {
		boolean startpage = driver.findElement(By.xpath("//img[@id='logo']")).isDisplayed();
	    Assert.assertTrue(startpage);
	}
	
	@Given("type username as (.*)$")
	public void typeUsername(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}
	
	@Given("type password as (.*)$")
	public void typePassword(String pass) {
		driver.findElement(By.id("password")).sendKeys(pass);
	}
	
	@Given("click login button")
	public void clickLoginButton() throws InterruptedException {
		driver.findElement(By.id("Login")).click();
	}
	
	@Then("user is on salesforce homepage")
	public void userIsOnSalesforceHomepage() throws InterruptedException {
	    boolean displayed = driver.findElement(By.xpath("//span[@class='breadcrumbDetail uiOutputText']")).isDisplayed();
	    if(displayed) {
	    System.out.println("Page verified");
	    }
	}
	
	@Then("Click on toggle menu button from the left corner")
	public void clickOnToggleMenuButtonFromTheLeftCorner() {
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
	}
	
	@Then("Click view All and click Sales from App Launcher")
	public void clickViewAllAndClickSalesFromAppLauncher() {
		driver.findElement(By.xpath("//button[text() ='View All']")).click();
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].click();",sales);
	}
	
	@Then("Click on Opportunity tab")
	public void clickOnOpportunityTab() {
		WebElement sales1 = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", sales1);
	}
	
	@Then("Click on New button")
	public void clickOnNewButton() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	
	@Then("Enter Opportunity name as (.*)$")
	public void enterOpportunityName(String oppname) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppname);
	}
	
	@Then("Choose close date as Today")
	public void chooseCloseDateAsToday() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-dropdown-trigger slds-dropdown-trigger_click slds-size_1-of-1']")).click();
        WebElement cal = driver.findElement(By.xpath("//span[text()='19']"));
        driver.executeScript("arguments[0].click();", cal);
        Thread.sleep(3000);
	}
	
	@Then("Select Stage as Need Analysis")
	public void selectStageAsNeedAnalysis() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")).click();
	    driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	    Thread.sleep(3000);
	}
	
	@Then("click Save and VerifyOppurtunity Name")
	public void clickSaveAndVerifyOppurtunityName() throws InterruptedException {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getText();
		Thread.sleep(3000);
		System.out.println(text);
		Assert.assertTrue(text.contains("Lakshmi"));
		System.out.println("Opportunity verified");
	}

}

package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class CreateNewIndividual extends BaseClassSalesForce{
	
	String lname;
	@Then("Click view All and click individuals")
	public void clickViewAllAndClickIndividuals() {
		driver.findElement(By.xpath("//button[text() ='View All']")).click();
		WebElement ind = driver.findElement(By.xpath("//p[text()='Individuals']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ind).click().perform();
	}
	@Then("Click on the Dropdown icon in the Individuals tab")
	public void clickOnTheDropdownIconInTheIndividualsTab() throws InterruptedException {
	    WebElement clk = driver.findElement(By.xpath("//span[text()='Individuals Menu']"));
	    driver.executeScript("arguments[0].click();", clk);
	    Thread.sleep(3000);
	}
	@Then("Click on New Individual")
	public void clickOnNewIndividual() {
	    WebElement newind = driver.findElement(By.xpath("//span[text()='New Individual']"));
	    driver.executeScript("arguments[0].click();", newind);
	}
	@Then("Enter the Last Name as (.*)$")
	public void enterTheLastNameAsKumar(String lastname) throws InterruptedException {
	    WebElement lastn = driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
	    lastn.sendKeys(lastname);
	    lname = lastn.getAttribute("value");
	    System.out.println(lname);
	    Thread.sleep(3000);
	}
	@Then("Click save and verify Individuals Name")
	public void clickSaveAndVerifyIndividualsName() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    Thread.sleep(3000);
	    String text = driver.findElement(By.xpath("//div/span[@class='uiOutputText']")).getText();
	    Assert.assertTrue(text.contains("Kumar"));
		System.out.println("Individual name verified");
	}

}

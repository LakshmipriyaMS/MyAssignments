package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class CreateNewAccount extends BaseClassSalesForce{

	@Then("Click on Accounts tab")
	public void clickOnAccountsTab() {
		WebElement sales1 = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", sales1);
		driver.findElement(By.xpath("//div[@title='New']")).click();
	}
	@Then("Enter your name as (.*)$")
	public void enterYourNameForAccount(String accname) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accname);
		WebElement elem = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']/span)[3]"));
		driver.executeScript("arguments[0].click();", elem);
	}
	@Then("Select Ownership")
	public void selectOwnershipAsPublic() {
		driver.findElement(By.xpath("//span[text()='Public']")).click();
	}
	@Then("Click save and verify Account name")
	public void clickSaveAndVerifyAccountName() throws InterruptedException {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		String checkmsg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getText();
		System.out.println(checkmsg);
		Assert.assertTrue(checkmsg.contains("Lakshmi"));
		System.out.println("Account name verified");
	}
}

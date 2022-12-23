package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClassLead{


	@Given("enter first name local as (.*)$")
	public void enterFirstNameLocal(String fnamel) {
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fnamel);
	    
	}
	
	@Given("enter department name as (.*)$")
	public void enterDepartmentName(String Dname) {
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(Dname);
	}
	
	@And("enter description as (.*)$")
	public void enterDescription(String desc) {
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
	}
	
	@Given("enter the email id as (.*)$")
	public void enterTheEmailId(String email) {
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);

	}
	
	@And("select the source")
	public void selectSource() {
		WebElement ele = driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select sel = new Select(ele);
        sel.selectByValue("LEAD_CONFERENCE");
	}
	
	@And("select the state")
    public void selectState() {
		WebElement findElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select sel1 = new Select(findElement);
        sel1.selectByVisibleText("New York");
	}
	
	@Then("click create Lead")
	public void clickCreateLead() {
		driver.findElement(By.name("submitButton")).click();
}
	@Given("click Edit")
	public void clickEdit() {
		driver.findElement(By.linkText("Edit")).click();
	}
	
	@And("update description")
	public void updateDescription() {
	WebElement findElement2 = driver.findElement(By.id("updateLeadForm_description"));
    findElement2.clear();
    driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important");
	}
	
	@And("click update")
	public void clickUpdate() {
    driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("verify title")
	public void verifyTitle() {
    System.out.println("Title of final page is " +driver.getTitle());
	}
}

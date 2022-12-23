package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClassLead{
	
//	public ChromeDriver driver;
//	
//	@Given("launch chrome browser")
//	public void launchbrowser() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//	
//	@And("open url and maximize")
//	public void openurl() {
//		driver.get("http://leaftaps.com/opentaps");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	}
	
	@And("enter username as (.*)$")
	public void enterusername(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}
	
	@And("enter password as (.*)$")
	public void enterpassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	
	@And("click on submit")
	public void clicksubmit() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@And("click on {string} link")
	public void clicklink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
//	@And("click on Leads")
//	public void clickLeads() {
//		driver.findElement(By.linkText("Leads")).click();
//	}
//	
//	@And("click on create lead")
//	public void clickCreateLead() {
//		driver.findElement(By.linkText("Create Lead")).click();
//	}
	
	@And("enter the company name as (.*)$")
	public void enterCompanyName(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}
	
	@And("enter the first name as (.*)$")
	public void enterFirstName(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}
	
	@And("enter the last name as (.*)$")
	public void enterLastName(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}
	
	@And("click on create")
	public void clickoncreate() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("verify lead is created")
	public void verifyLead() {
		String text = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
	    if (text.contains("View")) {
			System.out.println("Lead created");
		}
	
	}
}

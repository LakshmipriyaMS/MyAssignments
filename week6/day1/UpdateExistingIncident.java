package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class UpdateExistingIncident {

	@Test(priority=2)
	public void update() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://dev137086.service-now.com/navpage.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	//	1. Launch ServiceNow application
	//	2. Login with valid credentials 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@123");
		driver.findElement(By.id("sysverb_login")).click();
		
	//	3. Enter Incident in filter navigator and press enter "
		Shadow dom =new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement clk = dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']");
		driver.executeScript("arguments[0].click();", clk);
		dom.setImplicitWait(30);
		WebElement filter = dom.findElementByXPath("//span[text()='Incidents']");
		driver.executeScript("arguments[0].click();", filter);
		//filter.sendKeys("Incident",Keys.ENTER);
		dom.setImplicitWait(30);
		
	//	4. Search for the existing incident and click on the incident
		WebElement frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010011",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
    //	5. Update the incidents with Urgency as High and State as In Progress
		WebElement urg = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		urg.click();
		Select opt = new Select(urg);
		opt.selectByVisibleText("1 - High");
		Thread.sleep(3000);
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		state.click();
		Select st = new Select(state);
		st.selectByVisibleText("In Progress");
		Thread.sleep(5000);
		WebElement textdes = driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']"));
		driver.executeScript("arguments[0].click();", textdes);
		textdes.sendKeys("New details");
		driver.findElement(By.xpath("//button[@id='sysverb_update']"));
		Thread.sleep(3000);
		
	//	6. Verify the priority and state 
		//driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(3000);
		WebElement incstate = driver.findElement(By.xpath("//td[text()='In Progress']"));
        String istate = incstate.getText();
        System.out.println(istate);
        Thread.sleep(3000);
        WebElement priority = driver.findElement(By.xpath("//td[text()='3 - Moderate']"));
        String prior = priority.getText();
        System.out.println(prior);
        Thread.sleep(3000);
		if (prior.contains("Moderate") && istate.contains("Progress") ) {
			System.out.println("Verified");
		}
		else {
			System.out.println("Not Verified");
		}
		
        
	}

}

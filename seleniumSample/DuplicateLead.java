package seleniumSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		 //Setup browser driver
		WebDriverManager.chromedriver().setup(); 
		//launch the browser
		ChromeDriver driver=new ChromeDriver(); 
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximize the browser window
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf Inc(10399)");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Lakshmi");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Priya");
        driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Lakshmi");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSC");
        driver.findElement(By.id("createLeadForm_description")).sendKeys("Demo Code");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("priya@gmail.com");
        WebElement ele = driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select sel = new Select(ele);
        sel.selectByValue("LEAD_CONFERENCE");
        WebElement findElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select sel1 = new Select(findElement);
        sel1.selectByVisibleText("New York");
        driver.findElement(By.name("submitButton")).click();
        System.out.println("Title of page is " +driver.getTitle());
        driver.findElement(By.linkText("Duplicate Lead")).click();
        WebElement findElement2 = driver.findElement(By.id("createLeadForm_companyName"));
        findElement2.clear();
        findElement2.sendKeys("ABC Provisions");
        WebElement findElement3 = driver.findElement(By.id("createLeadForm_firstName"));
        findElement3.clear();
        findElement3.sendKeys("Priya");
        //driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important");
        driver.findElement(By.name("submitButton")).click();
        System.out.println("Title of final page is " +driver.getTitle());
        //Thread.sleep(2000);
        //driver.close();
	}

}

package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.xpath("//a[text()='Leads']")).click();
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
        //driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("207");
        //driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("322-5111");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        //lst lead
        driver.findElement(By.xpath("(//a[text()='DemoLeadC'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='Delete']")).click();
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class=' x-form-text x-form-field ']")).sendKeys("DemoLeadC");
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        String msg=driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
        System.out.println(msg);
        if (msg.equals("No records to display")) {
			System.out.println("Lead ID deleted");
		}
        else {
			System.out.println("Lead ID not deleted");
		}
	}

}

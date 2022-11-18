package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
        driver.findElement(By.id("firstNameField")).sendKeys("Lakshmi");
        driver.findElement(By.id("lastNameField")).sendKeys("Priya");
        driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Lakshmi");
        driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Priya");
        driver.findElement(By.id("createContactForm_departmentName")).sendKeys("ECE");
        driver.findElement(By.id("createContactForm_description")).sendKeys("Creating a contact");
        driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Priya@gmail.com");
        WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
        Select st = new Select(state);
        st.selectByVisibleText("New York");
        driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
        driver.findElement(By.id("updateContactForm_description")).clear();
        driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Cleared description");
        driver.findElement(By.xpath("//input[@value='Update']")).click();
        System.out.println(driver.getTitle());

	}

}

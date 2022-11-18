package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Banu");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mathy");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9843126750");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Facebookcheck@123");
		//dropdown
		WebElement day = driver.findElement(By.id("day"));
		Select dd = new Select(day);
		dd.selectByValue("2");
		WebElement month = driver.findElement(By.id("month"));
		Select mm = new Select(month);
		mm.selectByValue("4");
		WebElement year = driver.findElement(By.id("year"));
		Select yy = new Select(year);
		yy.selectByValue("1970");
		//Radio button
		driver.findElement(By.name("sex")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
	}

}

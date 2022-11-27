package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertAndFrame {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		// Step 2: Instantaite the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		// Loads a new web page in the current browser window
		// Maximise the screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Priya");
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if (text.contains("Priya")) {
			System.out.println("Verified " + text);
		}
		else {
			System.out.println("Unsuccessful");
		}
        driver.switchTo().defaultContent();
	}

}

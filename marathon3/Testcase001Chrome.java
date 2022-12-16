package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase001Chrome extends BaseClassMarathon{
    @Test(dataProvider = "fetch")
	public void Testcase1(String question,String ans) throws InterruptedException {

		
//		03) Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();		
		
//		04) Click View All
		driver.findElement(By.xpath("//button[text() ='View All']")).click();
		
//		05) Type Content on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content",Keys.ENTER);
		
//		06) Click Content Link
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		
//		07) Click on Chatter Tab
		WebElement clk = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", clk);
		Thread.sleep(3000);
		
//		08) Verify Chatter title on the page
		//WebElement titlepg = driver.findElement(By.xpath("//title"));
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Chatter")) {
			System.out.println("Title verified");
		}
		else {
			System.out.println("Title not verified");
		}
		
//		09) Click Question tab
		WebElement clkq = driver.findElement(By.xpath("//span[text()='Question']"));
		driver.executeScript("arguments[0].click();", clkq);
		
//		10) Type Question with data (coming from excel)
		WebElement ques = driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']"));
        ques.sendKeys(question);
		
//		11) Type Details with data (coming from excel)
        WebElement details = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']/p"));
        details.sendKeys(ans);
        
//		12) Click Ask
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']")).click();
        Thread.sleep(3000);
        
//		13) Confirm the question appears
        String textques = driver.findElement(By.xpath("//div[@class='cuf-body cuf-questionTitle forceChatterFeedBodyQuestionWithoutAnswer']/span[@class='uiOutputText']")).getText();
        System.out.println(textques);
        if (textques.contains("TestNG")) {
			System.out.println("question appeared");
		}
        else {
			System.out.println("question not appeared");
		}
        
//		14) Close the browser

	}
    
    @BeforeClass
	public void setFile() {
		sheetindex=0;
	}

}

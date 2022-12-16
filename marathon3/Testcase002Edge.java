package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Testcase002Edge extends BaseClassMarathon {
	@Test(dataProvider="fetch")
	public void Testcase2(String oppname, String amount) throws InterruptedException {
	
//	2. Click on toggle menu button from the left corner
	driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
	
//	3. Click view All and click Sales from App Launcher
	driver.findElement(By.xpath("//button[text() ='View All']")).click();
	
//	4. Click View All Key Deals in Key Deals 
	//driver.findElement(By.xpath("//button[text() ='View All']")).click();
	Thread.sleep(3000);
	WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
    Actions builder = new Actions(driver);
	builder.moveToElement(sales).click().perform();
	driver.executeScript("arguments[0].click();",sales);
	Thread.sleep(3000);
	
//	5. Click the dropdown from Recently Viewed and select All Opportunities
	WebElement oppor = driver.findElement(By.xpath("//a[@title='Opportunities']/span[text()='Opportunities']"));
	driver.executeScript("arguments[0].click();",oppor);
	Thread.sleep(3000);
	WebElement recentview = driver.findElement(By.xpath("//span[@class='triggerLinkText selectedListView slds-page-header__title slds-truncate slds-p-right--xx-small uiOutputText']"));
	driver.executeScript("arguments[0].click();",recentview);
	WebElement allopp = driver.findElement(By.xpath("//a[@role='option']/span[@class=' virtualAutocompleteOptionText']"));
	driver.executeScript("arguments[0].click();",allopp);
	Thread.sleep(3000);
	
//	6. Click on New
	driver.findElement(By.xpath("//div[@title='New']")).click();
	
//	7. Give Opportunity Name  (From Excel)
	WebElement opp = driver.findElement(By.xpath("//input[@name='Name']"));
	opp.sendKeys(oppname);
	Thread.sleep(3000);
	
//	8. Select Type as New Customer and Lead Source as Partner Referral
	WebElement type = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
	builder.scrollToElement(type).click().perform();
	driver.executeScript("arguments[0].click();",type);
	driver.findElement(By.xpath("//span[text()='New Customer']")).click();
	Thread.sleep(3000);
	WebElement lead = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
	builder.scrollToElement(lead).click().perform();
	driver.executeScript("arguments[0].click();",lead);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
    
	
//	9. Give Amount as 75000 (from Excel)
	WebElement amt = driver.findElement(By.xpath("//input[@name='Amount']"));
	amt.sendKeys(amount);
	
//	10. Select Close Date as Next month 20th day 
	driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	driver.findElement(By.xpath("//button[@title='Next Month']")).click();
	driver.findElement(By.xpath("//table[@class='slds-datepicker__month']//tr[3]/td[6]")).click();

	
//	11. Select Stage as Needs Analysis
	WebElement stage = driver.findElement(By.xpath("//div/button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
	driver.executeScript("arguments[0].click();",stage);
	Thread.sleep(3000);
	WebElement needs = driver.findElement(By.xpath("//span[text()='Needs Analysis']"));
	driver.executeScript("arguments[0].click();",needs);
	
//	12. Click in Primary Campaign  Source and Select first option
	WebElement primary = driver.findElement(By.xpath("(//div/input[@class='slds-combobox__input slds-input'])[2]"));
	driver.executeScript("arguments[0].click();",primary);
	driver.findElement(By.xpath("//span[text()='Bootcamp']")).click();
	Thread.sleep(3000);
	
//	13. Click Save and Verify the opportunity is created"
	WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	driver.executeScript("arguments[0].click();",save);
	Thread.sleep(3000);
	
	String finalText = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();;
	   if(finalText.contains("Opp"))
	   {
		   System.out.println("Opportunity is created");
	   }
	   else
	   {
		   System.out.println("Opportunity is NOT created");
	   }
	}

	@BeforeClass
	public void setFile() {
		sheetindex=1;
	}
}


package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

public class EthicsPage  extends BasePage {
	BaseClass base1=new BaseClass();
	public EthicsPage(WebDriver driver) {
		super(driver);
	}
	// Elements
	@FindBy(id = "title_text")
	WebElement txtEthics;
	
	@FindBy(xpath = "//div[@data-automation-id='button-card']//div[2]/div/div/div")
	List<WebElement> resources;
	@FindBy(xpath = "/html/body/div[2]//ul/li[3]")//this is the xpath of list when clicked on any header
	WebElement txtLegal;
	//Methods
	public Boolean verifyPageEthics() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='title_text']")));
		String str="Ethics & Compliance";
		return txtEthics.getText().equals(str);
	}

 
	public void printResources() throws InterruptedException {
		System.out.println("Printing the resources>>>>>");
		
		for(WebElement ele:resources) {
			
			System.out.println(ele.getText());
		}
	}
	
	public void hoverLegalAndCorporateAffairs() throws InterruptedException {
		Actions act=new Actions(driver);
			act.moveToElement(txtLegal).perform();
			Thread.sleep(5000);
			List<WebElement> list3=driver.findElements(By.xpath("//div[starts-with(@id,'ContextualMenu')]/div/ul/li"));
				for(WebElement ele1:list3) {
					
					if(ele1.getText().contains("Ethics and Compliance")) {
						ele1.click();
					break;
						
					}
					
				}
			
		

		
	}
			
}

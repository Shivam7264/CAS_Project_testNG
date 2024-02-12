package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import utilities.WriteData;

public class HeaderPage  extends BasePage {
	BaseClass base=new BaseClass();
	public HeaderPage (WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(xpath = "//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
		WebElement btnUsername;
		
		@FindBy(xpath = "//*[@id=\"mectrl_currentAccount_secondary\"]")
		WebElement txtUsername;
//		@FindBy(id = "title_text")
//		WebElement txtEthics;
		
		//*[@id="spTopPlaceholder"]/div/div[2]//div[2]/button
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]//div[2]/button")
		WebElement btnCompany;
		
		@FindBy(xpath = "//*[@type='button' and @name='Service Lines']")
		WebElement btnService;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[4]/button")
		WebElement btnSales;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[6]/button")
		WebElement btnCorporate;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[7]/button")
		WebElement btnPeople;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[2]/button//i")//xpath of icon in header company
		WebElement dropCompany;
		
		@FindBy(xpath = "//*[@type='button' and @name='Service Lines']//i")
		WebElement dropService;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[2]/button//i")
		WebElement dropSales;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[6]/button//i")
		WebElement dropCorporate;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[7]/button//i")
		WebElement dropPeople;
		
		@FindBy(xpath = "/html/body/div[2]//ul/li")//this is the xpath of list when clicked on any header
		List<WebElement> listHeader;
		
		
		
		@FindBy(xpath = "/html/body//ul/li/div/a/div/i")
		List<WebElement> listOfIconelements;//list of icon elements which we need to hover
		
		@FindBy(xpath = "/html/body/div[2]//ul/li//i")//icon list if present
		List<WebElement> listCompany2;
		
		@FindBy(xpath = "/html/body/div[2]//ul/li//i")//icon list if present
		List<WebElement> listSales2;
		
		@FindBy(xpath ="//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[1]/a")
		WebElement beCognizant;
		
		
		
		
		//methods
		public void clickBtn() throws InterruptedException {
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			Thread.sleep(6000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnUsername);
		}
		
		
		public Boolean verifyUser() throws InterruptedException {
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mectrl_currentAccount_secondary']")));
			String text=txtUsername.getText();
			if(text.contains("@cognizant.com")) 
				return true;
			return false;
		}
		
		
		public Boolean verifyPage() {
			if(beCognizant.getText().equals("be.cognizant")) {
				return true;
			}
			return false;
		}
//		public Boolean verifyPageEthics() {
//			String str="Ethics & Compliance";
//			return txtEthics.getText().equals(str);
//		}
		
		
		public void clickCompany() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnCompany);
		}
		
		public void clickService() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnService);
		}
		
		public void clickSales() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnSales);
		}
		
		public void clickCorporate() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnCorporate);
		}
		public void clickPeople() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnPeople);
		}
		
		public Boolean checkIcon1() {
		
			return 	base.checkIcon(dropCompany);
		}
		
		public Boolean checkIcon2() {
			
			return 	base.checkIcon(dropService);
		}
		public Boolean checkIcon3() {
			
			return 	base.checkIcon(dropSales);
		}
		public Boolean checkIcon4() {
			
			return 	base.checkIcon(dropCorporate);
		}
		public Boolean checkIcon5() {
			
			return 	base.checkIcon(dropPeople);
		}
		
		public  void printCompanyList() throws IOException {
			System.out.println("Company list items>>>>>>>>>");
			base.printList(listHeader);
		}
		
		public  void printServiceList() throws IOException {
			System.out.println("Service list items>>>>>>>>>");
			base.printList(listHeader);
		}
		public  void printSalesList() throws IOException {
			System.out.println("Sales list items>>>>>>>>>");
			base.printList(listHeader);
		}
		
		public  void printCorporateList() throws IOException {
			System.out.println("Corporate list items>>>>>>>>>");
			base.printList(listHeader);
		}
		public  void printPeopleList() throws IOException {
			System.out.println("People list items>>>>>>>>>");
			base.printList(listHeader);
		}
		public void hoverOnServiceListItems() throws IOException, InterruptedException {
			
			for(WebElement ele:listOfIconelements) {
				int i=1;
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				
				List<WebElement> list3=driver.findElements(By.xpath("//div[starts-with(@id,'ContextualMenu')]/div/ul/li"));
				System.out.println("Service inner items>>"+i);
				base.printList(list3);
				i++;
			}
		}
		
		
		public void hoverOnPeopleList() throws IOException {
			for(WebElement ele:listOfIconelements) {
				int i=1;
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				
				List<WebElement> list3=driver.findElements(By.xpath("//div[starts-with(@id,'ContextualMenu')]/div/ul/li"));
				System.out.println("People inner items>>"+i);
				base.printList(list3);
				i++;
			}
		}
		public void hoverOnCorporateListItems() throws IOException, InterruptedException {
			int i=1;
			for(WebElement ele:listOfIconelements) {
				
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				Thread.sleep(3000);
				List<WebElement> list3 = null;
				
			list3=driver.findElements(By.xpath("//div[starts-with(@id,'ContextualMenu')]/div/ul/li"));
			System.out.println("Corporate inside list items>>"+i++);
			System.out.println(ele.getText() + " elem in Corporate inside list items->>"+i++);
			System.out.println("inner on hover found " + list3.size());
				base.printList(list3);
				List<WebElement> list4=driver.findElements(By.xpath("//div[starts-with(@id,'ContextualMenu')]/div/ul/li//i"));
				System.out.println("inner inner list4 size " + list4.size());
				for(WebElement er:list4) {
					Actions act1=new Actions(driver);
					act1.moveToElement(er).perform();
					//Thread.sleep(5000);
					List<WebElement> list5=driver.findElements(By.xpath("//*[@id=\"ContextualMenu248\"]/div/ul/li"));
					base.printList(list5);
				}
			 
			}
			System.out.println("all done");

	
		}
		public void checkIconPresent(List<WebElement> ele) {
		    for (WebElement element : ele) {
		        try {
		            if (element.isDisplayed()) {
		               Actions act=new Actions(driver); // Return true as soon as one element is displayed
		            act.moveToElement(element).perform();
		            
		            
		            }
		        } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
		            // Handle the exception, log it, or perform any necessary actions
		        }
		    }
		     // Return false if no elements are displayed
		}

		public void hover() {//company list items hover 
			checkIconPresent(listCompany2);
		}
		public void hoverSalesList() {
			checkIconPresent(listSales2);
		}


		


		


		
		
		

}

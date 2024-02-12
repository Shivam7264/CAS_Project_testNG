package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.WriteData;

public class BaseClass {

	static public WebDriver driver;
	//public WebDriver driver;// parallel testing
	public Logger logger;
	public static Properties p;
	
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
		
		//loading log4j 
		logger=LogManager.getLogger(this.getClass());//Log4j
				
				
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		    }
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	

	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public static void login1() throws InterruptedException, IOException {
		 WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(30))
		            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0118")));
		   p=BaseClass.getProperties();
		  String pwd= p.getProperty("password");
		    passwordInput.sendKeys(pwd);

		    Thread.sleep(5000);
		    WebElement bt2=driver.findElement(By.id("idSIButton9"));
	    	JavascriptExecutor js1=(JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", bt2);
		    

		    Thread.sleep(5000);

		    // Check if the "Back" button is present before clicking
		    WebElement backButton = null;
		    try {
		        backButton = new WebDriverWait(driver, Duration.ofSeconds(10))
		                .until(ExpectedConditions.presenceOfElementLocated(By.id("idBtn_Back")));
		    } catch (Exception e) {
		        System.out.println("Back button not found. Skipping the click.");
		    }

		    if (backButton != null) {
		        backButton.click();
		    }
		    Thread.sleep(10000);
	}
	public static void login() throws InterruptedException, IOException {
	    WebElement usernameInput = new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0116")));
	    p=BaseClass.getProperties();
		  String mail= p.getProperty("email");
		usernameInput.sendKeys(mail);
	    WebElement bt1=driver.findElement(By.id("idSIButton9"));
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", bt1);
	    

	    WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0118")));
	   p=BaseClass.getProperties();
	  String pwd= p.getProperty("password");
	    passwordInput.sendKeys(pwd);

	    Thread.sleep(5000);
	    WebElement bt2=driver.findElement(By.id("idSIButton9"));
   	JavascriptExecutor js1=(JavascriptExecutor)driver;
   	js1.executeScript("arguments[0].click();", bt2);
	    

	    Thread.sleep(5000);

	    // Check if the "Back" button is present before clicking
	    WebElement backButton = null;
	    try {
	        backButton = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.presenceOfElementLocated(By.id("idBtn_Back")));
	    } catch (Exception e) {
	        System.out.println("Back button not found. Skipping the click.");
	    }

	    if (backButton != null) {
	        backButton.click();
	    }
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       		
        p=new Properties();
		p.load(file);
		return p;
	}
	
	
	
	public Boolean checkIcon(WebElement ele) {
	    try {
	        return ele.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
	        // Handle the exception, log it, or perform any necessary actions
	        return false;
	    }
	}
	
	public  void printList(List<WebElement> list) throws IOException {
		List<String> ls=new ArrayList<>();
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			ls.add(ele.getText());
		}
//		WriteData data =new WriteData();
//		data.writeData(ls);
		//uncomment to store in excel sheet>>>>>>>>>>>>>>>>>>>>>
	}
	
}

package TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;

public class BeCognizant extends BaseClass {//login.feature implementation

	//WebDriver driver;
  
	

	@Test(priority=1,groups= {"regression","master"})
	public void userAndPageValidation() throws InterruptedException {
		 logger.info("opened be cognizant page.. ");
	    	
	    	try {
	    		  HeaderPage hp=new HeaderPage(driver);
	    		Assert.assertTrue(hp.verifyPage());
	    		hp.clickBtn();
	    		 Assert.assertTrue(hp.verifyUser());
	    	}
	    	catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
	}
	
}

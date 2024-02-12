package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;

public class ServiceLines extends BaseClass{
	
    
	@Test(groups= {"regression","master"})
	public void serviceHeader() throws IOException, InterruptedException {
	logger.info("opened cognizant page checking icon.. ");
	    	try {
	    	HeaderPage hp=new HeaderPage(driver);
	    	if(hp.checkIcon2()) {
	    		Assert.assertTrue(true);
		    	}
		    	else {
		    		Assert.assertTrue(false);
		    	}
	    	hp.clickService();
	    	hp.printServiceList();
	    	hp.hoverOnServiceListItems();
	    	}
	    	catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
	}

	

}

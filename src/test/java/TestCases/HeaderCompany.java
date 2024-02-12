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
public class HeaderCompany extends BaseClass {
	
	
    
	

	@Test(groups= {"sanity","master"})
	public void companyHeader() throws InterruptedException, IOException {
		 logger.info("clicked on company header.. ");
	    	
	    	try {
	    		HeaderPage hp=new HeaderPage(driver);
	    	if(hp.checkIcon1()) {
	    	hp.clickCompany();
	    	}
	    	else {
	    		Assert.assertTrue(false);
	    	}
	    	hp.printCompanyList();
	    	hp.hover();
	}
	    	catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
	
	}

	
}

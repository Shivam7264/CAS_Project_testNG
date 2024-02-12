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

public class Sales extends BaseClass{
	

	
	
	@Test(groups= {"regression","master"})
	public void salesHeader() throws IOException {
		logger.info("checks  sales header has icon.. ");
		try {
			HeaderPage hp=new HeaderPage(driver);
			Assert.assertTrue(hp.checkIcon3());
			hp.clickSales();
			hp.printSalesList();
			 hp.hoverSalesList();
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		}

	
}

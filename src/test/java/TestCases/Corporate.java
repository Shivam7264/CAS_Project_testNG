package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EthicsPage;
import pageObjects.HeaderPage;

public class Corporate  extends BaseClass{




@Test(priority=1,groups= {"master"})
public void CorporateHeader() throws IOException, InterruptedException {
  try {
	  HeaderPage hp=new HeaderPage(driver);
	Assert.assertTrue(hp.checkIcon4());
   hp.clickCorporate();
   hp.printCorporateList();
   hp.hoverOnCorporateListItems();
  }
  catch(Exception e)
	{
		Assert.fail("An exception occurred: " + e.getMessage());
	}
}
	
}

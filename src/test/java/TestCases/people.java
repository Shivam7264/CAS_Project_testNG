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

public class people extends BaseClass {


@Test(groups= {"master"})
public void peopleHeader() throws IOException {
	try {
	    HeaderPage hp=new HeaderPage(driver);

   Assert.assertTrue(hp.checkIcon5());
   hp.clickPeople();
   hp.printPeopleList();
   hp.hoverOnPeopleList();
	}
	catch(Exception e)
	{
		Assert.fail("An exception occurred: " + e.getMessage());
	}
}

}

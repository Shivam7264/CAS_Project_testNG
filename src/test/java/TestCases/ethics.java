package TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.EthicsPage;
import pageObjects.HeaderPage;

public class ethics extends BaseClass{
	@Test(priority=2,groups= {"regression","master"})
	public void ValidateEthicsPage() throws InterruptedException {
		try {
			HeaderPage hp=new HeaderPage(driver);
			EthicsPage ep=new EthicsPage(driver);
		 hp.clickCorporate();
		 ep.hoverLegalAndCorporateAffairs();
		 Assert.assertTrue(ep.verifyPageEthics());
		 Assert.assertTrue(ep.verifyPageEthics());
		 ep.printResources();
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
}

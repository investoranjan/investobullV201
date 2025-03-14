package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_003_BSKT_FundManagerDetailsTest extends BaseClass {
	
	
	@Test
	
	public void verifyFundManagerDetails() {
		logger.info("**** Starting TC_003_BSKT_FundManagerDetailsTest *****");
		 logger.debug("This is a debug log message");
		 
		 try {
			 
	HomePage hp=new HomePage(driver);
				
				
				hp.clicklogin();
				logger.info("Clicked on login Link.. ");

				
				AccountLoginPage lopage=new AccountLoginPage(driver);
				
				logger.info("Providing Admin Credentials...");
				
				lopage.setemail(p.getProperty("email"));
				lopage.setpwd(p.getProperty("password"));
				lopage.clickSignin();
				
				Thread.sleep(3000);
				
				
				hp.clickBasketDropdown();
				hp.clickFundManagers();
				
				FundManagerPage funddetails= new FundManagerPage(driver);
				
				 Assert.assertTrue(funddetails.isFundManagerHeaderDisplayed(), "Fund Manager page is NOT displayed");
			        Assert.assertTrue(funddetails.areFundManagerDetailsDisplayed(), "Fund Manager details are NOT visible");

			        logger.info("Test Case Passed: Fund Manager details displayed successfully.");
				
				
			 
		 }
		 
		 catch(Exception e) {
			 logger.error("Test failed: " + e.getMessage());
	            Assert.fail("Test failed: " + e.getMessage());
		 }
		 
		 finally {
	            logger.info("***** Finished TC_003_BSKT_FundManagerDetailsTest *****");
	        }
	}
	
	

}

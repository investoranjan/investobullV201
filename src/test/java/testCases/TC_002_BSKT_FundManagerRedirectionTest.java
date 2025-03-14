package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_BSKT_FundManagerRedirectionTest extends BaseClass {
	

@Test
	public void verifyFundManagerRedirection() {
		
		 logger.info("**** Starting TC_002_BSKT_FundManagerRedirectionTest *****");
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
				
				FundManagerPage fundPage = new FundManagerPage(driver);
				
				
				Assert.assertTrue(fundPage.isFundManagerHeaderDisplayed(), "Redirection to Fund Manager page failed!");
				
				logger.info("Validating expected message..");

				}
		 
		 catch (Exception e) {
	            logger.error("Test failed: " + e.getMessage());
	            Assert.fail("Test failed: " + e.getMessage());
	        } finally {
	            logger.info("***** Finished TC_002_BSKT_FundManagerRedirectionTest *****");
	        }
		 
		 
		
		
	}

}

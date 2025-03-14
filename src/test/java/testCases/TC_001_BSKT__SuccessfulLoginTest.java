package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_BSKT__SuccessfulLoginTest extends BaseClass {
	
	
	@Test
	 public void verifySuccessfulLogin() {
		
		logger.info("**** Starting TC_001_BSKT__SuccessfulLoginTest *****");
		logger.debug("This is a debug log message");
		
		try {
		
		HomePage hp=new HomePage(driver);
		
		
		hp.clicklogin();
		logger.info("Clicked on login Link.. ");

		
		AccountLoginPage lopage=new AccountLoginPage(driver);
		
		logger.info("Providing customer details...");
		
		lopage.setemail(p.getProperty("email"));
		lopage.setpwd(p.getProperty("password"));
		lopage.clickSignin();
		
		 //Wait.until(ExpectedConditions.visibilityOf(lopage.marketActionHeading));
		
		logger.info("Validating expected message..");

		Assert.assertTrue(lopage.isMarketActionPageDisplayed(), "Login failed! Market Action page not visible.");

		}
		
		catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());

		}
		
		finally {
			logger.info("***** Finished TC_001_BSKT__SuccessfulLoginTest *****");
		}
	 }

}

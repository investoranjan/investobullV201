package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_008_BSKT_InvalidEmailTest extends BaseClass {

	@Test
	public void createFundManagerWithInvalidEmail() {

		logger.info("**** Starting TC_008_BSKT_InvalidEmailTest *****");

		try {
			HomePage hp = new HomePage(driver);
			logger.info("Clicked on login Link.. ");
			hp.clicklogin();

			AccountLoginPage lopage = new AccountLoginPage(driver);
			logger.info("Providing Admin Credentials...");

			lopage.setemail(p.getProperty("email"));
			lopage.setpwd(p.getProperty("password"));
			lopage.clickSignin();

			Thread.sleep(3000);

			hp.clickBasketDropdown();
			hp.clickFundManagers();

			FundManagerPage fmpage = new FundManagerPage(driver);
			fmpage.clickCreateFundManager();
			logger.info("Navigated to Create Fund Manager page.");

			// Entering Valid Data except Email ID
			fmpage.setFirstName("TestFirst");
			fmpage.setLastName("TestLast");
			fmpage.setemailid("invalid-email"); // Invalid Email
			fmpage.setphonenum("9876543210");
			fmpage.setexp("5");
			fmpage.setNote("Test Note");
			fmpage.setDescription("Test Description");

			fmpage.clicksubmit();

			Thread.sleep(2000);

			// Validating Error Message for Email ID
			Assert.assertTrue(fmpage.isEmailErrorDisplayed(), "Email ID validation failed.");
			logger.info("Test Case Passed: Error message displayed for invalid email ID.");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC_008_BSKT_InvalidEmailTest *****");
		}
	}

}

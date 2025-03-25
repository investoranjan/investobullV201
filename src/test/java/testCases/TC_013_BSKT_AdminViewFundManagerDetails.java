package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerDeatiledPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_013_BSKT_AdminViewFundManagerDetails extends BaseClass {

	@Test
	public void viewFundManagerDetails() {

		logger.info("**** Starting TC_013_BSKT_AdminViewFundManagerDetails **** ");

		try {

			HomePage hp = new HomePage(driver);

			hp.clicklogin();
			logger.info("Clicked on login Link.. ");

			AccountLoginPage lopage = new AccountLoginPage(driver);

			logger.info("Providing Admin Credentials...");

			lopage.setemail(p.getProperty("email"));
			lopage.setpwd(p.getProperty("password"));
			lopage.clickSignin();

			Thread.sleep(3000);

			hp.clickBasketDropdown();
			hp.clickFundManagers();

			FundManagerDeatiledPage fDPage = new FundManagerDeatiledPage(driver);

			fDPage.clickFirstFundManager();

			Thread.sleep(2000);
			logger.info("✅ Clicked on First Fund Manager");

			// Validate Fund Manager Details Page is Displayed
			Assert.assertTrue(fDPage.isFundManagerDetailsDisplayed(), "Fund Manager details are not displayed!");

			logger.info("Test Case Passed: Fund Manager details displayed successfully.");

		}

		catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}

		finally {
			logger.info("***** Finished TC_003_BSKT_FundManagerDetailsTest *****");
		}
	}

}

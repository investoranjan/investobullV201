package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_BSKT_CreateFundManagerPageTest extends BaseClass {
	
	@Test

	public void verifyCreateFundManagerPage() {
		logger.info("**** Starting TC_004_BSKT_CreateFundManagerPageTest *****");

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

			logger.info("Clicked on Create Fund Manager button.");

			FundManagerPage fppage = new FundManagerPage(driver);

			fppage.clickCreateFundManager();
			fppage.isCreateFundManagerPageDisplayed();

			Assert.assertTrue(fppage.isCreateFundManagerPageDisplayed(), "Create Fund Manager page is NOT displayed.");

			logger.info("✅ Test Passed: Create Fund Manager page displayed successfully.");

		}

		catch (Exception e) {
			logger.error("Test failed due to " + e.getMessage());
			Assert.fail("Test failed due to" + e.getMessage());
		}

		finally {
			logger.info("***** Finished TC_004_BSKT_CreateFundManagerPageTest *****");
		}

	}

}

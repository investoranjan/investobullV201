package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerEditPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_015_DuplicateMobileNumberTest extends BaseClass {

	@Test
	public void testDuplicateMobileNumberValidation() {

		logger.info("**** Starting TC_015_DuplicateMobileNumberTest****");

		try {

			HomePage hp = new HomePage(driver);

			hp.clicklogin();
			logger.info("Clicked on login Link.. ");

			AccountLoginPage lopage = new AccountLoginPage(driver);

			logger.info("Providing Admin Credentials...");

			lopage.setemail(p.getProperty("email"));
			lopage.setpwd(p.getProperty("password"));
			lopage.clickSignin();

			Thread.sleep(2000);

			hp.clickBasketDropdown();
			hp.clickFundManagers();

			FundManagerEditPage fmeditpage = new FundManagerEditPage(driver);

			fmeditpage.clickFirstFundManager();

			fmeditpage.updateMobilenumberwitholdone("9938992662");

			fmeditpage.clickupdatebutton();

			Assert.assertTrue(fmeditpage.isDuplicateErrorDisplayed(), "❌ Duplicate mobile number validation failed!");
			logger.info("✅ 'Phone No Already Registered' message displayed!");

		}

		catch (Exception e) {
			logger.error("Test failed" + e.getMessage());
			Assert.fail("Test failed" + e.getMessage());

		}

		finally {
			logger.info("**** Closed TC_015_DuplicateMobileNumberTest****");
		}
	}

}

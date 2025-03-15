package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_006_BSKT_InvalidFundManagerTest extends BaseClass {

	@Test
	public void createFundManagerWithInvalidData() {

		logger.info("****Starting TC_006_BSKT_InvalidFundManagerTest *****");

		try {

			HomePage hp = new HomePage(driver);

			logger.info("Click on login Link");

			hp.clicklogin();

			AccountLoginPage lopage = new AccountLoginPage(driver);

			lopage.setemail(p.getProperty("email"));
			lopage.setpwd(p.getProperty("password"));

			lopage.clickSignin();

			Thread.sleep(2000);

			hp.clickBasketDropdown();
			hp.clickFundManagers();

			FundManagerPage fmpage = new FundManagerPage(driver);

			fmpage.clickCreateFundManager();

			logger.info("Navigated to Create Fund Manager page.");

			fmpage.setFirstName("Test@123");
			fmpage.setLastName("Last#45");
			fmpage.setemailid("invalidEmail");
			fmpage.setphonenum("12345");
			fmpage.setexp("");
			fmpage.setDescription("");

			fmpage.clicksubmit();

			Thread.sleep(2000);

			Assert.assertTrue(fmpage.isFirstNameErrorDisplayed(), "First Name validation failed.");
			Assert.assertTrue(fmpage.isLastNameErrorDisplayed(), "Last Name validation failed.");
			Assert.assertTrue(fmpage.isEmailErrorDisplayed(), "Email validation failed.");
			Assert.assertTrue(fmpage.isPhonenumberErrorDisplayed(), "Phone Number validation failed.");
			Assert.assertTrue(fmpage.isExperienceErrorDisplayed(), "Experience validation failed.");
			Assert.assertTrue(fmpage.isDescriptionErrorDisplayed(), "Description validation failed.");

			logger.info("Test Case Passed: Invalid data validation messages displayed successfully.");

		}

		catch (Exception e) {

			logger.error("Test failed " + e.getMessage());
			Assert.fail("Test failed" + e.getMessage());
		}

		finally {
			logger.info("****Finished TC_006_BSKT_InvalidFundManagerTest *****");
		}
	}

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_007_BSKT_InvalidPhoneNumberTest extends BaseClass {

	@Test
	public void createFundManagerWithInvalidPhoneNumber() {

		logger.info("****Started TC_007_BSKT_InvalidPhoneNumberTest ****");

		try {

			HomePage hp = new HomePage(driver);

			logger.info("Clicked on login details");

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

			fmpage.setFirstName("TestFirst");
			fmpage.setLastName("TestLast");
			fmpage.setemailid("test" + System.currentTimeMillis() + "@example.com");
			fmpage.setphonenum("12345");
			fmpage.setexp("5");
			fmpage.setNote("Test Note");
			fmpage.setDescription("Test Description");

			fmpage.clicksubmit();

			Thread.sleep(2000);

			Assert.assertTrue(fmpage.isPhonenumberErrorDisplayed(), "Phone Number validation failed.");
			logger.info("Test Case Passed: Error message displayed for invalid phone number.");

		}

		catch (Exception e) {
			logger.error("Test failed" + e.getMessage());
			Assert.fail("Test Failed" + e.getMessage());
		}

		finally {
			logger.info("****Finished TC_007_BSKT_InvalidPhoneNumberTest****");
		}
	}

}

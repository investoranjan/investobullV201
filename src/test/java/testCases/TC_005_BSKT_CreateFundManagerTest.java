package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_005_BSKT_CreateFundManagerTest extends BaseClass {
	
	
	public String sanitizeName(String name) {
	    return name.replaceAll("[^a-zA-Z]", ""); // Removes numbers & special characters
	}

	@Test
	public void createFundManager() {

		logger.info("**** Starting TC_005_BSKT_CreateFundManagerTest *****");
		logger.debug("This is a debug log message");

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

			String firstName = sanitizeName("TestFirst" + System.currentTimeMillis());
			String lastName = sanitizeName("TestLast" + System.currentTimeMillis());
			String email = "test" + System.currentTimeMillis() + "@gmail.com";
			String phone = "987654" + ((int) (Math.random() * 9000) + 1000);
			String experience = "5";
			String note = "Test Note";
			String description = "Test Description";

			fmpage.setFirstName(firstName);
			fmpage.setLastName(lastName);
			fmpage.setemailid(email);
			fmpage.setphonenum(phone);
			fmpage.setexp(experience);
			fmpage.setNote(note);
			fmpage.setDescription(description);

			fmpage.clicksubmit();

			Thread.sleep(3000);

			Assert.assertTrue(fmpage.isFundManagerHeaderDisplayed(), "Fund Manager was not created successfully.");
			logger.info("Test Case Passed: Fund Manager created successfully.");

		}

		catch (Exception e) {

			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());

		}

		finally {

			logger.info("***** Finished TC_005_BSKT_CreateFundManagerTest *****");
		}
	}

}

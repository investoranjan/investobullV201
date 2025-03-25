package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerEditPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_016_EditFundManagerDetailsTest extends BaseClass{
	
	
	@Test
	public void testDuplicateMobileNumberValidation() {

		logger.info("**** TC_016_EditFundManagerDetailsTest****");

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
			
			 fmeditpage.updateExperience("10");
	            fmeditpage.updateNote("Updated note for testing.");
	            fmeditpage.updateDescription("Updated description for fund manager.");
	            fmeditpage.clickupdatebutton();
	            
	            Assert.assertTrue(fmeditpage.isUpdateSuccessDisplayed(), "❌ Fund manager update failed!");
	            logger.info("✅ 'Fund manager Updated Successfully' message displayed!");
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

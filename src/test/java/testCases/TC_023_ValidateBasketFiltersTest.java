package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.BasketApprovalPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_023_ValidateBasketFiltersTest extends BaseClass {

	
	@Test
	public void ValidateBasketFiltersTest() {

		logger.info("**** Starting TC_023_ValidateBasketFiltersTest ****");

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

			hp.clickbasketApproval();

			Thread.sleep(2000);

			BasketApprovalPage baPgae = new BasketApprovalPage(driver);

			baPgae.clickAddFilter();

			Thread.sleep(2000);

			Assert.assertTrue(baPgae.isBasketFilterSectionDisplayed(), "Basket Filters section did not open");

		}

		catch (Exception e) {
			Assert.fail("Test case failed" + e.getMessage());

			logger.error("Test case failed" + e.getMessage());
		}

		finally {
			logger.info("**** Closed TC_023_ValidateBasketFiltersTest ****");
		}
	}

}

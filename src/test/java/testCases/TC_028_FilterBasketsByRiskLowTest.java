package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FilterHelperPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_028_FilterBasketsByRiskLowTest extends BaseClass {
	
	@Test
	public void testFilterBasketsByRiskLow() {
		
		
		logger.info("**** Started TC_028_FilterBasketsByRiskLowTest ****");

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
			hp.clickbasketApproval();

			Thread.sleep(3000);

			FilterHelperPage filterPage = new FilterHelperPage(driver);

			logger.info("Clicking on Add Filter button...");
			filterPage.clickAddFilterButton();
			
			logger.info("Clicking on Low risk button...");
			filterPage.clickRiskLowButton();
			
			logger.info("Clicking on Apply filter button");
			filterPage.clickapplyFilterButton();
			
			logger.info("Verifying that all displayed baskets have Low Risk...");
			Assert.assertTrue(filterPage.verifyAllBasketsAreLowRisk(), "Some baskets are not Low Risk!");
			

	}
		
		catch (Exception e) {
			Assert.fail("Test case failed" + e.getMessage());
			logger.error("Test case failed" + e.getMessage());
		}

		finally {
			logger.info("**** Closed TC_027_FilterBasketsBySubscriptionFreeTest ****");
		}
	}
	
}

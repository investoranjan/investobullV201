package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FilterHelperPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_027_FilterBasketsByFreeSubscriptionTest extends BaseClass{
	
	@Test
	public void testFilterBasketsBySubscriptionFree() {

		logger.info("**** Started TC_027_FilterBasketsBySubscriptionFreeTest ****");

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

			logger.info("Clicking on Subscription Type as Free...");
			filterPage.clickSubscriptionFreeButton();

			logger.info("Clicking on Apply filter button");
			filterPage.clickapplyFilterButton();

			logger.info("Verifying that all displayed baskets have Free Subscription...");
			Assert.assertTrue(filterPage.verifyAllBasketsAreFree(), "Some baskets are not Free!");

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

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.SortingHelperPage;
import testBase.BaseClass;

public class TC_024_SortBasketsByMinInvestmentTest extends BaseClass {

	
	@Test
	public void sortBasketsByMinInvestmentAmount() {

		logger.info("**** Starting TC_024_SortBasketsByMinInvestmentTest ****");

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

			SortingHelperPage sortPage = new SortingHelperPage(driver);

			sortPage.clickByMinInvestmentHeader();
			
			
			Thread.sleep(3000);
			logger.info("Verifying that baskets are sorted correctly by Min Investment Amount...");
			Assert.assertTrue(sortPage.isSortedByMinInvestment(), "Sorting by Min Investment Amount failed!");

		}

		catch (Exception e) {
			Assert.fail("Test case failed" + e.getMessage());
			logger.error("Test case failed" + e.getMessage());

		}

		finally {

			logger.info("**** Closed TC_024_SortBasketsByMinInvestmentTest ****");
		}
	}

}

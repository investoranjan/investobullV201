package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.BasketApprovalPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_009_BSKT_ApprovePendingBasketTest extends BaseClass {

	
	@Test
	public void approvePendingBasket() {
		logger.info("**** Starting TC_009_BSKT_ApprovePendingBasketTest  ");

		try {

			HomePage hp = new HomePage(driver);

			logger.info("Clicked Logined link....");

			hp.clicklogin();

			AccountLoginPage lopage = new AccountLoginPage(driver);

			logger.info("Providing Admin credentilas....");

			lopage.setemail(p.getProperty("email"));
			lopage.setpwd(p.getProperty("password"));

			lopage.clickSignin();

			Thread.sleep(3000);

			hp.clickBasketDropdown();
			hp.clickbasketApproval();

			BasketApprovalPage bapage = new BasketApprovalPage(driver);

			logger.info("Navigating to Pending Stock Baskets...");

			bapage.clickPendingStockBaskets();

			logger.info("Opening the first pending basket...");

			bapage.clickFirstViewBasket();

			Thread.sleep(2000);

			Assert.assertTrue(bapage.isApproveBasketDisplayed(), "Basket details page is NOT displayed.");

			logger.info("Test Case Passed: Basket details displayed successfully.");

		}

		catch (Exception e) {
			logger.error("Test failed" + e.getMessage());

			Assert.fail("Test Failed" + e.getMessage());
		}

		finally {
			logger.info("***** Finished TC_009_BSKT_ApprovePendingBasketTest *****");
		}

	}

}

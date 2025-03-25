package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.BasketDetailsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_017_ViewBasketDetailsTest extends BaseClass {

	@Test
	public void testViewBasketDetails() {

		logger.info("**** Staring TC_017_ViewBasketDetailsTest****");

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

			BasketDetailsPage basketPage = new BasketDetailsPage(driver);

			basketPage.clickFirstBasket();
			basketPage.clickStocksTab();

			Assert.assertTrue(basketPage.isStocksSectionDisplayed(), "❌ Stocks section not displayed!");
			logger.info("✅ Basket details and stocks section are visible!");

		}

		catch (Exception e) {
			Assert.fail("Test case failed" + e.getMessage());
			logger.error("Test case failed" + e.getMessage());
		}

		finally {
			logger.info("**** Closed TC_017_ViewBasketDetailsTest****");
		}
	}

}

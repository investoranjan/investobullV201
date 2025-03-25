package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.BasketApprovalPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_018_AdminPausesBasketTest extends BaseClass {

	@Test
	public void testAdminPausesBasket() {

		logger.info("**** Starting TC_018_AdminPausesBasketTest ****");

		try {

			HomePage hp = new HomePage(driver);

			hp.clicklogin();

			logger.info("Clicked login link");

			AccountLoginPage lopage = new AccountLoginPage(driver);

			logger.info("Providing Admin Credentials...");

			lopage.setemail(p.getProperty("email"));
			lopage.setpwd(p.getProperty("password"));

			lopage.clickSignin();
			
			Thread.sleep(3000);

			logger.info("navigate to Basket admin approval page...");

			hp.clickBasketDropdown();
			hp.clickbasketApproval();
			
			Thread.sleep(3000);

			BasketApprovalPage basketPage = new BasketApprovalPage(driver);

			basketPage.toggleSubscription();

			Assert.assertTrue(basketPage.isPauseNotificationDisplayed(),
					"❌ Basket pause confirmation message not displayed!");

			logger.info("✅ 'Basket subscription has been Paused' message displayed!");

		}

		catch (Exception e) {
			Assert.fail("Test failed" + e.getMessage());
			logger.error("Test failed" + e.getMessage());
		}

		finally {
			logger.info("**** Closed TC_018_AdminPausesBasketTest ****");
		}
	}

}

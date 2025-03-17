package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;

import pageObjects.AccountLoginPage;
import pageObjects.BasketApprovalPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_010_BSKT_AdminApprovesBasketTest extends BaseClass {
	@Test
	public void aprovePendingBasket() {
		
		logger.info("**** Starting TC_010_BSKT_AdminApprovesBasketTest **** ");
		
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

			BasketApprovalPage baPage = new BasketApprovalPage(driver);
            baPage.clickPendingStockBaskets();

            logger.info("Fetching Pending Basket Count...");
            int beforeCount = baPage.getPendingBasketsCount();
            logger.info("Pending baskets before approval: " + beforeCount);

            if (beforeCount > 0) {
                baPage.clickFirstViewBasket();
                baPage.clickFirstApproveBasket();

                Thread.sleep(3000); // Wait for UI update
                driver.navigate().refresh();
                Thread.sleep(3000);

                int afterCount = baPage.getPendingBasketsCount();
                logger.info("Pending baskets after approval: " + afterCount);

                Assert.assertTrue(afterCount < beforeCount, "Basket was NOT removed from Pending list!");
                logger.info("Test Passed: The approved basket has been removed successfully.");
            } else {
                logger.info("No pending baskets available for approval.");
            }
		}
		
		catch(Exception e) {
			logger.error("Test failed"+e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
			
		}
		
		finally {
			
			logger.info("**** Finished TC_010_BSKT_AdminApprovesBasketTest *****");
		}
	}

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.BasketApprovalPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_011_BSKT_AdminRejectsBasketTest extends BaseClass{
	
	@Test
	public void rejectPendingBasket() {
		
		logger.info("**** Starting TC_011_BSKT_AdminRejectsBasketTest ****");
		
		try {
			
			HomePage hp=new HomePage(driver);
			hp.clicklogin();
			
			AccountLoginPage lopage = new AccountLoginPage(driver);
            lopage.setemail(p.getProperty("email"));
            lopage.setpwd(p.getProperty("password"));
            lopage.clickSignin();
            
            Thread.sleep(3000);

            hp.clickBasketDropdown();
            hp.clickbasketApproval();

            BasketApprovalPage brPage = new  BasketApprovalPage(driver);
            brPage.clickPendingStockBaskets();
            
            
            int beforeCount = brPage.getPendingBasketsCount();
            logger.info("Pending baskets before rejection: " + beforeCount);
            
            if (beforeCount > 0) {
                brPage.clickFirstViewBasket();
                brPage.clickRejectBasket();
                
                brPage.enterRejectionReason(p.getProperty("rejectionMessage"));  // Dynamic rejection message
                brPage.confirmRejection();

                Thread.sleep(4000);

                int afterCount = brPage.getPendingBasketsCount();
                logger.info("Pending baskets after rejection: " + afterCount);

                Assert.assertTrue(afterCount < beforeCount, "Basket was NOT removed from Pending list!");
                logger.info("Test Passed: The rejected basket has been removed successfully.");
            } else {
                logger.info("No pending baskets available for rejection.");
            }
			
			
		}
		
		catch(Exception e) {
			Assert.fail("Test failed" + e.getMessage());
			logger.error("Test failed"+e.getMessage());
		}
		
		finally {
			logger.info("**** Finished TC_011_BSKT_AdminRejectsBasketTest ****");
		}
	}

}

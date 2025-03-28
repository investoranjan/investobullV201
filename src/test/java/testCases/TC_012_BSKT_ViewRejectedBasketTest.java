package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.BasketRejectpage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_012_BSKT_ViewRejectedBasketTest extends BaseClass{
	
	
	@Test
	public void viewRejectedBasketHistory() {
        logger.info("**** Starting TC_012_BSKT_ViewRejectedBasketTest ****");

        try {
            // Home Page
            HomePage hp = new HomePage(driver);
            hp.clicklogin();
            logger.info("Clicked on login link");

            // Login Page
            AccountLoginPage loginPage = new AccountLoginPage(driver);
            loginPage.setemail(p.getProperty("email"));
            loginPage.setpwd(p.getProperty("password"));
            loginPage.clickSignin();
            logger.info("Admin logged in successfully");

            Thread.sleep(3000); // Wait for navigation

            // Navigate to Baskets
            hp.clickBasketDropdown();
            hp.clickbasketApproval();
            logger.info("Navigated to Rejected Baskets section");

            BasketRejectpage brPage=new BasketRejectpage(driver);
            
            Thread.sleep(3000); 
            
            brPage.clickRejectedBaskets();

            // Check if rejected baskets exist
            int rejectedCount = brPage.getRejectedBasketsCount();
            Assert.assertTrue(rejectedCount > 0, "No rejected baskets available!");

            brPage.clickFirstRejectedBasket();
            logger.info("Clicked on first rejected basket");

            brPage.clickViewRejectedBasket();
            logger.info("Clicked on View button");
            
           

            //Wait and Click on Rejection History
        
            
            brPage.clickRejectionHistory();
            logger.info("Clicked on Rejection History");
            
            

            // Verify if Rejection History is displayed
            Assert.assertTrue(brPage.isRejectionHistoryDisplayed(), "Rejection history is not visible!");
            logger.info("Test Passed: Rejection history is displayed correctly");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("**** Finished TC_012_BSKT_ViewRejectedBasketTest ****");
    }

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FilterHelperPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_032_FilterBasketsByBiWeeklyRebalanceTest extends BaseClass{
	
	@Test
    public void testFilterBasketsByWeeklyRebalance() {
        logger.info("**** Started TC_032_FilterBasketsByBiWeeklyRebalanceTest ****");

        try {
            HomePage hp = new HomePage(driver);

            hp.clicklogin();
            logger.info("Clicked on login link.. ");

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

            logger.info("Selecting BiWeekly Rebalance Frequency...");
            filterPage.clickbiWeeklyRebalanceButton();

            logger.info("Clicking on Apply filter button...");
            filterPage.clickapplyFilterButton();

            logger.info("Verifying that all displayed baskets have BiWeekly Rebalance Frequency...");
            Assert.assertTrue(filterPage.verifyAllBasketsAreBiWeekly(), "Some baskets do not have Weekly Rebalance Frequency!");

        } catch (Exception e) {
            Assert.fail("Test case failed: " + e.getMessage());
            logger.error("Test case failed: " + e.getMessage());
        } finally {
            logger.info("**** Closed TC_032_FilterBasketsByBiWeeklyRebalanceTest ****");
        }
    }

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.ApprovedStockBasketsInfoPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_019_VerifyInfoButtonTest extends BaseClass {
	
	@Test
	public void testVerifyInfoButtonFunctionality() {

        logger.info("**** Starting TC_019_VerifyInfoButtonTest ****");

        try {
            // Home Page
            HomePage hp = new HomePage(driver);
            hp.clicklogin();
            logger.info("Clicked on login link..");

            // Login Page
            AccountLoginPage lopage = new AccountLoginPage(driver);
            logger.info("Providing Admin Credentials...");
            lopage.setemail(p.getProperty("email"));
            lopage.setpwd(p.getProperty("password"));
            lopage.clickSignin();

            Thread.sleep(3000); // Waiting for page load

            // Navigate to Basket Page
            hp.clickBasketDropdown();
            Thread.sleep(3000);
            
            hp.clickbasketApproval();
            
            logger.info("Navigated to Approved Stock Baskets");

            Thread.sleep(3000);
            // ApprovedStockBasketsInfoPage
            ApprovedStockBasketsInfoPage bp = new ApprovedStockBasketsInfoPage(driver);

            // Verify tooltips
            Assert.assertEquals(bp.getFundManagerNameTooltip(), "Fund Manager Name", "❌ Fund Manager Name tooltip incorrect!");
           Assert.assertEquals(bp.getBasketNameTooltip(), "Name of the Basket Category", "❌ Basket Name tooltip incorrect!");
           Assert.assertEquals(bp.getBasketStrategyTooltip(), "Category", "❌ Basket Strategy tooltip incorrect!");
            Assert.assertEquals(bp.getVolatilityTooltip(), "Measures how much a Basket's price fluctuates over time. Higher volatility means larger price swings, indicating more risk and potential reward.", "❌ Volatility tooltip incorrect!");
            Assert.assertEquals(bp.getRebalanceFrequencyTooltip(), "The schedule at which the basket's holdings are adjusted to maintain the desired asset allocation or strategy (e.g., monthly, quarterly).", "❌ Rebalance Frequency tooltip incorrect!");
            Assert.assertEquals(bp.getSubscriptionTypeTooltip(), "Defines the plan, that user enrolled in, determining the features, access, and duration of your subscription.", "❌ Subscription Type tooltip incorrect!");
           Assert.assertEquals(bp.getNoOfStocksTooltip(), "Number of stocks in Basket", "❌ No of Stocks tooltip incorrect!");
           Assert.assertEquals(bp.getMinInvestmentAmountTooltip(), "The least amount of money required to invest in this basket", "❌ Min Investment Amount tooltip incorrect!");
          Assert.assertEquals(bp.getCAGRTooltip(), "The average annual growth rate of an investment over a specific period, assuming profits are reinvested each year.", "❌ CAGR tooltip incorrect!");

            logger.info("✅ All tooltip messages verified successfully!");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }

        finally {
            logger.info("**** Completed TC_019_VerifyInfoButtonTest ****");
        }
    }

}

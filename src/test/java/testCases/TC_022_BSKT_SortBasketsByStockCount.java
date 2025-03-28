package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.SortingHelperPage;
import testBase.BaseClass;

public class TC_022_BSKT_SortBasketsByStockCount extends BaseClass {
	
	@Test
	public void verifySortingByStockCount() {
		
		try {
			logger.info("**** Started TC_022_BSKT_SortBasketsByStockCount ****");
			
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
			
			Thread.sleep(3000);
			SortingHelperPage sortPage=new SortingHelperPage(driver);
			
			sortPage.clickStockCountHeader();
			Thread.sleep(3000);
			
			Assert.assertTrue(sortPage.isSortedByStockCount(), "Baskets are not sorted correctly by stock count");
			
			
			
		}
		
		catch(Exception e) {
			Assert.fail("Test case failed"+e.getMessage());
			logger.error("Test case failed"+e.getMessage());
		}
		
		finally {
			logger.info("**** Closed TC_022_BSKT_SortBasketsByStockCount ****");
		}
		
		
	}

}

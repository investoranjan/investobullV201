package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.SortingHelperPage;
import testBase.BaseClass;

public class TC_021_BSKT_SortBasketsByName extends BaseClass{
	
	@Test
	public void verifyBasketsSortingByName() {
		
		logger.info("**** Starting TC_021_BSKT_SortBasketsByName ****");
		
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
			
			
			SortingHelperPage sortPage=new SortingHelperPage(driver);
			
			sortPage.clickBasketNameHeader();
			Thread.sleep(3000);
			
			 Assert.assertTrue(sortPage.isSortedAlphabetically(), "Baskets are not sorted correctly");
			
			
			 logger.info("Sorting verification passed.");
		}
		
		catch(Exception e) {
			Assert.fail("Test failed"+e.getMessage());
			logger.error("Test failed"+e.getMessage());

		}
		
		finally {
			
			logger.info("**** Closed TC_021_BSKT_SortBasketsByName ****");
		}
	}

}

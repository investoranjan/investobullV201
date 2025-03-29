package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.FundManagerDeatiledPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_034_ValidateImageUploadFundManagerTest extends BaseClass{
	
	
	@Test
	 public void testValidateImageUploadForFundManager() {
	        logger.info("**** Started TC_034_ValidateImageUploadFundManagerTest ****");

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
	            hp.clickFundManagers(); // Navigate to Fund Manager section

	            Thread.sleep(3000);

	            FundManagerDeatiledPage fundManagerPage = new FundManagerDeatiledPage(driver);

	            logger.info("Clicking on Upload Image icon...");
	            fundManagerPage.clickUploadImageIcon();

	            logger.info("Uploading Image...");
	            fundManagerPage.uploadFundManagerImage(p.getProperty("fundmanagerImagePath"));

	            logger.info("Verifying upload success message...");
	            Assert.assertTrue(fundManagerPage.verifyImageUploadSuccess(), "Image upload failed!");

	        } catch (Exception e) {
	            Assert.fail("Test case failed: " + e.getMessage());
	            logger.error("Test case failed: " + e.getMessage());
	        } finally {
	            logger.info("**** Closed TC_034_ValidateImageUploadFundManagerTest ****");
	        }
	    }

}

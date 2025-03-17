package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketApprovalPage extends BasePage {

	public BasketApprovalPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Pending Stock Baskets']")
	WebElement pendingStockBaskets;
	
	@FindBy(xpath="//a[normalize-space()='View']")
	List<WebElement> viewBasketButtons;
	
	
	
	@FindBy(xpath="//span[normalize-space()='Approve Basket']")
	WebElement viewApproveBasket;
	
	@FindBy(xpath="//a[normalize-space()='Approve Basket']")
	 List<WebElement> approveBasketButtons; 
	
	public void clickPendingStockBaskets() {
		pendingStockBaskets.click();
	}
	
	public int getPendingBasketsCount() {
        return viewBasketButtons.size();
    }
	
	public void clickFirstViewBasket() {
        if (!viewBasketButtons.isEmpty()) {
            viewBasketButtons.get(0).click(); // Clicks the first available "View" button
        } else {
            System.out.println("No pending baskets available.");
        }
    }
	
	public boolean isApproveBasketDisplayed() {
        try {
            return viewApproveBasket.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

	
	 public void clickFirstApproveBasket() {
	        if (!approveBasketButtons.isEmpty()) {
	            approveBasketButtons.get(0).click(); // Clicks the first available "Approve" button
	        } else {
	            System.out.println("No approve buttons available.");
	        }
	    }
	 
	 public void approveAllBaskets() {
		 
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        while (!approveBasketButtons.isEmpty()) {
	            approveBasketButtons.get(0).click();  // Clicks first "Approve" button
	            driver.navigate().back();  // Go back to pending list
	            driver.navigate().refresh();
	        }
	    }
	
	
	
	

}

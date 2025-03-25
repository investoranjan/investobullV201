package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketRejectpage extends BasePage {

	public BasketRejectpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Rejected Stock Baskets']")// Click on Rejected Stock Baskets column
	public
	WebElement rejectedStockBasketsButton;
	
	@FindBy(xpath="/html/body/app-root/div/app-admin-basket-approval/div/div[3]/div/div[1]/div/mat-table/mat-row[1]/mat-cell[11]/div/a")
	public
	 List<WebElement> rejectedBasketViewButtons;//Click on the "view" button on one rejected basket
	
	@FindBy(xpath="//span[normalize-space()='Rejection History']")
	public
	WebElement rejectionHistoryButton;//Click on Rejection History
	
	@FindBy(xpath="//div[@class='ng-star-inserted']//div[1]//div[1]")
	WebElement rejectionHistorySection;
	
	public void clickRejectedBaskets() {
		 rejectedStockBasketsButton.click();
	    }
	
	public int getRejectedBasketsCount() {
        return rejectedBasketViewButtons.size();
    }
	
	public void clickFirstRejectedBasket() {
        if (!rejectedBasketViewButtons.isEmpty()) {
            rejectedBasketViewButtons.get(0).click();
        } else {
            System.out.println("No rejected baskets available.");
        }
    }
	
	public void clickViewRejectedBasket() {
        if (!rejectedBasketViewButtons.isEmpty()) {
            rejectedBasketViewButtons.get(0).click();
        }
    }
	
	
	public void clickRejectionHistory()
	  {
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

	    if (iframes.size() > 0) {
	        // Switch to the first iFrame
	        driver.switchTo().frame(0);
	    }

	    // Click the "Rejection History" button
	    WebElement rejectionHistoryButton = driver.findElement(By.xpath("//span[normalize-space()='Rejection History']"));
	    rejectionHistoryButton.click();

	    // Switch back to the main page
	    driver.switchTo().defaultContent();
	
	  }
	
	public boolean isRejectionHistoryDisplayed() {
        return rejectionHistorySection.isDisplayed();
    }


}

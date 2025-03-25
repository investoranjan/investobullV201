package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketApprovalPage extends BasePage {

	public BasketApprovalPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Pending Stock Baskets']")
	WebElement pendingStockBaskets;

	@FindBy(xpath = "//a[normalize-space()='View']")
	List<WebElement> viewBasketButtons;

	@FindBy(xpath = "//span[normalize-space()='Approve Basket']")
	WebElement viewApproveBasket;

	@FindBy(xpath = "//a[normalize-space()='Approve Basket']")
	List<WebElement> approveBasketButtons;

	@FindBy(xpath = "//span[normalize-space()='Reject Baskets']")
	WebElement rejectBasketButton;

	@FindBy(xpath = "//input[@id='stockBasketRejectionMessage']")
	WebElement rejectionReasonBox;

	@FindBy(xpath = "//button[normalize-space()='Reject Basket']")
	WebElement confirmRejectButton;
	
	@FindBy(xpath="(//input[@id='subscriptionStatus'])[1]")
	WebElement subscriptionToggle;
	
	@FindBy(xpath="//div[@role='alert' and contains(text(), 'Basket subscription has been Paused')]")
	WebElement successNotification;

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

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		while (!approveBasketButtons.isEmpty()) {
			approveBasketButtons.get(0).click(); // Clicks first "Approve" button
			driver.navigate().back(); // Go back to pending list
			driver.navigate().refresh();
		}
	}

	public void clickRejectBasket() {
		rejectBasketButton.click();
	}

	public void enterRejectionReason(String reason) {
		rejectionReasonBox.sendKeys(reason);
	}

	public void confirmRejection() {
		confirmRejectButton.click();
	}
	
	// Method to toggle subscription status
    public void toggleSubscription() {
        subscriptionToggle.click();
    }

    // Method to verify if success notification is displayed
    public boolean isPauseNotificationDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(successNotification)).isDisplayed();
    }

}

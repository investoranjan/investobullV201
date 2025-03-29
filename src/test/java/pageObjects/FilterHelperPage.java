package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterHelperPage extends BasePage {

	public FilterHelperPage(WebDriver driver) {
		super(driver);

	}

	// Add Filter button
	@FindBy(xpath = "//button[normalize-space()='Add Filters']")
	WebElement addFilterButton;

	// Click on Paid button in subscription type
	@FindBy(xpath = "//input[@id='paid']")
	WebElement subscriptionTypePaidButton;

	// Click on Free button in subscription type
	@FindBy(xpath = "//input[@id='free']")
	WebElement subscriptionTypeFreeButton;

	// Click on Risk Low radio button
	@FindBy(xpath = "//input[@id='low']")
	WebElement riskLowButton;

	// Click on Risk medium radio button
	@FindBy(xpath = "//input[@id='medium']")
	WebElement riskMediumButton;

	// Click on Risk high radio button
	@FindBy(xpath = "//input[@id='high']")
	WebElement riskHighButton;
	
	// Click on weekly Rebalance Frequency radio button
	@FindBy(xpath="//input[@id='WEEKLY']")
	WebElement weeklyFrequencyButton;
	
	// Click on Biweekly Rebalance Frequency radio button
	@FindBy(xpath="//input[@id='BIWEEKLY']")
	WebElement biWeeklyFrequencyButton;
	
	// Click on monthly Rebalance Frequency radio button
	@FindBy(xpath="//input[@id='MONTHLY']")
	WebElement monthlyFrequencyButton;
		
		
		
		
	

	// Apply Filter button
	@FindBy(xpath = "//button[normalize-space()='Apply Filter']")
	WebElement applyFilterButton;

	// Subscription column values in filtered results
	@FindBy(xpath = "//mat-cell[contains(@class, 'cdk-column-subscription')]")
	List<WebElement> subscriptionColumnValues;

	// List of displayed basket risk categories means Volatility
	@FindBy(xpath = "//mat-cell[contains(@class, 'cdk-column-volatility')]")
	List<WebElement> riskCategories;
	
	// List of displayed basket risk categories means Volatility
	@FindBy(xpath = "//mat-cell[contains(@class, 'cdk-column-rebalancedFrequency')]	")
	List<WebElement> rebalanceFrequencyColumn;
	
	

	// Click on Filter button
	public void clickAddFilterButton() {
		addFilterButton.click();
	}

	// Click on Paid button in subscription type
	public void clickSubscriptionPaidButton() {
		subscriptionTypePaidButton.click();
	}

	// Click on Free button in subscription type
	public void clickSubscriptionFreeButton() {
		subscriptionTypeFreeButton.click();
	}

	// Click on Risk Low radio button
	public void clickRiskLowButton() {
		riskLowButton.click();
	}

	// Click on Risk Medium radio button
	public void clickRiskMediumButton() {
		riskMediumButton.click();
	}

	// Click on Risk High radio button
	public void clickRiskHighButton() {
		riskHighButton.click();
	}
	
	 // Click Weekly Rebalance Frequency radio button
    public void clickWeeklyRebalanceButton() {
    	weeklyFrequencyButton.click();
    }
    
    
    // Click Weekly Rebalance Frequency radio button
    public void clickbiWeeklyRebalanceButton() {
    	biWeeklyFrequencyButton.click();
    }
    
    
    // Click Weekly Rebalance Frequency radio button
    public void clickMonthlyRebalanceButton() {
    	monthlyFrequencyButton.click();
    }
    

	// Click on Apply filter button
	public void clickapplyFilterButton() {
		applyFilterButton.click();
	}
	
	
    

	// Verify all displayed baskets have Paid Subscription
	public boolean verifyAllBasketsArePaid() {
		for (WebElement element : subscriptionColumnValues) {
			if (!element.getText().equalsIgnoreCase("Paid")) {
				return false;
			}
		}
		return true;
	}

	// Verify all displayed baskets have Free Subscription
	public boolean verifyAllBasketsAreFree() {
		for (WebElement element : subscriptionColumnValues) {
			if (!element.getText().equalsIgnoreCase("Free")) {
				return false;
			}
		}
		return true;
	}

	// Verify all displayed baskets have Low Risk
	public boolean verifyAllBasketsAreLowRisk() {
		for (WebElement riskElement : riskCategories) {
			if (!riskElement.getText().equalsIgnoreCase("Low")) {
				return false; // If any basket is not 'Low', return false
			}
		}
		return true; // All baskets are Low Risk
	}

	// Verify all displayed baskets have Medium Risk
	public boolean verifyAllBasketsAreMediumRisk() {
		for (WebElement riskElement : riskCategories) {
			if (!riskElement.getText().equalsIgnoreCase("Medium")) {
				return false; // If any basket is not 'Medium', return false
			}
		}
		return true; // All baskets are Medium Risk
	}
	
	// Verify all displayed baskets have High Risk
		public boolean verifyAllBasketsAreHighRisk() {
			for (WebElement riskElement : riskCategories) {
				if (!riskElement.getText().equalsIgnoreCase("High")) {
					return false; // If any basket is not 'High', return false
				}
			}
			return true; // All baskets are High Risk
		}

	
	
	
	// Verify all displayed baskets have Weekly Rebalance Frequency
	public boolean verifyAllBasketsAreWeekly() {
        for (WebElement frequency :  rebalanceFrequencyColumn) {
            if (!frequency.getText().equalsIgnoreCase("Weekly")) {
                return false; // If any basket is not 'Weekly', return false
            }
        }
        return true; // All baskets are Weekly
    }
	
	
	// Verify all displayed baskets have BiWeekly Rebalance Frequency
		public boolean verifyAllBasketsAreBiWeekly() {
	        for (WebElement frequency :  rebalanceFrequencyColumn) {
	            if (!frequency.getText().equalsIgnoreCase("BiWeekly")) {
	                return false; // If any basket is not 'BiWeekly', return false
	            }
	        }
	        return true; // All baskets are BiWeekly
	    }
		
		
		// Verify all displayed baskets have Monthly Rebalance Frequency
		public boolean verifyAllBasketsAreMonthly() {
	        for (WebElement frequency :  rebalanceFrequencyColumn) {
	            if (!frequency.getText().equalsIgnoreCase("Monthly")) {
	                return false; // If any basket is not 'Monthly', return false
	            }
	        }
	        return true; // All baskets are Monthly
	    }
	

}

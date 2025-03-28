package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApprovedStockBasketsInfoPage extends BasePage{
	
	private WebDriverWait wait;
    private Actions actions;

	public ApprovedStockBasketsInfoPage(WebDriver driver) {
		super(driver);
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
		
	}
	
	@FindBy(xpath="//span[@mattooltip='Fund Manager Name']//i[@class='fa fa-info-circle']")
	WebElement   infoFundManagerName;
	
	@FindBy(xpath="//span[@class='mat-mdc-tooltip-trigger pointer ng-tns-c1267148319-2']//i[@class='fa fa-info-circle']")
	WebElement infoBasketName  ;
	
	@FindBy(xpath="//span[@mattooltip='Category']//i[@class='fa fa-info-circle']")
	WebElement   infoBasketStrategy;
	
	@FindBy(xpath="//mat-header-cell[contains(., 'Volatility')]//i[@class='fa fa-info-circle']")
	WebElement   infoVolatility;
	
	 @FindBy(xpath = "//mat-header-cell[contains(., 'Re-balance Frequency')]//i[@class='fa fa-info-circle']")
	 WebElement infoRebalanceFrequency;
	
	
	
	@FindBy(xpath="//mat-header-cell[contains(., 'Subscription Type')]//i[@class='fa fa-info-circle']")
	WebElement   infoSubscriptionType;
	
	@FindBy(xpath="//mat-header-cell[contains(., 'No of Stocks')]//i[@class='fa fa-info-circle']")
	WebElement   infoNoOfStocks;
	
	@FindBy(xpath="//mat-header-cell[contains(., 'Min Investment Amount')]//i[@class='fa fa-info-circle']")
	WebElement   infoMinInvestmentAmount;
	
	@FindBy(xpath="//mat-header-cell[contains(., 'CAGR')]//i[@class='fa fa-info-circle']")
	WebElement   infoCAGR;
	
	 @FindBy(xpath = "//div[contains(@class, 'cdk-describedby-message-container')]/div[@role='tooltip']")
	   WebElement mattooltip;
	
	
	 public String getTooltipText(WebElement infoElement) {
		 if (!infoElement.isDisplayed() || !infoElement.isEnabled()) {
	            throw new RuntimeException("Info element is not interactable: " + infoElement);
	        }
	        
	        // Try hover first
	        actions.moveToElement(infoElement).perform();
	        
	        // If hover fails, try JavaScript
	        try {
	            WebElement tooltipText = wait.until(ExpectedConditions.visibilityOf(mattooltip));
	            return tooltipText.getText().trim();
	        } catch (Exception e) {
	            // Fallback: Use JavaScript to trigger hover
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].dispatchEvent(new Event('mouseover'));", infoElement);
	            WebElement tooltipText = wait.until(ExpectedConditions.visibilityOf(mattooltip));
	            return tooltipText.getText().trim();
	        }
	    }
	 
	 public String getFundManagerNameTooltip() {
	        return getTooltipText(infoFundManagerName);
	    }

	    public String getBasketNameTooltip() {
	        return getTooltipText(infoBasketName);
	    }

	    public String getBasketStrategyTooltip() {
	        return getTooltipText(infoBasketStrategy);
	    }

	    public String getVolatilityTooltip() {
	        return getTooltipText(infoVolatility);
	    }

	    public String getRebalanceFrequencyTooltip() {
	        return getTooltipText(infoRebalanceFrequency);
	    }

	    public String getSubscriptionTypeTooltip() {
	        return getTooltipText(infoSubscriptionType);
	    }

	    public String getNoOfStocksTooltip() {
	        return getTooltipText(infoNoOfStocks);
	    }

	    public String getMinInvestmentAmountTooltip() {
	        return getTooltipText(infoMinInvestmentAmount);
	    }

	    public String getCAGRTooltip() {
	        return getTooltipText(infoCAGR);
	    }
	

}

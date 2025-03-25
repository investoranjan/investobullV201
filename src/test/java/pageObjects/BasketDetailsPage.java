package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketDetailsPage extends BasePage{

	public BasketDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	/*@FindBy(xpath="//a[normalize-space()='Basket Admin Approval']")
	WebElement basketAdminApprovalSection;*/
	
	@FindBy(xpath="(//mat-cell[contains(@class, 'mat-column-basketName')]//a)[1]")
	WebElement firstBasketName;
	
	@FindBy(xpath="//span[normalize-space()='Stocks']")
	WebElement stocksTab;
	
	@FindBy(xpath="//h4[normalize-space()='Stocks']")
	WebElement stocksSection;
	
	 /*public void navigateToBasketAdminApproval() {
	        basketAdminApprovalSection.click();
	    }*/
	 
	 public void clickFirstBasket() {
	        firstBasketName.click();
	    }
	 
	 public void clickStocksTab() {
	        stocksTab.click();
	    }
	 
	 public boolean isStocksSectionDisplayed() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        return wait.until(ExpectedConditions.visibilityOf(stocksSection)).isDisplayed();
	    }
	
	
	
	

}

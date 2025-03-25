package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundManagerDeatiledPage extends BasePage{

	
	
	public FundManagerDeatiledPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="(//a[@title='Edit fundManager details'])[1]")
	WebElement fundManagerEditButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Update Fund Manager')]")
    WebElement fundManagerDetailsHeader;
	
	public void clickFirstFundManager() {
		fundManagerEditButton.click();
	}
	
	 public boolean isFundManagerDetailsDisplayed() {
	        return fundManagerDetailsHeader.isDisplayed();
	    }
	
	

}

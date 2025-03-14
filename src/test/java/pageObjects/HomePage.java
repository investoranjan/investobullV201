package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Login/Register']")
	WebElement lnklogin;
	
	@FindBy(xpath="//a[@id='basketAdmin']")
	WebElement basketDropdown;
	
	@FindBy(xpath="//a[normalize-space()='Fund Managers']")
	WebElement fundManagersLink;
	
	public void clicklogin() {
		lnklogin.click();
		
	}
	
	public void clickBasketDropdown() {
		basketDropdown.click();
		
	}
	
	public void clickFundManagers() {
		fundManagersLink.click();
    }

}




package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {

	public AccountLoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='inputEmail']")
	WebElement txtmail;

	@FindBy(xpath = "//input[@id='inputPassword']")
	WebElement txtpassword;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	WebElement btnsignin;

	@FindBy(xpath = "//h2[normalize-space()='Market Action']")
	WebElement marketActionHeading;

	public void setemail(String email) {
		txtmail.clear();
		txtmail.sendKeys(email);
	}

	public void setpwd(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}

	public void clickSignin() {
		btnsignin.click();
	}
	
	public boolean isMarketActionPageDisplayed() {
        return marketActionHeading.isDisplayed();
    }

}

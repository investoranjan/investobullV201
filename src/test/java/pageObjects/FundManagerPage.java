package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundManagerPage extends BasePage {

	public FundManagerPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h1[normalize-space()='Fund Managers']")
	WebElement fundmanagerHeading;
	
	@FindBy(xpath="//mat-header-row[@role='row']")
	WebElement tableFundManagerDetails;
	
	@FindBy(xpath="//a[normalize-space()='Create Fund Manager']")
	WebElement createFundManagerButton;
	
	@FindBy(xpath="//h1[contains(text(),'Create Fund Manager')]")
	WebElement createFundManagerHeader;
	
	@FindBy(xpath="//input[@id='fundManagerFirstName']")
	WebElement txtfundManagerFirstName;
	
	@FindBy(xpath="//input[@id='fundManagerLastName']")
	WebElement txtfundManagerLastName;
	
	
	@FindBy(xpath="(//input[@id='email'])[1]")
	WebElement txtfundManageremailid;
	
	
	@FindBy(xpath="//input[@id='fundManagerPhoneNo']")
	WebElement txtfundManagerphonenumber;
	
	@FindBy(xpath="//input[@placeholder='Enter Experience in Years']")
	WebElement txtfundManagerExperience;
	
	@FindBy(xpath="(//textarea[@id='note'])[1]")
	WebElement txtfundManagerNote;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement txtfundManagerDescription;
	
	@FindBy(xpath="//button[normalize-space()='Save Fund Manager']")
	WebElement btnSubmit;
	
	
	
	
	
	
	public boolean isFundManagerHeaderDisplayed() {
        return fundmanagerHeading.isDisplayed();
    }
	
	 public boolean areFundManagerDetailsDisplayed() {
	        return tableFundManagerDetails.isDisplayed();
	    }
	 
	 
	public void clickCreateFundManager() {
		createFundManagerButton.click();
	}
	
	public void setFirstName(String fname) {
		txtfundManagerFirstName.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
		txtfundManagerLastName.sendKeys(lname);
		
	}
	
	public void setemailid(String email) {
		txtfundManageremailid.sendKeys(email);
		
	}
	
	public void setphonenum(String mobno) {
		txtfundManagerphonenumber.sendKeys(mobno);
	}
	
	public void setexp(String exp) {
		txtfundManagerExperience.sendKeys(exp);
	}
	
	public void setNote(String note) {
		txtfundManagerNote.sendKeys(note);
	}
	
	public void setDescription(String des) {
		txtfundManagerDescription.sendKeys(des);
	}
	
	public void clicksubmit() {
		
		btnSubmit.click();
	}
	
	
	
	public boolean isCreateFundManagerPageDisplayed() {
	    return createFundManagerHeader.isDisplayed();
	}
	

}

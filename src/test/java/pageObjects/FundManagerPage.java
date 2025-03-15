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
	
	@FindBy(xpath="//p[contains(text(),'Special characters and number are not allowed in F')]")
	WebElement firstNameError;
	
	@FindBy(xpath="//p[contains(text(),'Special characters and number are not allowed in L')]")
	WebElement lastNameError;
	
	@FindBy(xpath="//p[normalize-space()='Plase enter valid Email id.']")
	WebElement emailError;
	
	@FindBy(xpath="//p[normalize-space()='Plase enter valid 10 digit Phone Number']")
	WebElement phoneNoError;
	
	@FindBy(xpath="//p[normalize-space()='Years of experience is required!']")
	WebElement experienceError ;
	
	@FindBy(xpath="//p[normalize-space()='Description is required!']")
	WebElement descriptionError ;
	
	
	
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
	
	
	public boolean isFirstNameErrorDisplayed() {
		return firstNameError.isDisplayed();
	}
	
	public boolean isLastNameErrorDisplayed() {
		return lastNameError.isDisplayed();
	}
	
	public boolean isEmailErrorDisplayed() {
		
		return emailError.isDisplayed();
	}
	
	public boolean isPhonenumberErrorDisplayed() {
		return phoneNoError.isDisplayed();
		
	}
	
	public boolean isExperienceErrorDisplayed() {
		return experienceError.isDisplayed();
	}
	
	public boolean isDescriptionErrorDisplayed() {
		return descriptionError.isDisplayed();
	}

}

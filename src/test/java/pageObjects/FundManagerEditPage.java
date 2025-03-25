package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundManagerEditPage extends BasePage {

	public FundManagerEditPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//a[@title='Edit fundManager details'])[1]")
	WebElement fundmanagerEditButton;
	
	@FindBy(xpath="//input[@id='fundManagerPhoneNo']")// For new number
	WebElement mobileNumberField;
	
	@FindBy(xpath="//input[@id='fundManagerPhoneNo']")// For old existing number
	WebElement mobilenumberfield;
	
	@FindBy(xpath="//input[@placeholder='Enter Experience in Years']")
	WebElement experiencefield;
	
	@FindBy(xpath="//textarea[@id='note']")
	WebElement notefield;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement descriptionfield;
	
	
	
	@FindBy(xpath="//button[normalize-space()='Update Fund Manager']")
	WebElement updateButton;
	
	 @FindBy(xpath = "//div[@role='alert' and contains(text(), 'Phone No Already registered')]") 
	    WebElement duplicateErrorPopup;
	 
	 @FindBy(xpath = "//div[@role='alert' and contains(text(), 'Fund manager Updated Successfully')]") 
	    WebElement successPopup;

	
	@FindBy(xpath = "//h1[normalize-space()='Fund Managers']")
    WebElement fundManagerpageHeader;
	
	
	public void clickFirstFundManager() {
		fundmanagerEditButton.click();
	}
	
	public void updateExperience(String experience) {
		experiencefield.clear();
		experiencefield.sendKeys(experience);
    }
	
	 public void updateNote(String note) {
		 notefield.clear();
		 notefield.sendKeys(note);
	    }

	    public void updateDescription(String description) {
	    	descriptionfield.clear();
	    	descriptionfield.sendKeys(description);
	    }
	public void updatemobilenumber(String newNumber) {
		mobileNumberField.clear();
		
		mobileNumberField.sendKeys(newNumber);
	}
	
	/*public void updateMobilenumberwitholdone(String oldNumber) throws Exception//WIth existing mobile number
	{
		mobileNumberField.clear();
		Thread.sleep(2000);
		mobileNumberField.sendKeys(oldNumber);
	}*/
	
	public void updateMobilenumberwitholdone(String oldNumber) {
		mobilenumberfield.clear();

	    if (oldNumber == null || oldNumber.trim().isEmpty()) {
	        throw new IllegalArgumentException("Mobile number cannot be null or empty!");
	    }

	    mobilenumberfield.sendKeys(oldNumber);
	}
	
	
	
	
	
	public void clickupdatebutton() {
		updateButton.click();
	}
	
	 public boolean isDuplicateErrorDisplayed() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        return wait.until(ExpectedConditions.visibilityOf(duplicateErrorPopup)).isDisplayed();
	    }
	 
	 public boolean isUpdateSuccessDisplayed() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        return wait.until(ExpectedConditions.visibilityOf(successPopup)).isDisplayed();
	    }
	
	public boolean isFundManagerDetailsDisplayed() {
        return fundManagerpageHeader.isDisplayed();
    }


}

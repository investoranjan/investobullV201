package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundManagerDeatiledPage extends BasePage{

	
	
	public FundManagerDeatiledPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="(//a[@title='Edit fundManager details'])[1]")
	WebElement fundManagerEditButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Update Fund Manager')]")
    WebElement fundManagerDetailsHeader;
	
	
	// Upload Icon (Clickable element)
	@FindBy(xpath = "//i[contains(@class,'bx-cloud-upload')]")
    WebElement uploadIcon;
	
	
	// Hidden File Input
	@FindBy(xpath = "//input[@type='file' and @accept='image/jpeg,image/jpg']")
    WebElement fileInput;
	
	// Success Message 
	@FindBy(xpath = "//div[contains(text(),'Profile picture has been successfully uploaded')]")
    WebElement successMessage;
	
	
	public void clickFirstFundManager() {
		fundManagerEditButton.click();
	}
	
	 public boolean isFundManagerDetailsDisplayed() {
	        return fundManagerDetailsHeader.isDisplayed();
	    }
	
	// Click on the upload icon
	    public void clickUploadImageIcon() {
	        uploadIcon.click();
	    }
	
	    public void uploadFundManagerImage(String fundmanagerImagePath) {
	        fileInput.sendKeys(fundmanagerImagePath);
	    }

	    // Verify Upload Success Message
	    public boolean verifyImageUploadSuccess() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
	    }

}

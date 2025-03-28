package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	
	WebDriverWait wait;
    Actions actions;


	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	/*public void waitForElementToBeVisible(org.openqa.selenium.WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }*/

}

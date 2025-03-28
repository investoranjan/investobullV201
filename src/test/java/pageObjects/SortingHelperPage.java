package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortingHelperPage extends BasePage{

	public SortingHelperPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//sort column by Basket Name
	@FindBy(xpath="//mat-header-cell[contains(@class, 'mat-sort-header') and contains(@class, 'mat-column-basketName')]")
	 WebElement basketNameSortHeader;
	
	
	//sort column by no of stocks
	@FindBy(xpath = "//div[contains(@class, 'mat-sort-header-container') and contains(., 'No of Stocks')]")
	 WebElement stockCountColumn;

	
	
	@FindBy(xpath = "//mat-cell[contains(@class, 'cdk-column-authorName')]")  
	 List<WebElement> stockCounts;
	
	
	
	@FindBy(xpath = "//mat-cell[contains(@class, 'mat-column-basketName')]/a")
     List<WebElement> basketNames;
	
	//sort column by Min Investment Amount
	@FindBy(xpath="//mat-header-cell[contains(@class, 'mat-sort-header') and contains(@class, 'mat-column-minimumInvestment')]")
	WebElement MinInvestmentSortHeader;
	
	@FindBy(xpath="//mat-cell[contains(@class, 'mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-minimumInvestment mat-column-minimumInvestment ng-star-inserted')]")
	List<WebElement> minInvestmentAmounts;
	
	@FindBy(xpath="//mat-header-cell[contains(@class, 'mat-sort-header') and contains(@class, 'mat-column-totalReturnPct')]")
	WebElement cagrsortHeader;
	
	@FindBy(xpath = "//mat-cell[contains(@class, 'mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-totalReturnPct mat-column-minimumInvestment ng-star-inserted')]")
	List<WebElement> cagrValues;
	
	
	
	

	public void clickBasketNameHeader() {
		basketNameSortHeader.click();
    }

    public List<WebElement> getBasketNames() {
        return basketNames;
    }
    
    public void clickStockCountHeader() {
        stockCountColumn.click();
    }

    public List<WebElement> getStockCounts() {
        return stockCounts;
    }
    
    public boolean isSortedByStockCount() {
        List<Integer> stockNumbers = new ArrayList<>();

        for (WebElement element : stockCounts) {
            String text = element.getText().trim();

            // Check if the text is a valid number before parsing
            if (text.matches("\\d+")) {  
                stockNumbers.add(Integer.parseInt(text));
            } else {
                System.out.println("Skipping non-numeric value: " + text);
            }
        }

        for (int i = 0; i < stockNumbers.size() - 1; i++) {
            if (stockNumbers.get(i) > stockNumbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSortedAlphabetically() {
        for (int i = 0; i < basketNames.size() - 1; i++) {
            if (basketNames.get(i).getText().compareToIgnoreCase(basketNames.get(i + 1).getText()) > 0) {
                return false;
            }
        }

        return true;

    }
    
    public void clickByMinInvestmentHeader() {
    	MinInvestmentSortHeader.click();
    }
    
    public boolean isSortedByMinInvestment() {
       // List<WebElement> investmentElements = driver.findElements(minInvestmentAmounts);
        double previousAmount = 0.0;
        
        for (WebElement element : minInvestmentAmounts) {
            double currentAmount = Double.parseDouble(element.getText().replaceAll("[^0-9.]", ""));
            if (currentAmount < previousAmount) {
                return false; // Sorting failed
            }
            previousAmount = currentAmount;
        }
        return true;
    }
    
    public void clickByCAGRHeader() {
    	cagrsortHeader.click();
    }
    
    
    public boolean isSortedByCAGR() {
        double previousCAGR = 0.0;

        for (WebElement element : cagrValues) {
            String text = element.getText().replaceAll("[^0-9.]", "").trim();

            if (!text.isEmpty()) {
                double currentCAGR = Double.parseDouble(text);

                if (currentCAGR < previousCAGR) {
                    return false; // Sorting failed
                }
                previousCAGR = currentCAGR;
            }
        }
        return true;
    }
    
    
    
    
}

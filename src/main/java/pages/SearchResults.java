package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtility;
import utils.ElementsUtils;

public class SearchResults {

	WebDriver driver;
	private ElementsUtils elementsUtils;
	public SearchResults(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//input[@id='button-search']//following-sibling::p")
	private WebElement productNotMatchMessage;
	
	
	
	
	public boolean displayStatusOfValidProduct() {
		return elementsUtils.displayStatusOfElement(validHPProduct, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
	
	public String retriveNoProductMatchMessage() {
		return elementsUtils.getTextValueFromWebElement(productNotMatchMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
}

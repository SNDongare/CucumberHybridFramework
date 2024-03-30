package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtility;
import utils.ElementsUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private ElementsUtils elementsUtils;
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//p")
	private WebElement accountSuccessPageHeading;
	
	
	public String retriveAccountSuccessPageTitle() {
		return elementsUtils.getTextValueFromWebElement(accountSuccessPageHeading, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
}

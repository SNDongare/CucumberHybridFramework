package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtility;
import utils.ElementsUtils;

public class HomePage {

	WebDriver driver;
	private ElementsUtils elementsUtils;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@class='form-control input-lg']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//input[@name='search']//following-sibling::span")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		elementsUtils.clickOnWebElement(myAccountDropMenu, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
	
	public LoginPage selectLoginOption() {
		elementsUtils.clickOnWebElement(loginOption, CommonUtility.EXPLICIT_MEDIUM_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		elementsUtils.clickOnWebElement(registerOption, CommonUtility.EXPLICIT_MEDIUM_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterProductTestInToSearchBox(String valiProductText) {
		elementsUtils.enterValueInToTextField(searchBoxField, valiProductText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
	
	public SearchResults clickOnSearchButton() {
		elementsUtils.clickOnWebElement(searchButton, CommonUtility.EXPLICIT_MEDIUM_TIME);
		return new SearchResults(driver);
	}
}

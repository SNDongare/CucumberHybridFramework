package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtility;
import utils.ElementsUtils;

public class LoginPage {

	WebDriver driver;
	private ElementsUtils elementsUtils;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	
	
	public void enterEmailAddress(String emailText) {
		elementsUtils.enterValueInToTextField(emailTextField, emailText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
	
	public void enterPassword(String passwordField) {
		elementsUtils.enterValueInToTextField(passwordTextField, passwordField, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
	
	public AccountPage clickOnLoginButton() {
		elementsUtils.clickOnWebElement(loginButton, CommonUtility.EXPLICIT_MEDIUM_TIME);
		return new AccountPage(driver);
	}
	
	public String retriveWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(warningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
}

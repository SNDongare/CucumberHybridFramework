package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtility;
import utils.ElementsUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementsUtils elementsUtils;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameField;

	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastNameField;

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;

	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneField;

	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;

	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPasswordField;

	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyOption;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;

	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	private WebElement newseLettrField;

	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarningMessage;

	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarningMessage;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningMessage;


	public void enterFirstName(String firstNameText) {
		elementsUtils.enterValueInToTextField(firstNameField, firstNameText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public void enterLastName(String lastNameText) {
		elementsUtils.enterValueInToTextField(lastNameField, lastNameText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public void enterEmailAddress(String emailText) {
		elementsUtils.enterValueInToTextField(emailField, emailText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public void enterTelephoneNo(String telephoneText) {
		elementsUtils.enterValueInToTextField(telephoneField, telephoneText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public void enterPassword(String passwordText) {
		elementsUtils.enterValueInToTextField(passwordField, passwordText, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public void enterConfirmPassword(String confirmPassText) {
		elementsUtils.enterValueInToTextField(confirmPasswordField, confirmPassText, CommonUtility.EXPLICIT_MEDIUM_TIME);
		}

	public void selectPrivacyPolicyOption() {
		elementsUtils.clickOnWebElement(privacyPolicyOption, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public AccountSuccessPage clickOnContinueButton() {
		elementsUtils.clickOnWebElement(continueButton, CommonUtility.EXPLICIT_MEDIUM_TIME);
		return new AccountSuccessPage(driver);
	}

	public void clickOnNewsLetterYesRadioButton() {
		elementsUtils.clickOnWebElement(newseLettrField, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retrivePrivacyPolicyWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(privacyPolicyWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retriveFirstNameWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(firstNameWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retriveLastNameWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(lastNameWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retriveEmailWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(emailWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retriveTelephoneWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(telephoneWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retrivePasswordWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(passwordWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}

	public String retriveDuplicateEmailWarningMessage() {
		return elementsUtils.getTextValueFromWebElement(duplicateEmailWarningMessage, CommonUtility.EXPLICIT_MEDIUM_TIME);
	}
}

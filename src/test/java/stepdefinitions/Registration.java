package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtility;

public class Registration {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;

	@Given("User navigate to Register account page")
	public void user_navigate_to_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();
	}

	@When("User enter the below details into the field")
	public void User_enter_the_below_details_into_the_field(DataTable dataTable) throws InterruptedException {
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(map.get("firstname"));
		registerPage.enterLastName(map.get("lastname"));
		registerPage.enterEmailAddress(CommonUtility.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNo(map.get("mobilenumber"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));
	}

	@And("select privacy policy")
	public void select_privacy_policy() {
		registerPage.selectPrivacyPolicyOption();
	}

	@And("click on continue button")
	public void click_on_continue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
		Assert.assertEquals("Congratulations! Your new account has been successfully created!",
				accountSuccessPage.retriveAccountSuccessPageTitle());

	}

	@When("Select Yes for Newslatter")
	public void select_yes_for_newslatter() {
		registerPage.clickOnNewsLetterYesRadioButton();
	}

	@When("User dont enters details into the any fields")
	public void user_dont_enters_details_into_the_any_fields() {
		// Intentionally kept blank..don't right code here
	}

	@Then("warning messages should be displayed under all mandatory fields")
	public void warning_messages_should_be_displayed_under_all_mandatory_fields() {
		Assert.assertTrue(registerPage.retrivePrivacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.retriveFirstNameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.retriveLastNameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.retriveEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.retriveTelephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.retrivePasswordWarningMessage());

	}

	@Then("warning message informing to the user about duplicate email address")
	public void warning_message_informing_to_the_user_about_duplicate_email_address() {
		Assert.assertTrue(registerPage.retriveDuplicateEmailWarningMessage().contains("Warning: E-Mail Address is already registered!"));
	}

}

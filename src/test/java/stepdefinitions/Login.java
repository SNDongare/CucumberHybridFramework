package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtility;

public class Login {

	WebDriver driver;

	private LoginPage loginPage=new LoginPage(driver);
	private AccountPage accountPage=new AccountPage(driver);

	@Given("User navigated to login page")
	public void User_navigated_to_login_page() throws Exception {
		driver = DriverFactory.getDriver();
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("^user enters valid email (.+) address$")
	public void user_enters_valid_email_address(String email) throws Exception {
		loginPage.enterEmailAddress(email);
	}

	@And("^user enters valid (.+) password$")
	public void user_enters_valid_password(String password) throws Exception {
		loginPage.enterPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() throws Exception {
		accountPage=loginPage.clickOnLoginButton();
	}

	@Then("user should be able to successfully login")
	public void user_should_be_able_to_successfully_login() throws Exception {
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("user enters Invalid email address")
	public void user_enters_Invalid_email_address() throws Exception {
		loginPage.enterEmailAddress(CommonUtility.generateEmailWithTimeStamp());
	}

	@And("user enters Invalid password {string}")
	public void user_enters_Invalid_password(String invalidPassword) throws Exception {
		loginPage.enterPassword(invalidPassword);
	}

	@Then("user should get proper warning message")
	public void user_should_get_proper_warning_message() throws Exception {
		Assert.assertTrue(loginPage.retriveWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user don’t enters any email address")
	public void user_don_t_enters_any_email_address() throws Exception {
		loginPage.enterEmailAddress("");
	}

	@And("user don’t enters any  password")
	public void user_don_t_enters_any_password() throws Exception {
		loginPage.enterPassword("");
	}
}

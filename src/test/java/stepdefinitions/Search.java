package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResults;

public class Search {

	WebDriver driver;
	HomePage homePage;
	SearchResults searchResults;
	@Given("user opens the application")
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();
		
		System.out.println(">> user open application");
	}

	@When("user enter valid product {string} into the search field")
	public void user_enter_valid_product_into_the_search_field(String validProduct) {
		 homePage=new HomePage(driver);
		homePage.enterProductTestInToSearchBox(validProduct);
	}

	@And("user click on search button")
	public void user_click_on_search_button() {
		searchResults=homePage.clickOnSearchButton();
	}

	@Then("valid product should get displayed in search result")
	public void valid_product_should_get_displayed_in_search_result() {
		Assert.assertTrue(searchResults.displayStatusOfValidProduct());
	}

	@When("user enter non existing product into the search field {string}")
	public void user_enter_non_existing_product_into_the_search_field(String invalidProduct) {
		homePage=new HomePage(driver);
		homePage.enterProductTestInToSearchBox(invalidProduct);
	
	}

	@Then("proper text formating the user about no product matching should be displayed")
	public void proper_text_formating_the_user_about_no_product_matching_should_be_displayed() {
		Assert.assertTrue(searchResults.retriveNoProductMatchMessage().contains("There is no product that matches the search criteria."));
	}

	@When("user dont enter product into the search field")
	public void user_dont_enter_product_into_the_search_field() {
		homePage=new HomePage(driver);
	}

}

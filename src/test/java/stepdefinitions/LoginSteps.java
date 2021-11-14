package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on {string} page")
	public void user_is_on_page(String key) {
		DriverFactory.getDriver().navigate().to(ConfigReader.getProperty(key));
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.equals(expectedTitle));
	}

	@When("user enters username")
	public void user_enters_username() {
		loginPage.enterUserName();
	}
	
	@When("user enters wrong username")
	public void user_enters_wrong_username() {
		loginPage.enterWrongUserName();
	}
	
	@When("user enters wrong password")
	public void user_enters_wrong_password() {
		loginPage.enterWrongPassword();
	}

	@When("user enters password")
	public void user_enters_password() {
		loginPage.enterPassword();
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginBtn();
	}

	@When("user clicks on Sign in with AWS link")
	public void user_clicks_on_Sign_in_with_AWS_link() {
		loginPage.clickOnSignInWithAWS();
	}

	@When("user clicks on Okta under sign in with your corporate id")
	public void user_clicks_on_Okta_under_sign_in_with_your_corporate_id() {
		loginPage.clickOnSignInWithOkta();
	}

	@When("verify {string} link exist")
	public void verify_link_exist(String text) {
		Assert.assertTrue(loginPage.verifyForgotPasswordLink(text));
	}

	@When("verify user gets {string} error message")
	public void verify_user_gets_error_message(String error) {
		Assert.assertTrue(loginPage.verifyloginPageErrorMessage(error));
	}
	
}
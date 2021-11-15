package stepdefinitions;

import java.util.List;

import org.junit.Assert;

import com.pages.DatawareHouseLandingPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DatawareHouseLandingSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private DatawareHouseLandingPage datawareLandingPage;

	@When("user has already logged in to DatawareHouse application")
	public void user_has_already_logged_in_to_DatawareHouse_application() {
		//DriverFactory.getDriver().get("https://baincapital.oktapreview.com");
		DriverFactory.getDriver().get(ConfigReader.getProperty("common-qa-ui"));
		datawareLandingPage = loginPage.doLogin();
	}

	@Given("user is on DatawareHouseLanding page")
	public void user_is_on_DatawareHouseLanding_page() {
		String title = datawareLandingPage.getDatawareHouseHomePageTitle();
		Assert.assertTrue(title.contains("Data Warehouse"));
	}
	
	@When("user refreshes the page")
	public void user_refreshes_the_page() {
		datawareLandingPage.refreshesPage();
	}
	
	@When("verify {string} text on Page")
	public void verify_text_on_page(String text) {
		Assert.assertTrue(datawareLandingPage.verifyText(text));
	}
	
	@When("verify header links on homepage")
	public void verify_header_links_on_homepage(DataTable data) {
		List<String> homepageLinks = data.asList();
		for(String link: homepageLinks) {
			System.out.println(link);
		}
		Assert.assertTrue(datawareLandingPage.verifyHomePageLinks(homepageLinks));
	}
	

}

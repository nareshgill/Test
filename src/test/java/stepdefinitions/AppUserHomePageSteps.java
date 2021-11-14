package stepdefinitions;

import com.pages.AppUserHomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;

public class AppUserHomePageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AppUserHomePage appUser;

	@Given("user has already logged with bainnonprod account")
	public void user_has_already_logged_in_to_bainnonprod() {
		DriverFactory.getDriver().get("https://baincapital.oktapreview.com");
		appUser = loginPage.doLoginBainNonProd();

	}

	@Given("user is on appuser page")
	public void user_is_on_appuser_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		String title = appUser.getAppUserHomePageTitle();
		System.out.println("AppUserHomePage title is: " + title);
	}
	
	

}

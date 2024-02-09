package checkingFilters;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.FiltersonWalkinsListing;
import pom.userActions.LoginPage;

public class FiltersonWalkinPage extends BaseTest {

	// Not working right, need changes
	// Page is getting refreshed when filter page is opened

	@Test
	public void TC01() {
//Login with Administrator User 	
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		FiltersonWalkinsListing checkFilters = new FiltersonWalkinsListing(driver);
		checkFilters.gotoWalkins();
		checkFilters.clickonFilter();
		checkFilters.selectProjectname2("Malpani");
		checkFilters.applyFilter();

	}

}

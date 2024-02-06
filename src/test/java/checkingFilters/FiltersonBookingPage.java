package checkingFilters;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.FiltersonBookingsListing;
import pom.userActions.LoginPage;

public class FiltersonBookingPage extends BaseTest {

	@Test
	public void TC01() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		FiltersonBookingsListing checkFilter = new FiltersonBookingsListing(driver);
		checkFilter.gotoBookings();
		checkFilter.clickonFilter();
		checkFilter.selectProjectname2("Malpani");
//		checkFilter.selectApprovalStatus("Approved");
//		checkFilter.selectChannelPartner("Joy boy");
		checkFilter.enterBookedOndate("10/10/2023 - 10/01/2024");
		checkFilter.applyFilter();
		checkFilter.printTheCount();

	}

}

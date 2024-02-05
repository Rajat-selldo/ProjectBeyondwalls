package checkingFilters;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.FiltersonBookingsListing;
import pom.userActions.LoginPage;

public class FiltersonBookingPage extends BaseTest {

	public void logIn() {
//Login with Administrator User 	
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}

	@Test
	public void TC01() {
		logIn();
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

	public void TC02() {

	}

}

package dsmActions;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromDsm;
import pom.userActions.LoginPage;

public class BookingActions extends BaseTest {

	// DSM actions like Booking Details, Approve/Reject Booking, etc. on the Booking
	@Test
	public void bookingActions() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("dsmPune"));
		ActionsFromDsm dsmUser = new ActionsFromDsm(driver);
		dsmUser.goToBookings();
		dsmUser.clickonbookingEllipsis();
//		dsmUser.clickonBookingDetails();
//		dsmUser.approveBooking();
//		dsmUser.rejectBooking();
		dsmUser.clickOnbookingDocuments();

	}

}

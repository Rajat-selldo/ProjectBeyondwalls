package cphActions;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromCph;
import pom.userActions.LoginPage;

public class BookingActions extends BaseTest {

	@Test
	public void bookingActions() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cphPune"));
		ActionsFromCph cphUser = new ActionsFromCph(driver);
		cphUser.goToBookings();
		cphUser.clickonbookingEllipsis();
		cphUser.clickonBookingDetails();

	}
}

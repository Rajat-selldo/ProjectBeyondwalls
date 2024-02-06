package cphActions;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromCph;
import pom.userActions.LoginPage;

public class CphActions extends BaseTest {
	
	public void logIn() {
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916954535251");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}

//CPH actions on Walk-in such as Walk-in Details, BW Approve/Reject 	
	@Test
	public void walkinActions() {
		logIn();
		ActionsFromCph cphUser = new ActionsFromCph(driver);
		cphUser.clickonWalkinLink();
		cphUser.clickonEllipsis();
		cphUser.walkindetails();

	}

	@Test
	public void bookingActions() {
		logIn();
		ActionsFromCph cphUser = new ActionsFromCph(driver);
		cphUser.goToBookings();
		cphUser.clickonbookingEllipsis();
		cphUser.clickonBookingDetails();

	}

}

package testScripts;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromDsm;
import pom.userActions.LoginPage;

public class DsmActions extends BaseTest {
	
	// Login with DSM user
	public void logIn() {
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919156555453");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}

// DSM actions like Walk-in Details, Approve/Reject Walk-in, etc. on the Walk-ins 	
	@Test
	public void walkinActions() {
		logIn();
		ActionsFromDsm dsmUser = new ActionsFromDsm(driver);
		dsmUser.goToWalkins();
		dsmUser.clickonEllipsis();
		dsmUser.clickonWalkinDetails();
//		dsmUser.approveWalkin();
//		dsmUser.rejectWalkin();
//		dsmUser.clickonwalkinDocuments();

	}

// DSM actions like Booking Details, Approve/Reject Booking, etc. on the Booking 
	@Test
	public void bookingActions() {
		logIn();
		ActionsFromDsm dsmUser = new ActionsFromDsm(driver);
		dsmUser.goToBookings();
		dsmUser.clickonbookingEllipsis();
//		dsmUser.clickonBookingDetails();
//		dsmUser.approveBooking();
//		dsmUser.rejectBooking();
		dsmUser.clickOnbookingDocuments();

	}

}

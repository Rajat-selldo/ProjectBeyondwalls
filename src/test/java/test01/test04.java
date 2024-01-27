package test01;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddBooking;
import pom.userActions.LoginPage;

public class test04 extends BaseTest {
	
	
	//Direct Add Booking on existing walk-in Flow 

	@Test
	public void logIn() throws InterruptedException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916200000003");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

	}
	
	@Test
	public void addBooking() throws InterruptedException, AWTException, IOException {
		System.out.println("checking booking code is running or not.");
		logIn();
		AddBooking addBookingForm = new AddBooking(driver);
		addBookingForm.clickonWalkins();
		addBookingForm.openOptionsMenu();
		addBookingForm.clickonAddBooking();
		addBookingForm.enterTowerName("Tower " + Random("N",1));
		addBookingForm.enterUnitName(Random("A",1) + "-" + Random("N",4));
		addBookingForm.enterUnitConfiguration("1BHK");
		addBookingForm.enterConsiderationValue("4400000");

// Booked On and Tentative agreement date 
		//addBookingForm.clickonBookedOn("03/01/2024");
		addBookingForm.clickonTentativeAgreementDate("05/01/2024");

		//Got stuck in the handling prompt alert,  Not resolved...  
		
		addBookingForm.bookingSource("Channel");
		addBookingForm.managerSelection("Rocks");
		addBookingForm.submitForm();
		//addBookingForm.handleConfirmationPopup();

	}
}

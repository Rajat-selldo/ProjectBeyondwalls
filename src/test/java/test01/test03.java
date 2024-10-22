package test01;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddBooking;
import pom.userActions.InterestedProject;
import pom.userActions.LoginPage;

public class test03 extends BaseTest {

	@Test
	public void pp1() throws AWTException, InterruptedException, IOException {

		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916200000001");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

		//Add Bookings 
		AddBooking addBookingForm = new AddBooking(driver);
		addBookingForm.clickonWalkins();
		addBookingForm.openOptionsMenu();
		addBookingForm.clickonAddBooking();
		addBookingForm.submitForm();
		addBookingForm.handleConfirmationPopup();
		
//		Runtime.getRuntime().exec("D://BW Automation/AutoIT/Bookingpopup_click_OK.exe");
//		System.out.println("AutoIT script is working");
//		wait(2000);
	}
	
}

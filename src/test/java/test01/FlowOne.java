package test01;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddBooking;
import pom.userActions.AddWalkin;
import pom.userActions.LoginPage;

public class FlowOne extends BaseTest {

	@Test
	public void logIn() throws InterruptedException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916200000001");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

// Log out flow
//			userCreds.clickonProfile();
//			userCreds.clickonSignout();
//			System.out.println("User logged out successfully.");

	}

	@Test
	public void addWalkIn() throws InterruptedException {
		System.out.println("checking Walk-in code is running or not.");
		logIn();
		AddWalkin addWalkinForm = new AddWalkin(driver);
		addWalkinForm.goToWalkins();
		addWalkinForm.clickonAddWalkin();
		addWalkinForm.enterFirstName("Mohit");
		addWalkinForm.enterLastName("Chauhan");
		addWalkinForm.enterWalkinEmail("mohit.chauhan902@mailinator.com");

		addWalkinForm.enterWalkinPhone("6900000012");

		// Project drop-down selection 
		addWalkinForm.selectProject("Codename Ritz (Pune)");
		
	
//Walk-in Calendar 
//		addWalkinForm.walkinCalendar();
		addWalkinForm.datePicker("08/12/2023","03:30");
		
	
////Walk-in Time 
//		//Retrieve hours 
//		System.out.println("Hours in the clock");
//		driver.findElement(By.xpath("(//div[@class='timepicker-picker'])[1]")).click();
//		List<WebElement> hourElements = driver.findElements(By.xpath("(//div[@class='timepicker-hours'])[1]"));
//		for (WebElement hourElement : hourElements) {
//		    String hourText = hourElement.getText();
//		    System.out.println("Hour: " + hourText);
//		}
		
		
		addWalkinForm.clickonSave();
 
	}

	
	@Test
	public void addBooking() throws InterruptedException, AWTException {
		System.out.println("checking booking code is running or not.");
		addWalkIn();
		AddBooking addBookingForm = new AddBooking(driver);
		addBookingForm.clickonWalkins();
		addBookingForm.openOptionsMenu();
		addBookingForm.clickonAddBooking();
		addBookingForm.enterTowerName("Tower Z");
		addBookingForm.enterUnitName("Z-901");
		addBookingForm.enterUnitConfiguration("1BHK");
		addBookingForm.enterConsiderationValue("9000000");
		
// Booked On and Tentative agreement date 
		addBookingForm.bookingSource("10/12/2023");
		addBookingForm.clickonTentativeAgreementDate("30/12/2023");
		
		addBookingForm.bookingSource("Channel");
		addBookingForm.managerSelection("Rajat");
		
		addBookingForm.submitForm();

	}

}

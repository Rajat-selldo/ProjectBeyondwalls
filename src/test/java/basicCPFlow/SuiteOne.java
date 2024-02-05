package basicCPFlow;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddBooking;
import pom.userActions.AddWalkin;
import pom.userActions.LoginPage;

public class SuiteOne extends BaseTest {

	public void addWalkIn() throws InterruptedException {
		System.out.println("checking Walk-in code is running or not.");
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cpPhone2"));
		AddWalkin addWalkinForm = new AddWalkin(driver);
		addWalkinForm.goToWalkins();
		addWalkinForm.clickonAddWalkin();
		addWalkinForm.enterFirstName(Random("A", 7));
		addWalkinForm.enterLastName(Random("A", 8));
		addWalkinForm.enterWalkinEmail("raj" + Random("A", 10) + "@mailinator.com");

		addWalkinForm.enterWalkinPhone("7" + Random("N", 9));

// Project drop-down selection
		addWalkinForm.selectProject("Sommet (Pune)");

//Walk-in Calendar 
		addWalkinForm.datePicker("05/02/2024", "04:30");
		addWalkinForm.clickonSave();
		System.out.println("Walkin added successfully.");
	}

	public void conductWalkin() throws InterruptedException, IOException {
		addWalkIn();
		AddWalkin addWalkinForm = new AddWalkin(driver);
//After walk-in is added, then mark walk-in as conducted and document upload flow 
//		addWalkinForm.markAsConducted();
//		addWalkinForm.uploadDocumentsonWalkin();
//		System.out.println("Mark as Conducted method is successfully running.");
	}

	@Test
	public void addBooking() throws InterruptedException, AWTException, IOException {
		System.out.println("checking booking code is running or not.");
		conductWalkin();
		AddBooking addBookingForm = new AddBooking(driver);
		addBookingForm.clickonWalkins();
		addBookingForm.openOptionsMenu();
		addBookingForm.clickonAddBooking();
		addBookingForm.enterTowerName("Tower " + Random("A", 1));
		addBookingForm.enterUnitName(Random("A", 1) + "-" + Random("N", 3));
		addBookingForm.enterUnitConfiguration("1BHK");
		addBookingForm.enterConsiderationValue("6294001");

// Booked On and Tentative agreement date 
		// addBookingForm.clickonBookedOn("03/01/2024");
		addBookingForm.clickonTentativeAgreementDate("27/02/2024");
		addBookingForm.bookingSource("Channel");
		addBookingForm.managerSelection("Rocks");
		addBookingForm.submitForm();

//Got stuck in the handling prompt alert,  Not resolved...  
		// addBookingForm.handleConfirmationPopup();

	}

}

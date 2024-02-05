package basicCPFlow;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddBooking;

public class ADDBooking extends BaseTest {

	@Test
	public void addBooking() throws InterruptedException, AWTException, IOException {
		System.out.println("checking booking code is running or not.");
		ConductWalkin conduct = new ConductWalkin();
		conduct.conductWalkin();
		AddBooking addBookingForm = new AddBooking(driver);
		addBookingForm.clickonWalkins();
		addBookingForm.openOptionsMenu();
		addBookingForm.clickonAddBooking();
		addBookingForm.enterTowerName("Tower " + Random("A", 1));
		addBookingForm.enterUnitName(Random("A", 1) + "-" + Random("N", 3));
		addBookingForm.enterUnitConfiguration("2BHK");
		addBookingForm.enterConsiderationValue("6524000");

// Booked On and Tentative agreement date 
		// addBookingForm.clickonBookedOn("03/01/2024");
		addBookingForm.clickonTentativeAgreementDate("05/02/2024");
		addBookingForm.bookingSource("Channel");
		addBookingForm.managerSelection("Rocks");
		addBookingForm.submitForm();

//Got stuck in the handling prompt alert,  Not resolved...  
		// addBookingForm.handleConfirmationPopup();

	}

}

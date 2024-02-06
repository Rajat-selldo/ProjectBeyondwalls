package basicCPFlow;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddWalkin;
import pom.userActions.LoginPage;

public class AddWalkIn extends BaseTest {

	@Test
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
		addWalkinForm.datePicker("05/02/2024", "03:30");
		addWalkinForm.clickonSave();
		System.out.println("Walkin added successfully.");
	}

}

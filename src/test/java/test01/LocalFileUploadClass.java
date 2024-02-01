package test01;

import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.Cpregistration;
import pom.userActions.LoginPage;

public class LocalFileUploadClass extends BaseTest {

	@Test
	public void logIn() throws InterruptedException, IOException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916974814923");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();

		Cpregistration register = new Cpregistration(driver);
		register.clickonUploadDocs();
		// Upload Documents
		register.uploads();
		register.submitApplication();
		register.clickonConfirmation();

	}
}
package cpUserRegistration;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.Cpregistration;
import pom.userActions.LoginPage;

public class CpOnboardingwithExisting extends BaseTest {
	String newlyRegisteredCP;

	public void cpRegistration() {
		Cpregistration register = new Cpregistration(driver);
		register.clickonRegister();
		register.cpFirstName(Random("A", 8));
		register.cpLastName(Random("A", 8));
		newlyRegisteredCP = register.cpPhone("6" + Random("N", 9));
		register.cpEmail("raj" + Random("A", 4) + Random("N", 3) + "@mailinator.com");
		System.out.println("Newly registered user's Phone is - " + newlyRegisteredCP);
		register.submitForm();
		register.validatingSuccessMsg();
	}

//Need to run login method after registration to run the On-boarding method 											//(dependsOnMethods = "cpRegistration")
	public void logIn() throws InterruptedException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		// userCreds.clickonSignIn();
		userCreds.enterUserPhone(newlyRegisteredCP);
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}

	@Test
	public void cpOnboardingwithExisting() throws InterruptedException {
//Run login with same signed up CP user then run the following script 
		cpRegistration();
		logIn();
		Cpregistration register = new Cpregistration(driver);
		register.clickoncompanyName("JoyBoy");
		register.clickonProceed();

	}

}

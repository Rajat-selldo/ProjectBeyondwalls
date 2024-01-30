package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.Cpregistration;
import pom.userActions.LoginPage;

public class CPuserRegistration extends BaseTest {
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

	@Test
	public void cpOnboardingwithNew() throws InterruptedException, IOException {
//Run login with same signed up CP user then run the following script 
		cpRegistration();
		logIn();
		Cpregistration register = new Cpregistration(driver);
		// Form One
		register.clickonRegisterNewCompany();
		register.entercpCompanyName("Company " + Random("A", 6) + " " + Random("AN", 5));
		register.enterPanNumber("AAAAK" + Random("N", 4) + Random("A", 1));
		register.enterReraid(Random("A", 1) + Random("N", 11));
		register.clickonProceed();

		// Form Two
		register.enterOwnerName(Random("A", 5) + Random("A", 6));
		register.enterOwnerPhone("7" + Random("N", 9));
		register.selectTeamSize(Random("N", 2));
		register.enteravgbusiness(Random("N", 10));
		register.selectCity("Pune");
		register.selectRegion("Wakad");
		register.selectManager("Rajat");
		register.clickonSave();

		// Form Three - Company Details Form
		register.selectFirmExpertise("Rentals");
		register.selectFirmExpertise("Residential");
		// register.enterGstNumber(Random("A",2) +
		// Random("A",5)+Random("N",4)+Random("A",1) + Random("N",1) + Random("A",1) +
		// Random("N",1));
		register.selectExperience("1-5");
		register.selectDevelopers("godrej");
		register.selectDevelopers("Mahindra");
		register.selectDevelopers("Realty");
		register.selectServices("Mandates");
		register.selectServices("Lead");
		// Bank Details
		register.enterBankName("Bank of " + Random("A", 8));
		register.enterBranchName(Random("A", 6) + " Branch");
		register.selectAccountType("Savings"); // Current
		register.enterIfscCode(Random("A", 4) + Random("N", 5));
		register.enterAccHolderName(Random("A", 5) + Random("A", 6));
		register.enterAccountNumber("000" + Random("N", 8));
		register.clickonSave();

		// Upload Documents
		register.clickonUpload();
		register.submitApplication();
		register.clickonConfirmation();
	//	register.uploads(); 
	}

}

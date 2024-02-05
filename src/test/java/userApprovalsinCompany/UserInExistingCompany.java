package userApprovalsinCompany;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import userApprovalinCompany.userInExistingCompany;

public class UserInExistingCompany extends BaseTest {

	public void logIn() throws InterruptedException {
		// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916200000001");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}

	@Test
	public void approveCP() throws InterruptedException {
		logIn();
		userInExistingCompany user = new userInExistingCompany(driver);
		// logIn();
		user.goToUserAccounts();
		user.clickOnUserRequests();
		user.clickonEllipsis();
		user.clickonapproveorreject();
		user.approveorReject("approve");
		user.clickOnSave();

	}

}

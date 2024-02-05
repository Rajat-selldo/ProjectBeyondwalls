package userApprovalsinCompany;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import userApprovalinCompany.approvalofPartnerCompany;

public class ApprovalofPartnerCompany extends BaseTest {

	public void logIn() throws InterruptedException {
		// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}

	@Test
	public void approveCompany() throws InterruptedException {
		logIn();
		approvalofPartnerCompany approveCompany = new approvalofPartnerCompany(driver);
		approveCompany.clickPartnerCompanies();
		approveCompany.clickonEllipsis();
		approveCompany.clickonEditpc();
		approveCompany.enterApplicationStatus("approve");
		approveCompany.clickonSave();
		System.out.println("Company Approved");
	}
	
	public void rejectCompany() throws InterruptedException {
		logIn();
		approvalofPartnerCompany rejectCompany = new approvalofPartnerCompany(driver);
		rejectCompany.clickPartnerCompanies();
		rejectCompany.clickonEllipsis();
		rejectCompany.clickonEditpc();
		rejectCompany.enterApplicationStatus("reject");
		rejectCompany.clickonSave();
		System.out.println("Company Rejected");
	}

}

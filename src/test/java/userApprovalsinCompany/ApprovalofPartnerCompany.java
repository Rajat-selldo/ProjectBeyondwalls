package userApprovalsinCompany;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import userApprovalinCompany.approvalofPartnerCompany;

public class ApprovalofPartnerCompany extends BaseTest {

	@Test
	public void approveCompany() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		approvalofPartnerCompany approveCompany = new approvalofPartnerCompany(driver);
		approveCompany.clickPartnerCompanies();
		approveCompany.clickonEllipsis();
		approveCompany.clickonEditpc();
		approveCompany.enterApplicationStatus("approve");
		approveCompany.clickonSave();
		System.out.println("Company Approved");
	}

}

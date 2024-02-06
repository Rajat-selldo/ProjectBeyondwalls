package userApprovalsinCompany;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import userApprovalinCompany.approvalofPartnerCompany;

public class RejectCompany extends BaseTest {

	public void rejectCompany() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		approvalofPartnerCompany rejectCompany = new approvalofPartnerCompany(driver);
		rejectCompany.clickPartnerCompanies();
		rejectCompany.clickonEllipsis();
		rejectCompany.clickonEditpc();
		rejectCompany.enterApplicationStatus("reject");
		rejectCompany.clickonSave();
		System.out.println("Company Rejected");
	}

}

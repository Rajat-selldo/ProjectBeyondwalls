package userApprovalsinCompany;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import userApprovalinCompany.userInExistingCompany;

public class UserInExistingCompany extends BaseTest {

	@Test
	public void approveCP() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("ownersPhone1")); // Use company owner's phone no. in which new CP is registered by using
												// CpOnboardingwithExisting.cpOnboardingwithExisting
		userInExistingCompany user = new userInExistingCompany(driver);
		user.goToUserAccounts();
		user.clickOnUserRequests();
		user.clickonEllipsis();
		user.clickonapproveorreject();
		user.approveorReject("approve");
		user.clickOnSave();

	}

}

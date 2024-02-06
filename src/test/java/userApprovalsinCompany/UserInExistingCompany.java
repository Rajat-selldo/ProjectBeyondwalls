package userApprovalsinCompany;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import userApprovalinCompany.userInExistingCompany;

public class UserInExistingCompany extends BaseTest {

	@Test
	public void approveCP() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("ownersPhone1"));
		userInExistingCompany user = new userInExistingCompany(driver);
		user.goToUserAccounts();
		user.clickOnUserRequests();
		user.clickonEllipsis();
		user.clickonapproveorreject();
		user.approveorReject("approve");
		user.clickOnSave();

	}

}

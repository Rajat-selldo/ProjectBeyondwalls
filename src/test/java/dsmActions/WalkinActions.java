package dsmActions;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromDsm;
import pom.userActions.LoginPage;

public class WalkinActions extends BaseTest {

// DSM actions like Walk-in Details, Approve/Reject Walk-in, etc. on the Walk-ins 	
	@Test
	public void walkinActions() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("dsmPune"));
		ActionsFromDsm dsmUser = new ActionsFromDsm(driver);
		dsmUser.goToWalkins();
		dsmUser.clickonEllipsis();
		dsmUser.clickonWalkinDetails();
//		dsmUser.approveWalkin();
//		dsmUser.rejectWalkin();
//		dsmUser.clickonwalkinDocuments();

	}


}

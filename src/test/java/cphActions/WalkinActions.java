package cphActions;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromCph;
import pom.userActions.LoginPage;

public class WalkinActions extends BaseTest {

//CPH actions on Walk-in such as Walk-in Details, BW Approve/Reject 	
	@Test
	public void walkinActions() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cphPune"));
		ActionsFromCph cphUser = new ActionsFromCph(driver);
		cphUser.clickonWalkinLink();
		cphUser.clickonEllipsis();
		cphUser.walkindetails();

	}

}

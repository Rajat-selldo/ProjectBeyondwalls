package rechargeWallet;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class EditProject extends BaseTest {

	@Test
	public void TC04() {
//4. Edit Project 
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickOnEditProject();
		recharge.clickOnWalletNotifications();
		recharge.enterLowBalanceLimit("10000");
		recharge.selectInsuffucientBalance();

		recharge.clickOnSave();

	}

}

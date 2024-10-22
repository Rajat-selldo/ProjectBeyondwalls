package rechargeWallet;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class TransferWalletBalance extends BaseTest {

	@Test
	public void TC02() throws InterruptedException {
//2. Transfer Wallet Balance
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonTransferBalance();
		recharge.enterAmount("1700");
		recharge.selectProject("KJ Towers");
		recharge.clickOnSave();

	}
}

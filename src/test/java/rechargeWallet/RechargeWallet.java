package rechargeWallet;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class RechargeWallet extends BaseTest {

	@Test
	public void TC01() {
//1. Recharge Wallet 
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonRechargeWallet();
		recharge.selectPaymentMode("Online");
		recharge.enterCampaignFrom("21/02/2040");
		recharge.enterCampaignTo("22/02/2040");
		recharge.enterSvCount("1");
		recharge.enterSvIncentive("100");
		recharge.enterSbCount("1");
		recharge.enterSbIncentive("500");

		recharge.clickOnSave();
		recharge.razorPayFlow();
	}

}

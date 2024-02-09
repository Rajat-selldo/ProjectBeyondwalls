package rechargeWallet;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class RechargeWallet extends BaseTest {

	@Test
	public void rechargeProjectWallet() {
//1. Recharge Wallet 
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonRechargeWallet();
		recharge.selectPaymentMode("Online");
		recharge.enterCampaignFrom("03/03/2040");	//Change when u run the suite 
		recharge.enterCampaignTo("04/03/2040");		//Change when u run the suite 
		recharge.enterSvCount("1");
		recharge.enterSvIncentive("100");
		recharge.enterSbCount("1");
		recharge.enterSbIncentive("500");
		recharge.clickOnSave();
		recharge.razorPayFlow();
	}

}

package test01;

import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class LocalFileUploadClass extends BaseTest {

	@Test
	public void logIn() throws InterruptedException, IOException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();

		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonRechargeWallet();
		recharge.selectPaymentMode("Online");
		recharge.enterCampaignFrom("01/02/2040");

		
		//New code added temp.
		
	}
}
package testScripts;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class RechargeWallet extends BaseTest {

	@Test
	public void TC01() {
//1. Recharge Wallet 
		// Login with Administrator user
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonRechargeWallet();
		//recharge.selectPaymentMode("Online");
		recharge.enterCampaignFrom("01/02/2040");
		recharge.enterCampaignTo("02/02/2040");
		recharge.enterSvCount("1");
		recharge.enterSvIncentive("100");
		recharge.enterSbCount("1");
		recharge.enterSbIncentive("500");
		
		recharge.clickOnSave();

	}
	
	@Test
	public void TC02() throws InterruptedException {
//2. Transfer Wallet Balance
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
		
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonTransferBalance();
		recharge.enterAmount("1700");
		recharge.selectProject("KJ Towers");
		recharge.clickOnSave();

	}
	
	public void TC03() {
//3. Edit incentives 
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
		
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonEditIncetive();
		recharge.enterSvAbsoluteValue("1000");
		recharge.enterBookingAbsoluteValue("3000");
				
		recharge.clickOnSave();

	}
	
	public void TC04() {
//4. Edit Project 
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
		
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

package rechargeWallet;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.WalletRecharge;

public class EditIncentives extends BaseTest {

	@Test
	public void TC03() {
//3. Edit incentives 
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		WalletRecharge recharge = new WalletRecharge(driver);
		recharge.clickonProjects();
		recharge.clickonEllipsis();
		recharge.clickonEditIncetive();
		recharge.enterSvAbsoluteValue("1000");
		recharge.enterBookingAbsoluteValue("3000");

		recharge.clickOnSave();

	}

}

package test01;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.ActionsFromDsm;
import pom.userActions.AddWalkin;
import pom.userActions.Cpregistration;
import pom.userActions.LoginPage;

public class LocalFileUploadClass extends BaseTest {

	@Test
	public void logIn() throws InterruptedException, IOException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+916200000001");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();

		AddWalkin addWalkinForm = new AddWalkin(driver);
		addWalkinForm.goToWalkins();

		ActionsFromDsm actionsfromDsm = new ActionsFromDsm(driver);
		actionsfromDsm.clickonEllipsis();
		actionsfromDsm.clickonwalkinDocuments();

		Cpregistration cpreg = new Cpregistration(driver);
//		cpreg.clickonUpload();
		cpreg.uploads();
		Thread.sleep(5000);
//File upload method used with AutoIT tool 
//		String ary []= {"D://BW Automation//AutoIT//walkinDocUpload3_x64.exe"};
//	Runtime.getRuntime().exec("D://BW Automation//AutoIT//walkinDocUpload3_x64.exe");
		Desktop.getDesktop().open(new File(System.getProperty("user.dir")+"//AutoIT//walkinDocUpload3_x64.exe"));
		
	}
}
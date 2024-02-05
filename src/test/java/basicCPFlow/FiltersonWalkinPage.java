package testScripts;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.FiltersonWalkinsListing;
import pom.userActions.LoginPage;

public class FiltersonWalkinPage extends BaseTest {

	//Not working right, need changes 
	//Page is getting refreshed when filter page is opened 
	
	@Test
	public void TC01() {
//Login with Administrator User 	
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

		FiltersonWalkinsListing checkFilters = new FiltersonWalkinsListing(driver);
		checkFilters.gotoWalkins();
		checkFilters.clickonFilter();
		//checkFilters.enterNameEmailorPhone("Jeremy");
		checkFilters.selectProjectname2("Malpani");
		checkFilters.selectApprovalStatus("Approved");
		checkFilters.selectChannelPartner("Joy boy");
//		checkFilters.enterConductedOndate("10/10/2023-30/12/2023");
		
		checkFilters.applyFilter();

	}
	
	public void TC02() {
		//Write a TC for testing that selected approval status walk-ins are present on the filtered page or not 
		
	}
	

}

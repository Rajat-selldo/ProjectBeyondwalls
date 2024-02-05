package checkingFilters;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.FiltersonBrokerageListing;
import pom.userActions.LoginPage;

public class FiltersonBrokeragePage extends BaseTest {
	
	public void logIn() {
		//Login with Administrator User 	
				LoginPage userCreds = new LoginPage(driver);
				userCreds.clickonSignIn();
				userCreds.enterUserPhone("+919090909091");
				userCreds.clickonGetOtp();
				userCreds.enterUserOtp("000000");
				userCreds.clickonverify();
				System.out.println("User logged in successfully with Phone + OTP.");
	}

	@Test
	public void TC01() {
		logIn();
		FiltersonBrokerageListing checkFilter = new FiltersonBrokerageListing(driver);
		checkFilter.gotoBrokerages();
		checkFilter.clickonFilter();
		checkFilter.selectProjectname2("Malpani");
//		checkFilter.selectbyStatus("Approved");
//		checkFilter.selectChannelPartner("Joy boy");
//		checkFilter.enterRaisedOn("10/10/2023-01/01/2024");
//		
		checkFilter.applyFilter();

	}

	public void TC02() {

		
	}

}

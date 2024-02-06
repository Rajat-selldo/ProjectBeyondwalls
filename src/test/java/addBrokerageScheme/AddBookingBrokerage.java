package addBrokerageScheme;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.addBrokerageScheme;

public class AddBrokerageScheme extends BaseTest {
	
	@Test
	public void logIn() throws InterruptedException {
// Login Flow
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");

	}

	@Test
	public void addWalkinBrokerage() throws InterruptedException {
		logIn();
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Walkin " + Random("AN",5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A",40) + Random("AN",20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("05/01/2024");
		addScheme.schemeEndsOn("15/01/2024");
		addScheme.selectResource("Walk-in");
		addScheme.selectWalkinType();
		addScheme.selectCategory("Walk-in");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A",20) + Random("AN",15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("500");
		addScheme.clickOnSave();
		
		//Need to add flow for multiple ladders 
	}
	
	public void addSpotBrokerage() throws InterruptedException {
		logIn();
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Spot " + Random("AN",5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A",40) + Random("AN",20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("10/01/2024");
		addScheme.schemeEndsOn("15/01/2024");
		addScheme.selectResource("Booking");
		addScheme.selectSpotBookingType();
		addScheme.selectCategory("Spot Booking");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A",20) + Random("AN",15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("1200");
		addScheme.clickOnSave();
		
		
	}
	
	public void addEveryBrokerage() throws InterruptedException {
		logIn();
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Every " + Random("AN",5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A",40) + Random("AN",20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("12/01/2024");
		addScheme.schemeEndsOn("15/01/2024");
		addScheme.selectResource("Booking");
		addScheme.selectEveryBookingType();
		addScheme.selectCategory("Spot Booking");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A",20) + Random("AN",15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("1000");
		addScheme.clickOnSave();
		
		
	}
	
	@Test
	public void addbothBrokerages() throws InterruptedException {
		logIn();
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Spot+Every " + Random("AN",5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A",40) + Random("AN",20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("21/01/2024");
		addScheme.schemeEndsOn("28/01/2024");
		addScheme.selectResource("Booking");
		addScheme.selectBookingTypeasAll();
		addScheme.selectCategory("Spot Booking");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A",20) + Random("AN",15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("800");
		addScheme.clickOnSave();
		
		
	}

	public void addBookingBrokerage() throws InterruptedException {
		logIn();
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Brokerage " + Random("AN",5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A",40) + Random("AN",20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("01/02/2024");
		addScheme.schemeEndsOn("15/02/2024");
		addScheme.selectResource("Booking");
		addScheme.selectBookingTypeasAll();
		addScheme.selectCategory("Booking Brokerage");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A",20) + Random("AN",15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("555");
		addScheme.clickOnSave();
		
		
	}

}

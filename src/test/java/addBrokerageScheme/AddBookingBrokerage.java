package addBrokerageScheme;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.addBrokerageScheme;

public class AddBookingBrokerage extends BaseTest {

	@Test
	public void addBookingBrokerage() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Brokerage " + Random("AN", 5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A", 40) + Random("AN", 20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("01/02/2024");
		addScheme.schemeEndsOn("15/02/2024");
		addScheme.selectResource("Booking");
		addScheme.selectBookingTypeasAll();
		addScheme.selectCategory("Booking Brokerage");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A", 20) + Random("AN", 15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("555");
		addScheme.clickOnSave();

	}

}

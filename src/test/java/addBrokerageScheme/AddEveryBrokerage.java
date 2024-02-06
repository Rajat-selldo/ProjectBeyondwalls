package addBrokerageScheme;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.addBrokerageScheme;

public class AddEveryBrokerage extends BaseTest {

	@Test
	public void addEveryBrokerage() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Every " + Random("AN", 5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A", 40) + Random("AN", 20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("12/01/2024");
		addScheme.schemeEndsOn("15/01/2024");
		addScheme.selectResource("Booking");
		addScheme.selectEveryBookingType();
		addScheme.selectCategory("Spot Booking");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A", 20) + Random("AN", 15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("1000");
		addScheme.clickOnSave();

	}

}

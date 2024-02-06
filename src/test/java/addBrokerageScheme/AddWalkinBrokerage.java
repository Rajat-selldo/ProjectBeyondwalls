package addBrokerageScheme;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.addBrokerageScheme;

public class AddWalkinBrokerage extends BaseTest {

	@Test
	public void addWalkinBrokerage() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		addBrokerageScheme addScheme = new addBrokerageScheme(driver);
		addScheme.clickOnMore();
		addScheme.clickonBrokerageSchemes();
		addScheme.clickonAddScheme();
		addScheme.enterSchemeName("SCheme QA-Walkin " + Random("AN", 5));
		addScheme.enterDescription("Scheme Name Automated " + Random("A", 40) + Random("AN", 20));
		addScheme.enterCityName("Pune");
		addScheme.enterProjectName("Sommet");
		addScheme.schemeStartsOn("05/01/2024");
		addScheme.schemeEndsOn("15/01/2024");
		addScheme.selectResource("Walk-in");
		addScheme.selectWalkinType();
		addScheme.selectCategory("Walk-in");
		addScheme.enterTermsNConditions("Scheme T&C's Automated " + Random("A", 20) + Random("AN", 15));
		addScheme.enterLadderStartValue("1");
//		addScheme.enterLadderEndValue("");
		addScheme.enterLadderAbsValue("500");
		addScheme.clickOnSave();

		// Need to add flow for multiple ladders
	}

}

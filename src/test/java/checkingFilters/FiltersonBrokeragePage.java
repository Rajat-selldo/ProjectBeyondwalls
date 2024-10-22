package checkingFilters;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.FiltersonBrokerageListing;
import pom.userActions.LoginPage;

public class FiltersonBrokeragePage extends BaseTest {

	@Test
	public void TC01() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		FiltersonBrokerageListing checkFilter = new FiltersonBrokerageListing(driver);
		checkFilter.gotoBrokerages();
		checkFilter.clickonFilter();
		checkFilter.selectProjectname2("Malpani");
//		checkFilter.selectbyStatus("Approved");
//		checkFilter.selectChannelPartner("Joy boy");
//		checkFilter.enterRaisedOn("10/10/2023-01/01/2024");	
		checkFilter.applyFilter();

	}

}

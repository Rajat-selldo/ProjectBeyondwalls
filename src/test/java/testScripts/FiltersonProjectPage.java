package testScripts;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.AddProject;
import pom.userActions.FiltersonProjectListing;
import pom.userActions.LoginPage;

public class FiltersonProjectPage extends BaseTest {

// Need to login with Administrator user and redirect to Projects page 	
	public void logIn() throws InterruptedException {
		LoginPage userCreds = new LoginPage(driver);
		userCreds.clickonSignIn();
		userCreds.enterUserPhone("+919090909091");
		userCreds.clickonGetOtp();
		userCreds.enterUserOtp("000000");
		userCreds.clickonverify();
		System.out.println("User logged in successfully with Phone + OTP.");
	}
	
	
	@Test
	public void checkFilters() throws InterruptedException {
		logIn();
		AddProject gotoProjects = new AddProject(driver);
		gotoProjects.clickonProjects();
		FiltersonProjectListing checkFilters = new FiltersonProjectListing(driver);
		checkFilters.clickonFilter();
		// checkFilters.selectProjectname("66 Avenue (Pune)");
		checkFilters.selectCityname("Pune");
		checkFilters.selectRegionname("Wakad + Baner + Pashan-Sus");
		checkFilters.enterpossessionDate("10/11/2023-10/01/2024");
		checkFilters.applyFilter();

	}

	// TC-02 : Loop is not working in TC02 method
	@Test
	public void checkInactiveProjects()throws InterruptedException {
		logIn();
		FiltersonProjectListing TC02 = new FiltersonProjectListing(driver);
		TC02.clickonProjects();
		TC02.clickonFilter();
		TC02.selectProjectname("Bliss (Pune) (Inactive)");
		TC02.applyFilter();
		TC02.verifyProjects("Bliss (Pune) (Inactive)");

	}

	// TC-03 : Test case for checking possesionDate Filter
	@Test
	public void checkPossessionDate()throws InterruptedException {
		logIn();
		FiltersonProjectListing TC03 = new FiltersonProjectListing(driver);
		TC03.clickonProjects();
		TC03.clickonFilter();
		TC03.enterpossessionDate("01/12/2022 - 01/01/2024");
		TC03.applyFilter();
		TC03.verifyProjects("Malpani Cereza (Pune)");

	}

}

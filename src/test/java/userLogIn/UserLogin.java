package userLogIn;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;

public class UserLogin extends BaseTest {

	@Test
	public void logIn() throws InterruptedException {
// Login Flow
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cpPhone2"));
	}

	public void logOut() throws InterruptedException {
		logIn();
//Log out flow
		LoginPage logInPage = new LoginPage(driver);
		logInPage.clickonProfile();
		logInPage.clickonSignout();
		System.out.println("User logged out successfully.");

	}

}

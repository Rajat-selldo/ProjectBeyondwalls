package addInternalUser;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.LoginPage;
import pom.userActions.UserCreation;

public class AddUsers extends BaseTest {

	@Test
	public void addUsers() throws InterruptedException {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("adminPhone"));
		UserCreation addUser = new UserCreation(driver);
		addUser.clickonUserAccounts();
		addUser.clickonAddUser();
		addUser.listAllUsers("Add Channel Partner Head");
		addUser.enterFirstName(Random("A", 6));
		addUser.enterLastName(Random("A", 6));
		addUser.enterEmail("raj" + Random("AN", 8) + "@mailinator.com");
		addUser.enterPhone("79" + Random("N", 8));
		addUser.selectCity("Bangalore");
		addUser.selectRegion("Basavanagudi");

		// Write a if else block for project selection method cause for some users field
		// is not displayed on the form
		addUser.selectProject("Demo");
		addUser.clickonSave();

	}

}

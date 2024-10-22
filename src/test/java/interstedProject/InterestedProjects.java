package interstedProject;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.InterestedProject;
import pom.userActions.LoginPage;

public class InterestedProjects extends BaseTest {

	public void markProject() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cpPhone2"));
		InterestedProject subscribeProject = new InterestedProject(driver);
		subscribeProject.clickonProjects();
		subscribeProject.clickonInterestedProjects();
		subscribeProject.clickonInterestedProjects();

//Remained to add script for checking whether subscribed project is added to the interested project section or not

	}

}

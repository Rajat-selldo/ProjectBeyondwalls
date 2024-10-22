package interstedProject;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.InterestedProject;
import pom.userActions.LoginPage;

public class InterestedProjects extends BaseTest {

	public void markProject1() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cpPhone2"));
		InterestedProject subscribeProject = new InterestedProject(driver);
		subscribeProject.clickonProjects();
		subscribeProject.clickonInterestedProjects();
		subscribeProject.clickonInterestedProjects();

//Remained to add script for checking whether subscribed project is added to the interested project section or not
	}

	@Test
	public void markProject() {
		LoginPage logInPage = new LoginPage(driver);
		logInPage.logIn(prop("cpPhone3"));
		InterestedProject subscribeProject = new InterestedProject(driver);
		subscribeProject.clickonProjects();
		subscribeProject.clickonSubscribe("Sommet");

// Not working every-time, need to fix 
		subscribeProject.verifyInterestedProject();

	}

}

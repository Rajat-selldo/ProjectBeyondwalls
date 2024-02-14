package interstedProject;

import org.testng.annotations.Test;

import pom.beyondwalls.utility.BaseTest;
import pom.userActions.InterestedProject;
import pom.userActions.LoginPage;

public class InterestedProjects extends BaseTest {

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
